import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import javax.swing.plaf.nimbus.State;
import javax.xml.bind.annotation.XmlElement.DEFAULT;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class LoopStructureTesting {

	@Rule     
	public final ExpectedSystemExit exit = ExpectedSystemExit.none();

	
	
	@Test
    public void successorsBypass(){
        //If i bypass loop the result will be an empty list
        //The only way to bypass loop is to have a board with no children.
        Board noChildrenBoard = new Board("A");
        Astar.State state = new Astar.State(noChildrenBoard,null);
        Astar dummyObj = new Astar();
        List<Astar.State> listSuccessorStates = dummyObj.sucessors(state);
        assertTrue("List should be empty", listSuccessorStates.isEmpty());
    
    }

    @Test
    public void successorsEnterLoopOnce(){
        //If the board only has one child, it should only enter loop once
        Board boardWithOneChild = new Board("AB");
        Astar.State state = new Astar.State(boardWithOneChild,null);
        Astar dummyObj = new Astar();
        List<Astar.State> listSuccessorStates = dummyObj.sucessors(state);
        System.out.println(listSuccessorStates.toString());
        assertTrue("List should only contain one member",listSuccessorStates.size()==1);
        
    }   

    @Test
    public void successorsEnterLoopTwice(){
        //If the board only has one child, it should only enter loop once
        Board boardWithTwoChild = new Board("A B");
        Astar.State state = new Astar.State(boardWithTwoChild,null);
        Astar dummyObj = new Astar();
        List<Astar.State> listSuccessorStates = dummyObj.sucessors(state);
        System.out.println(listSuccessorStates.toString());

        assertTrue("List should only contain one member",listSuccessorStates.size()==2);
    }

    @Test
    public void successorsEnterLoopTypical(){
        //If the board only has two children, it should only enter loop twice
        Board boardWithTypical = new Board("AB C DEF");
        /*
        AB C DEF
        A B C DEF
        A CB DEF
        A C DEFB
        ABC DEF
        AB DEFC
        ABF C DE
        AB F C DE
        AB CF DE
        */
        Astar.State state = new Astar.State(boardWithTypical,null);
        Astar dummyObj = new Astar();
        List<Astar.State> listSuccessorStates = dummyObj.sucessors(state);
        System.out.println(listSuccessorStates.toString());

        assertTrue("List should only contain one member",listSuccessorStates.size()==8);
    }
    /*
    * 5, 6 and 7 are impossible for sucessor function, seen as it loops according to the number of child boards and not a fixed number
    */
//////////////////////////////// SOLVE ////////////////////////////////
//1 - first while is impossible to skip, it will always run once, hardcoded
//
    @Test
    public void solveOnceFirstLoopBypassSecondAndThird(){
        Astar dummyObj = new Astar();
        Board start = new Board("A");
        Board goal = new Board("A");
        //To enter the while Loop once implies the goal being the current node
        Iterator<Astar.State> itr = dummyObj.solve(start,goal);
        int itrSize = 0;
        while(itr.hasNext()){
            itrSize++;
            itr.next();
        }
        assertTrue("Solve should only return 1 layouts in the iterator", itrSize == 1);
    }
    @Test
    public void solveOnceSecondThirdLoopsTwiceFirstLoop(){
        Astar dummyObj = new Astar();
        Board start = new Board("AB");
        Board goal = new Board("A B");
        //To enter the second and third once implies the goal being a child of the current node and the current node having only one child
        //This also 
        Iterator<Astar.State> itr = dummyObj.solve(start,goal);
        int itrSize = 0;
        while(itr.hasNext()){
            itrSize++;
            itr.next();
        }
        assertTrue("Solve should only return two layouts in the iterator", itrSize == 2);
    }
    @Test
    public void solveTwiceSecondLoop(){
        Astar dummyObj = new Astar();
        Board start = new Board("A B");
        Board goal = new Board("BA");
        
        Iterator<Astar.State> itr = dummyObj.solve(start,goal);
        int itrSize = 0;
        while(itr.hasNext()){
            itrSize++;
            itr.next();
        }
        assertTrue("Solve should only return two layouts in the iterator", itrSize == 2);
    }

    @Test
    public void solveTwiceThirdLoop(){
        Astar dummyObj = new Astar();
        Board start = new Board("A B C");
        Board goal = new Board("ABC");
        
        Iterator<Astar.State> itr = dummyObj.solve(start,goal);
        int itrSize = 0;
        while(itr.hasNext()){
            itrSize++;
            itr.next();
        }
        assertTrue("Solve should only return two layouts in the iterator", itrSize == 3);
    }



    @Test
    public void solveTypicalSecondLoop(){
        Astar dummyObj = new Astar();
        Board start = new Board("ABC D F");
        Board goal = new Board("AFD B C");

        Iterator<Astar.State> itr = dummyObj.solve(start,goal);
        int itrSize = 0;
        while(itr.hasNext()){
            itrSize++;
            itr.next();
        }
        assertTrue("Solve should only return 5 layouts in the iterator", itrSize == 5);
    }


}

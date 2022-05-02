import static org.junit.Assert.assertEquals;
import java.util.Iterator;

import org.junit.Test;

public class tests {

	@Test
	public void testTime() {
		long startTime = System.nanoTime();
		Board b = new Board("ABCDEFG");
		Astar b_astar = new Astar();
		b_astar.solve(b, new Board("GBCDEFA"));
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println((double) totalTime / 1_000_000_000.0);
	}
	
	
	
	@Test
	public void testTime2() {
		long startTime = System.nanoTime();
		Board b = new Board("ABCDEFG");
		Astar b_astar = new Astar();
		b_astar.solve(b, new Board("GBCDEFA"));
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println((double) totalTime / 1_000_000_000.0);
	}
	
	@Test
	public void testTime3() {
		long startTime = System.nanoTime();
		Board b = new Board("GF EDC B A");
		Astar b_astar = new Astar();
		b_astar.solve(b, new Board("ABCDEFG"));
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println();
		System.out.println((double) totalTime / 1_000_000.0);
	}
	
	

	@Test
	public void testTime4() {
		long startTime = System.nanoTime();
		Board b = new Board("FACE BDX");
		Astar b_astar = new Astar();
		b_astar.solve(b, new Board("FBCDEAX"));
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println((double) totalTime / 1_000_000_000.0);
	}
	
	
	@Test(timeout=120000)
	public void testTime8() {
		long startTime = System.nanoTime();
		Board b = new Board("ABCDEFGHIJ");
		Astar b_astar = new Astar();
        System.out.println(b_astar.solve(b, new Board("DEAJCHGIFB")));
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println((double) totalTime / 1_000_000_000.0);
	}
		
	@Test
	public void testTime5() {
		long startTime = System.nanoTime();
		Board b = new Board("ABCDEFG");
		Astar b_astar = new Astar();
		b_astar.solve(b, new Board("BCDEFGA"));
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println((double) totalTime / 1_000_000.0);
	}
	
	@Test
    public void test5() throws CloneNotSupportedException {
        long startTime = System.nanoTime();
        Board b=new Board("FACE BDX");
        Board b2=new Board("FBCDEAX");
        Astar s = new Astar();
        // Iterator it = s.solve(b,b2);
        // System.out.println(it);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("t1:"+(double) duration / 1_000_000_000.0 +" s");
    }
	
	
	@Test
	public void testTime10() {
		long startTime = System.nanoTime();
		Board b = new Board("ABCDEFGHIJKLMOPQRSTUVXZ");
		Astar b_astar = new Astar();
		b_astar.solve(b, new Board("ZBCDEFGHIJKLMOPQRSTUVXA"));
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println((double) totalTime / 1_000_000.0);
	}
	

}

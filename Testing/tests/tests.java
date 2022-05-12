import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import javax.swing.plaf.nimbus.State;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class tests {

	@Rule     
	public final ExpectedSystemExit exit = ExpectedSystemExit.none();

	
	
	@Test
	public void testEqualsp1() {
		//boards sao vazias
        Board initial = new Board("");
        Board l1 = new Board("");
        assertEquals(initial,l1);//initial.equals(l1)
    }

	@Test
	public void testEqualsp2() {
		//boards sao diferentes
        Board initial = new Board("AB C D");
        Board l1 = new Board("AC B D");
        assertNotEquals(initial,l1);//initial.equals(l1)
		
    }

	@Test
	public void testEqualsp3() {
		//boards sao iguais
        Board initial = new Board("AB C D");
        Board l1 = new Board("AB D C");
        assertEquals(initial,l1);//initial.equals(l1)
    }

	@Test
	public void testesucsp1() {
		//Ilayout l, State n
		//Ilayout -> passar uma board

		/*
		Ilayout l, State n
		*/
		//n entra no if
		Board board = new Board("A");
		Astar.State pai = new Astar.State(board,null);
		Astar.State filho = new Astar.State(new Board("A"),pai);
		//List<State> esperado =null;
		Astar alg = new Astar();
		List<Astar.State> res = alg.sucessors(filho) ;
		
		assertEquals(res.size(),0);

	}

	@Test
	public void testesucsp2() {
		//Ilayout l, State n
		//Ilayout -> passar uma board

		/*
		Ilayout l, State n
		*/
		//entra no if pq pai == null
		Board board = new Board("A B");
		
		Astar.State pai = new Astar.State(board,null);
		Astar alg = new Astar();

		List<Astar.State> res = alg.sucessors(pai) ;

		Board boardesperado = new Board("AB");
		Board boardesperado2 = new Board("BA");

		assertEquals(res.size(),2);
		
		assertEquals(boardesperado,res.get(1).getBoard());

		assertEquals(boardesperado2, res.get(0).getBoard());
	
	}
	
	@Test
	public void testeboardp3p4() {
		//entra no if pq !e.equals(n.father.layout)
		//so dois elementos nao passa no teste
		Board boardpai = new Board("A B C");
		//AB C  A BC  A CB  BA C  AC B  CA B 
		Board boardfilho = new Board("AB C");
		//
		Astar.State pai = new Astar.State(boardpai,null);
		Astar.State filho = new Astar.State(boardfilho,pai);

		Astar alg = new Astar();

		List<Astar.State> res = alg.sucessors(filho) ;

		Board boardesperado = new Board("ABC");
		Board boardesperado2 = new Board("A CB");

		assertEquals(res.size(),2);
		assertEquals(boardesperado,res.get(1).getBoard());
		assertEquals(boardesperado2, res.get(0).getBoard());
	}

	//solve caminho p2

	@Test
	public void testsolvep2() {
		
		Board boardinicial = new Board("AB ");
		Board boardobjetivo = new Board("ABCD");

		Astar alg = new Astar();

		exit.expectSystemExitWithStatus(0);
		Iterator<Astar.State> resultado = alg.solve(boardinicial,boardobjetivo);

		//
		}

		@Test
		public void testsolvep3p4p5p6p7() {
			
			Board boardinicial = new Board("A CB"); //Declara a Board Inicial 

			Board boardobjetivo = new Board("AC B"); //Declara a Board Final
	
			Astar alg = new Astar(); //Declara um objeto da Classe Astar a partir da qual se vai executar o algoritmo
	
			Iterator<Astar.State> resultado = alg.solve(boardinicial,boardobjetivo); //Executa o algoritmo para resolver o problema
			assertEquals(resultado.next().getBoard(),boardinicial); //Verifica se o primeiro elemento da sequencia de saida esta correto
			assertEquals(resultado.next().getBoard(),new Board("A B C")); //Verifica se o segundo elemento da sequencia de saida esta correto
			Astar.State lastState = null; // Guarda o ultimo estado para se puder verificar tambem o custo final
			assertEquals((lastState = resultado.next()).getBoard(),boardobjetivo); // Verifica se o ultimo elemento da sequencia de saida esta correto, i.e, e igual ao objetivo
			assertTrue(2 == lastState.getG()); //Verifica se o custo total das operacoes e igual a 2.
			/* What the test does
			* Declaramos uma board inicial "A CB" com o objetivo de percorrer varios nos, em primeiro lugar adicionamos a board inicial a lista de abertos,
			* So corremos o ciclo enquanto nao encontrarmos goal, ou caso a list de abertos nao esteja vazia, como inicialmente adicionamos a board inicial, esta nao vai estar vazia logo seguimos o caminho 1-3-5
			* no no 5 verificamos se e goal a board actual (atual e a ultima que retiramos da lista de abertos, neste caso a inicial), em 6 , 8, 10 criamos todos os sucessores da atual, fechamos a atual porque depois dos filhos nao ha mais nada a fazer com ela
			* a seguir em 11 percorre-se os sucessores e caso estes nao tenham sido vistos anteriormente (i.e, estejam na lista fechados) adicionamos a list abertos
			* Quando nao houver o mais sucessores repetimos o processo das linhas anteriores. Quando encontrarmos o goal, vamos retrocedendo nas boards ( funcionam como uma linked list q vai ao contrario) ate chegar a inicial,
			* esta sequencia e adicionada a outSequence ate que ja nao seja possivel andar para tras, ficando esta orientada da board inicial a final
			* finalmente retorna-se um iterador para esta sequencia.
			*
			*/
			
			
			//
			//AB CD | A BCD | AC B D | A BC D | B ACD | 
			//
			}
			


/* 
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
	 */

}

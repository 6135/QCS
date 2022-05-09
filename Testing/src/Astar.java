import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Astar {
	static class State {
		private Ilayout layout;
		private State father;
		private double g;
		
		public State(Ilayout l, State n) {
			layout = l;
			father = n;
			if (father != null) {
				g = father.g + l.getG();
			}	
			else
				g = 0.0;
		}

		public Ilayout getBoard(){
			return layout;
		}

		public String toString() {
			return layout.toString();
		}

		public double getG() {
			return g;
		}
		public double getH(Ilayout goal) { //blocos mal posicionados
            return this.layout.getH(goal);
        }

        public double getF(Ilayout goal) { //heuristica em que o menor tende para o melhor caminho
            return getH(goal) + getG();
        }

	}

	protected Queue<State> abertos;
	private State actual;
	//this one
	final public List<State> sucessors(State n) {
		List<State> sucs = new ArrayList<>();
		List<Ilayout> children = n.layout.children();
		for (Ilayout e : children) {
			if (n.father == null || !e.equals(n.father.layout)) {
				State nn = new State(e,n);
				sucs.add(nn);
			}
		}
		return sucs;
	}
	


	//This one
	final public Iterator<State> solve(Ilayout s, Ilayout goal) {
		Queue<State> abertos = new PriorityQueue<>(10, (s1, s2) -> (int) Math.signum(s1.getF(goal) - s2.getF(goal)));
		List<State> fechados = new ArrayList<>();
		abertos.add(new State(s, null));
		List<State> sucs;
		List<State> outsequence = new ArrayList<>();
		boolean end = false;
		while (!end) {
			try {
				if (abertos.isEmpty())
					throw new Exception();//terminar programa caso nao haja caminhos possiveis a fazer (board sem filhos)
					//lista d abertos vazia
						//se n adicionaste nada no inicio
						//filhos da board sao filhos q ja foram visitados (ja estao na lista de fechados)para isso acontecer
					//precisaria de????
						//board goal maior que a inicial (com maior dimensao q a original), a 2 vai rapidamente gerar todas as combinacoes possiveis, adiciona todas a lista de fechados e nao vai conseguir adicionar nenhuma a de abertos, ficando a d abertos vazia
					System.out.println("ok");
					} catch (Exception e) {
				System.out.println("Lista abertos vazia");
				System.exit(0);
			}
			actual = abertos.poll();
			if (actual.layout.isGoal(goal)) { //ver se board atual e o goal
				State father = actual.father;
				outsequence.add(actual);
				System.out.println("if (actual.layout.isGoal(goal))");
				while (father != null) {
					outsequence.add(0, father);
					father = father.father;
					System.out.println("while (father != null)");
				}
				end = true;
			} else {//se n for o goal
				sucs = sucessors(actual);//filhos da board atual
				fechados.add(actual);//meter esse no nos fechados
				System.out.println("else");
				for (State state: sucs) {
					if (!fechados.contains(state)) {
						System.out.println("if (!fechados.contains(state))");
						abertos.add(state);//meter sucessores no abertos se nao estiverem nos fechados
					}
				}
			}
		}
		return outsequence.iterator();
	}
}
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
	final private List<State> sucessors(State n) {
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
					throw new Exception();
			} catch (Exception e) {
				System.out.println("Lista abertos vazia");
				System.exit(0);
			}
			actual = abertos.poll();
			if (actual.layout.isGoal(goal)) {
				State father = actual.father;
				outsequence.add(actual);
				while (father != null) {
					outsequence.add(0, father);
					father = father.father;
				}
				end = true;
			} else {
				sucs = sucessors(actual);
				fechados.add(actual);
				for (State state: sucs) {
					if (!fechados.contains(state)) {
						abertos.add(state);
					}
				}
			}
		}
		return outsequence.iterator();
	}
}
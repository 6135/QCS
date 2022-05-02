import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


class IDAstar {
	static class State {
		private Ilayout layout;
		private State father;
		private double g;

		/**
		 * Este construtor cria um estado a partir dos campos l e n
		 * 
		 * @param l representa a que Ilayout este estado se refere
		 * @param n representa a ligacao entre pai e filho fazendo referencia ao estado
		 *          anterior
		 */
		public State(Ilayout l, State n) {
			layout = l;
			father = n;
			if (father != null) {
				g = father.g + l.getG();
			} else
				g = 0.0;
		}

		/**
		 * Permite dar print do Ilayout do estado
		 * 
		 * @return representacao em String do estado a que se refere
		 */
		public String toString() {
			return layout.toString();
		}

		/**
		 * Obtem o valor g do estado que representa o custo do caminho em profundidade
		 * entre o no inicial e o no atual
		 * 
		 * @return double g da iteracao de estados
		 */
		public double getG() {
			return g;
		}

		/**
		 * Funcao Heuristica que calcula o numero de blocos mal posicionados entre o
		 * Ilayout do estado atual e o goal
		 * 
		 * @param goal Ilayout da Board objetivo
		 * @return numero double de blocos mal posicionados entre as duas boards
		 */
		public double getH(Ilayout goal) {
			return this.layout.getH(goal);
		}

		/**
		 * Estimativa de custo mais curto entre o Ilayout do estado presente e do goal
		 * 
		 * @param goal Ilayout objetivo
		 * @return double da soma entre a heuristica e o valor g
		 */
		public double getF(Ilayout goal) { // heuristica em que o menor tende para o melhor caminho
			return getH(goal) + getG();
		}
	}

	protected Queue<State> abertos;

	/**
	 * Sucessores do estado n
	 * 
	 * @param n estado no qual se pretende obter os sucessores
	 * @return lista de estados dos sucessores de n
	 */
	final private List<State> sucessors(State n) {
		List<State> sucs = new ArrayList<>();
		List<Ilayout> children = n.layout.children();
		for (Ilayout e : children) {
			if (n.father == null || !e.equals(n.father.layout)) {
				State nn = new State(e, n);
				sucs.add(nn);
			}
		}
		return sucs;
	}


	State node;
	final public double solve(Ilayout s, Ilayout goal) {
		node = new State(s, null);
		double bound = s.getH(goal);

		while (true) {
			double t = search(0,goal,bound);
			if (t==-1)
				return node.getG();
			bound=t;
		}
	}
	
	private final double search(double g,Ilayout goal, double bound)
    {
        double f = g + node.getH(goal);
        if(f>bound){
            return f;
        }
        if(node.layout.isGoal(goal))
        	return -1;
        double min= Double.MAX_VALUE;
        for(State suc : sucessors(node)) {
            node=suc;
        	double t=search(g+1,goal,bound);  
            if(node.layout.isGoal(goal))
                return -1;
            if(t<min)
            	min= t;
            node=node.father;
            }
        return min;
    }
}
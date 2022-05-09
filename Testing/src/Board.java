import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class Board implements Ilayout, Cloneable {
	
	private int dim = 0;
	List<Stack<Character>> board;
	/**
	 *Goal -> ADBC ,
	 * 
	 *Start-> A DB C
	 * A D B C
	 * AB D C
	 * AC DB
	 * A DBC
	 * DBA C
	 * DB CA
	 */
	/**
	 * Este construtor cria uma Board a partir de uma string str criando 
	 * uma lista de stacks a partir das letras introduzidas
	 * @param str Input do tipo String 
	 */
	public Board(String str){
		board = new ArrayList<>();
		String[] split = str.split(" ");
		for (int i = 0; i < split.length; i++) {
			Stack<Character> s1 = new Stack<Character>();
			char[] ch = split[i].toCharArray();
			for (int j = 0; j < ch.length; j++) {
				s1.push(ch[j]);
				dim++;
			}
			board.add(s1);
		}
		int vazias = dim - board.size();
		while (vazias > 0) {
			Stack<Character> vazio = new Stack<Character>();
			board.add(vazio);
			vazias--;
		}
	}
	
	/**
	 * Construtor de uma Board a partir de s
	 * @param s Lista de stacks de caracteres
	 */
	public Board(List<Stack<Character>> s) {
		board = s;
		dim = board.size();
	}
	
	/**
	 * Construtor de uma Board a partir de uma board
	 * @param b Board
	 */
	public Board(Board b){
		board = b.board;
		dim = board.size();
	}

	
	public Board() {
	}

	@Override
    public int hashCode() {
		int hashCode = 0;
		for(Stack<Character> s : board)
			hashCode +=s.hashCode();
		return hashCode;
	}
	
	/**
	 * Verificacao da igualdade entre a board atual com t
	 * @param t do tipo Object que e feito cast de Board para executar a comparacao
	 * @return Boolean da verificacao entre as boards 
	 */
	//This one
	@Override
	public boolean equals(Object t) {
		List<Stack<Character>> l1 = ((Board) t).board;
		for (int i = 0; i < board.size(); i++) {
			if (!l1.contains(board.get(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Verificacao de se o Ilayout corresponde ao goal(Ilayout l)
	 * @param l Ilayout da boar objetivo
	 * @return Boolean do resultado da funcao equals
	 */
	public boolean isGoal(Ilayout l) {
		return equals(l);
	}
	
	/**
	 * Definicao do custo afim de obter a profundidade a que a 
	 * board se encontra conforme as iteracoes do problema
	 * @return Double 1.0 predefinido para estabelecer um custo por movimento das letras
	 */
	@Override
	public double getG() {
		return 1.0;					
	}


	/**
	 * Gerador de todos os filhos da board atual
	 * @return Lista Ilayout dos sucessores
	 */
	@Override
	public List<Ilayout> children() {
		Map<Ilayout, Integer> list = new HashMap<>();
		Board l1 = (Board) this.clone();
		for (int i = 0; i < dim; i++) {
			char block;
			if (!l1.board.get(i).isEmpty()) {
				for (int j = i + 1; j < dim; j++) {
					block = l1.board.get(i).pop();
					l1.board.get(j).push(block);
					Board b = new Board(l1);
					list.put(b, 0);
					l1 = (Board) this.clone();
				}
				for (int j = 0; j < i; j++) {
					block = l1.board.get(i).pop();
					l1.board.get(j).push(block);
					Board b = new Board(l1);
					list.put(b, 0);
					l1 = (Board) this.clone();
				}
			}
		}
		list.remove(this);
		return new ArrayList<>(list.keySet());
	}
	
	/**
	 * Copia da board atual para efetual operaroes e nao alterar a original
	 * @return Um clone da Board atual
	 */
	@Override
	public Object clone(){
	    try{ 
	        Board b = new Board();
	        b.dim = dim;
	        List<Stack<Character>> cpy = new ArrayList<>();
			
			for (int i = 0; i < board.size(); i++) {
				Stack<Character> stack = new Stack<Character>();
				for (int j = 0; j < board.get(i).size(); j++) {
					stack.add(board.get(i).get(j));
				}
				cpy.add(stack);
			}
	        b.board = cpy;
	        return b;
	    } catch (Exception e){
	        return new Board();
	    }
	    
	}

	/**
	 * toString para as boards
	 * @return Representacao em String de uma Board
	 */
	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < board.size(); i++) {
			if (!board.get(i).isEmpty()) {
				result += "[";
				for (int j = 0; j < board.get(i).size(); j++) {
					result += board.get(i).get(j);
					if (j != board.get(i).size() - 1)
						result += ", ";
				}
				result += "]\n";
			}
		}
		return result;
	}
	//Maybe this one too?
	/**
	 * Funcao que calcula a heuristica da obtencao do numero de letras 
	 * mal posicionadas entre duas boards 
	 * @param Goal Ilayout da Board objetivo
	 * @return double do numero de letras mal posicionadas
	 */
	  @Override
	    public double getH(Ilayout Goal) {
	        List<Stack<Character>> goal = ((Board) Goal).board;
	        int result = dim;
	        for (int i = 0; i < goal.size(); i++) {
	            for (int j = 0; j < board.size(); j++) {
	                for (int k = 0; k < board.get(j).size(); k++) {
	                    if (k < goal.get(i).size()) {
	                        if (goal.get(i).get(k).equals(board.get(j).get(k))) {
	                            result--;
	                        }

	                        else {
	                            break;
	                        }

	                    }

	                }

	            }

	        }

	        return result;
	    }
	
  





}
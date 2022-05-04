import static org.junit.Assert.assertEquals;
import java.util.Iterator;

import org.junit.Test;


public class testequal {
    /*
	Test on equals - complexity 3
	for (index = 0; index < this.board.size; index++) {
		if (!that.contains(this.board.get(index))) {
			return No;
		}
	}
	return Yes;
	*/
	@Test
	public void testnequal() {
		Board b = new Board("");
		Board c = new Board("");
		System.out.println(b.equals(c) ? "Yes" : "No");
	}
	
}

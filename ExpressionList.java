import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

class ExpressionList extends ArrayList<Expression> {
	public void compile(PrintStream out, int indentationLevel) {
		Iterator<Expression> iter = iterator();
		while (iter.hasNext()) {
			Expression expr = iter.next();
			expr.setIndentationLevel(indentationLevel);
			expr.compile(out);
		}
	}
}

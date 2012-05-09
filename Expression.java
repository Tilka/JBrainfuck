
import java.io.PrintStream;

public abstract class Expression {
    private int indentationLevel;

    public int getIndentationLevel() {
	return indentationLevel;
    }

    public abstract void compile(PrintStream out);

    public void setIndentationLevel(int indentationLevel) {
	this.indentationLevel = indentationLevel;
    }

    protected void indent(PrintStream out) {
	int i = indentationLevel;
	while (i-- > 0) {
	    out.print("    ");
	}
    }
}


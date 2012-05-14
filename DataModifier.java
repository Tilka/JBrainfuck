import java.io.PrintStream;

public class DataModifier extends Expression {
    private int value;

    public DataModifier(int value) {
	this.value = value;
    }

    public void compile(PrintStream out) {
	indent(out);
	out.println("add(" + value + ");");
    }
}

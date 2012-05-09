import java.io.PrintStream;

public class PtrModifier extends Expression {
    public int value;

    public void compile(PrintStream out) {
	indent(out);
	out.println("ptr += " + value + ";");
    }
}


import java.io.PrintStream;

public class PtrModifier extends Expression {
    private int value;

    public PtrModifier(int value) {
	this.value = value;
    }

    public void compile(PrintStream out) {
	indent(out);
	out.println("ptr.add("+ value +");");
    }
}


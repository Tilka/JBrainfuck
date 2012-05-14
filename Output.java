import java.io.PrintStream;

public class Output extends Expression {
    public int value;

    public void compile(PrintStream out) {
	indent(out);
	out.println("output();");
    }
}


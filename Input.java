import java.io.PrintStream;

public class Input extends Expression {
    public int value;

    public void compile(PrintStream out) {
	indent(out);
	out.println("data[ptr] = (byte) System.in.read();");
    }
}


import java.io.PrintStream;

public class Input extends Expression {
    public int value;

    public void compile(PrintStream out) {
	indent(out);
	out.println("data[ptr.get()].set( System.in.read() );");
    }
}


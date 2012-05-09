import java.io.PrintStream;

public class DataModifier extends Expression {
    public int value;

    public void compile(PrintStream out) {
	indent(out);
	out.println("data[ptr] = (short)( (data[ptr] + " + value + ") % 256 ); if(data[ptr] < 0) data[ptr]+=256;");
    }
}

import java.io.PrintStream;

public class PtrModifier extends Expression {
    private int value;

    public PtrModifier(int value) {
	this.value = value;
    }

    public void compile(PrintStream out) {
	indent(out);
	out.println("ptr = (short)( (ptr + " + value + ") % 256 ); if(ptr < 0) ptr+=256;");
    }
}


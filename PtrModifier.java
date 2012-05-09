
public class PtrModifier extends Expression
{

    public int value;

    public boolean compile(PrintStream out) {
	out.println("ptr += "+value);
    }

}


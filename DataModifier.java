
public class DataModifier extends Expression
{

    public int value;

    public boolean compile(PrintStream out) {
	out.println("data[ptr] += "+value);
    }

}


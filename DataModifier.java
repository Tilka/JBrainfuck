
import java.io.PrintStream;

public class DataModifier extends Expression
{

    public int value;

    public void compile(PrintStream out) {
	out.println("data[ptr] += "+value);
    }

}


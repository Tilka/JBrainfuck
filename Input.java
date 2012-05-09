
import java.io.PrintStream;

public class Input extends Expression
{

    public int value;

    public void compile(PrintStream out) {
	out.println("data[ptr] = (char) System.in.read();");
    }

}



import java.io.PrintStream;

public class Output extends Expression
{

    public int value;

    public void compile(PrintStream out) {
	out.println("System.out.print( (char)data[ptr] );");
    }

}


import org.antlr.runtime.*;

public class ParseBrainfuck
{
	public static void main(String[] args) throws Exception 
	{
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		BrainfuckLexer lexer = new BrainfuckLexer(input);
		CommonTokenStream ts = new CommonTokenStream(lexer);
		BrainfuckParser parser = new BrainfuckParser(ts);
		parser.start();
	}
}


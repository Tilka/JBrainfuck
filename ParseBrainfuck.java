import org.antlr.runtime.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class ParseBrainfuck {
	private static String getRawFileName(String inputFileName) {
		int fileNameEnd = inputFileName.lastIndexOf('.');
		return fileNameEnd == -1 ? inputFileName : inputFileName.substring(0, fileNameEnd);
	}

	private static String fileToString(String fileName) throws IOException {
		FileInputStream fis = new FileInputStream(fileName);
		try {
			FileChannel fc = fis.getChannel();
			MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
			return Charset.defaultCharset().decode(bb).toString();
		} finally {
			fis.close();
		}
	}

	private static void compile(InputStream in, PrintStream out) throws Exception {
		ANTLRInputStream input = new ANTLRInputStream(in);
		BrainfuckLexer lexer = new BrainfuckLexer(input);
		CommonTokenStream ts = new CommonTokenStream(lexer);
		BrainfuckParser parser = new BrainfuckParser(ts);
		ExpressionList exprList = parser.start();
		exprList.compile(out, 2);
	}

	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			System.err.println("Usage: ParseBrainfuck <inputfile>");
			return;
		}

		String inFileName = args[0];
		String rawFileName = getRawFileName(inFileName);
		String outFileName = rawFileName + ".java";
		PrintStream out = new PrintStream(outFileName);
		try {
			String header = fileToString("BrainfuckHeader.java");
			out.print(String.format(header, rawFileName));
			InputStream in = new FileInputStream(inFileName);
			compile(in, out);
			out.print(fileToString("BrainfuckFooter.java"));
		} finally {
			out.close();
		}
	}
}


import java.io.PrintStream;

class Loop extends Expression {
	private ExpressionList innerCode;

	public Loop(ExpressionList innerCode) {
		this.innerCode = innerCode;
	}

	public void compile(PrintStream out) {
		indent(out);
		out.println("while (data[ptr] != 0) {");
		innerCode.compile(out, getIndentationLevel() + 1);
		indent(out);
		out.println("}");
	}
}

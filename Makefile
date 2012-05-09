SYNTAX=Brainfuck

all:
	antlr3 $(SYNTAX).g
	javac -cp /usr/share/java/antlr3-runtime.jar:. Parse$(SYNTAX).java
run:
	java -cp /usr/share/java/antlr3-runtime.jar:. Parse$(SYNTAX)

clean:
	rm -f *.class
	rm -f *Lexer.java
	rm -f *Parser.java
	rm -f *.tokens

grammar Brainfuck;

start returns [ExpressionList result]:
	expression { $result = $expression.result; }
	EOF;

expression returns [ExpressionList result]:
	{ $result = new ExpressionList(); }
	(
	  (
	    r=modify_pointer
	    |
	    r=modify_data
	    |
	    r=io
	    |
	    r=loop
	  ) { $result.add($r.result); }
	)*;

modify_pointer returns [Expression result]:
	{ int value = 0; }
	(
	  '>' { value += 1; }
	  |
	  '<' { value -= 1; }
	)
	{ $result = new PtrModifier(value); };

modify_data returns [Expression result]:
	{ int value = 0; }
	(
	  '+' { value += 1; }
	  |
	  '-' { value -= 1; }
	)
	{ $result = new DataModifier(value); };

io returns [Expression result]:
	'.' { $result = new Output(); }
	|
	',' { $result = new Input(); };

loop returns [Expression result]:
	'[' expression ']' { $result = new Loop($expression.result); };

WS:
	(~('<' | '>' | '+' | '-' | '.' | ',' | '[' | ']'))+ { skip(); };

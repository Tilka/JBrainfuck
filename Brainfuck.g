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
	{ PtrModifier temp = new PtrModifier(); }
	(
	  '>' { temp.value = +1; }
	  |
	  '<' { temp.value = -1; }
	)
	{ $result = temp; };

modify_data returns [Expression result]:
	{ DataModifier temp = new DataModifier(); }
	(
	  '+' { temp.value = +1; }
	  |
	  '-' { temp.value = -1; }
	)
	{ $result = temp; };

io returns [Expression result]:
	'.' { $result = new Output(); }
	|
	',' { $result = new Input(); };

loop returns [Expression result]:
	'[' expression ']' { $result = new Loop($expression.result); };

WS:
	(~('<' | '>' | '+' | '-' | '.' | ',' | '[' | ']'))+ { skip(); };

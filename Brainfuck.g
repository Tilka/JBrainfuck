grammar Brainfuck;

start: expression;

expression returns [Expression result]:
	modify_pointer
	|
	modify_data
	|
	io
	|
	loop
	;

modify_pointer returns [Expression result]:
	{ PtrModifier temp = new PtrModifier(); }
	(
	  '>' { temp.value = +1; }
	  |
	  '<' { temp.value = -1; }
	)
	{ $result = temp; }
	;

modify_data returns [Expression result]:
	{ DataModifier temp = new DataModifier(); }
	(
	  '+' { temp.value = +1; }
	  |
	  '-' { temp.value = -1; }
	)
	{ $result = temp; }
	;

io returns [Expression result]:
	'.' { $result = new Output(); }
	|
	',' { $result = new Input(); }
	;

loop returns [Expression result]:
	'[' expression ']' { $result = new Loop($expression.result); }
	;

WS:
	(~('<' | '>' | '+' | '-' | '.' | ',' | '[' | ']'))+ { skip(); };

grammar Brainfuck;

@header
{
	import java.util.Map;
	import java.util.TreeMap;
}

@members
{
	Map<String,Integer> identifiers = new TreeMap<String,Integer>();
}

start:
	(expression NEWLINE { System.out.println($expression.result); }
	| NEWLINE
	)*
	EOF;

expression returns [int result]:
	(r=assignment | r=ternaryExpr)  { $result = $r.result; };

assignment returns [int result]:
	identifier '=' expression { $result = $expression.result; identifiers.put($identifier.text, $result); };

ternaryExpr returns [int result]:
	e=boolExpr			    { $result = $e.result; }
	('?' t=expression ':' f=expression  { $result = $result != 0 ? $t.result : $f.result; }
	)?;

boolExpr returns [int result]:
	s=sum		{ $result = $s.result; }
	( '<'  s=sum	{ $result = $result <  $s.result ? 1 : 0; }
	| '>'  s=sum	{ $result = $result >  $s.result ? 1 : 0; }
	| '<=' s=sum	{ $result = $result <= $s.result ? 1 : 0; }
	| '>=' s=sum	{ $result = $result >= $s.result ? 1 : 0; }
	| '==' s=sum	{ $result = $result == $s.result ? 1 : 0; }
	| '!=' s=sum	{ $result = $result != $s.result ? 1 : 0; }
	)*;

sum returns [int result]:
	p=product	{ $result = $p.result; }
	( '+' p=product	{ $result += $p.result; }
	| '-' p=product	{ $result -= $p.result; }
	)*;

product returns [int result]:
	f=factor	{ $result = $f.result; }
	( '*' f=factor	{ $result *= $f.result; }
	| '/' f=factor	{ $result /= $f.result; }
	)*;

factor returns [int result]:
	'(' expression ')'  { $result = $expression.result; }
	| number	    { $result = Integer.parseInt($number.text); }
	| identifier	    { $result = identifiers.get($identifier.text); };

identifier:
	LETTER_ (LETTER_ | DIGIT)*;

number:
	DIGIT+;

DIGIT:
	'0'..'9';

LETTER_:
	'a'..'z'|'A'..'Z'|'_';

NEWLINE:
	'\r'? '\n';

WS:
	(' ' | '\t')+ { skip(); };

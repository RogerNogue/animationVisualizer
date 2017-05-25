/**
 * Copyright (c) 2011, Jordi Cortadella
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *    * Redistributions of source code must retain the above copyright
 *      notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above copyright
 *      notice, this list of conditions and the following disclaimer in the
 *      documentation and/or other materials provided with the distribution.
 *    * Neither the name of the <organization> nor the
 *      names of its contributors may be used to endorse or promote products
 *      derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

grammar Asl;

options {
    output = AST;
    ASTLabelType = AslTree;
}

// Imaginary tokens to create some AST nodes

tokens {
    LIST_FUNCTIONS; // List of functions (the root of the tree)
    ASSIGN;     // Assignment instruction
    PARAMS;     // List of parameters in the declaration of a function
    FUNCALL;    // Function call
    ARGLIST;    // List of arguments passed in a function call
    LIST_INSTR; // Block of instructions
    BOOLEAN;    // Boolean atom (for Boolean constants "true" or "false")
    PVALUE;     // Parameter by value in the list of parameters
    PREF;       // Parameter by reference in the list of parameters
}

@header {
package parser;
import interp.AslTree;
}

@lexer::header {
package parser;
}


// A program is a list of functions
prog	: func+ EOF -> ^(LIST_FUNCTIONS func+)
        ;
            
// A function has a name, a list of parameters and a block of instructions	
func	: FUNC^ ID params block_instructions ENDFUNC!
        ;

// The list of parameters grouped in a subtree (it can be empty)
params	: '(' paramlist? ')' -> ^(PARAMS paramlist?)
        ;

// Parameters are separated by commas
paramlist: param (','! param)*
        ;

// Parameters with & as prefix are passed by reference
// Only one node with the name of the parameter is created
param   :   '&' id=ID -> ^(PREF[$id,$id.text])
        |   id=ID -> ^(PVALUE[$id,$id.text])
        ;

// A list of instructions, all of them gouped in a subtree
block_instructions
        :	 instruction (';' instruction)*
            -> ^(LIST_INSTR instruction+)
        ;

// The different types of instructions
instruction
        :	assign          // Assignment
        |	ite_stmt        // if-then-else
        |	while_stmt      // while statement
        |   funcall         // Call to a procedure (no result produced)
        |	return_stmt     // Return statement
        |	read            // Read a variable
        | 	write           // Write a string or an expression
        //graphics instruction
        |   creation
        |   destruction
        |   movement
        |   modify
        /*
        |   modifycolor
        |   modifystroke
        |   modifysize         //for quads and elypses
        |   modifyradious
        |   modifyVisibility
        */
        |   source
        |                   // Nothing
        ;

// Assignment
assign	:	ID eq=EQUAL expr -> ^(ASSIGN[$eq,":="] ID expr)
        ;

// if-then-else (else is optional)
ite_stmt	:	IF^ expr THEN! block_instructions (ELSE! block_instructions)? ENDIF!
            ;

// while statement
while_stmt	:	WHILE^ expr DO! block_instructions ENDWHILE!
            ;

// Return statement with an expression
return_stmt	:	RETURN^ expr?
        ;

// Read a variable
read	:	READ^ ID
        ;

// Write an expression or a string
write	:   WRITE^ (expr | STRING )
        ;

// Grammar for expressions with boolean, relational and aritmetic operators
expr    :   boolterm (OR^ boolterm)*
        ;


creation        :   CREATE^ ID ( quadrat | circle | elypse | line | polygon |text)
            ;

quadrat         : QUAD^ '('! atom ','! atom ','! atom ','! atom')'!
            ;

circle          : CIRCLE^ '('! atom ','! atom ','! atom ')'!
            ;

elypse          : ELYPSE^ '('! atom ','! atom ','! atom ','! atom')'!
            ;

line            : LINE^  '('! atom (','! atom)* ')'!
            ;

polygon         : POLYGON^ '('! atom (','! atom)* ')'!
            ;

text            : TEXT^ '('! atom ','! atom ','! STRING ')'!
            ;

destruction     : DESTRUCTION^ '('! ID')'! 
        ;

movement        :   (MOVE '(' ID ',' A1=atom ',' A2=atom')') -> ^(MOVE ID ^(PARAMS $A1 $A2))
        ;

modify          :   MODIFY^ ID (color | stroke | size | visibility)
        ;
        
//Color (red, green, blue)        
color           : COLOR^  '('!  A1=atom ','! A2=atom ','! A3=atom ')'!
    ;

//Stroke (width, red, green, blue, alpha?)
stroke          : STROKE^ '('!  A1=atom ','! A2=atom ','! A3=atom ','! A4=atom ( ','! A5=atom )? ')'!
    ;
    
//modificacions de mida:
size            : SIZE^ (vertex | radius | tworadius | width | height)       
        ;

//Radius (R) //es defineix el nou radi
radius         :   RADIUS^ '('! A1=atom')'!
        ;
        
//TwoRadius ( R1, R2) //es defineixen els 2 nous radis
tworadius      :   TWORADIUS^ '('! A1=atom ','! A2=atom ')'!
        ;
        
//VertexPosition (n(numero del vertex), x, y)
vertex          :   VERTEXPOSITION^ '('! A1=atom ','! A2=atom ','! A3=atom ')'!
        ;
        
//Width (n(nova mida amplada))
width           :   WIDTH^ '('! A1=atom ')'!
        ;

//height (n(nova mida alcada))
height          :   HEIGHT^ '('! A1=atom ')'!
        ;
        
        /*
modify          :   MODIFY^ (color | stroke | size | visibility)
        ;
        
//Color (ID, red, green, blue)        
color           : COLOR^  '('! ID ','! A1=atom ','! A2=atom ','! A3=atom ')'!
    ;

//Stroke (ID, width, red, green, blue, alpha?)
stroke          : STROKE^ '('! ID ','! A1=atom ','! A2=atom ','! A3=atom ','! A4=atom ( ','! A5=atom )? ')'!
    ;
    
//modificacions de mida:
size            : SIZE^ (vertex | radius | tworadius | width | height)       
        ;

//Radius (ID, R) //es defineix el nou radi
radius         :   RADIUS^ '('! ID ','! A1=atom')'!
        ;
        
//TwoRadius (ID, R1, R2) //es defineixen els 2 nous radis
tworadius      :   TWORADIUS^ '('! ID ','! A1=atom ','! A2=atom ')'!
        ;
        
//VertexPosition (ID, n(numero del vertex), x, y)
vertex          :   VERTEXPOSITION^ '('! ID ','! A1=atom ','! A2=atom ','! A3=atom ')'!
        ;
        
//Width (ID, n(nova mida amplada))
width           :   WIDTH^ '('! ID ','! A1=atom ')'!
        ;

//height (ID, n(nova mida alcada))
height          :   HEIGHT^ '('! ID ','! A1=atom ')'!
        ;
*/

//Visibility (ID, opacity)) //0<= opacity <= 1
visibility      : VISIBILITY^ '('! ID ','! A1=atom ')'!
        ;

        
/*codi old
modifycolor     :   (MODIFYCOLOR '('  ID ','  A1=atom ','  A2=atom ','  A3=atom')') -> ^(MODIFYCOLOR ID ^(PARAMS $A1 $A2 $A3))
        ;

// width i RGB
modifystroke    :   (MODIFYSTROKE '(' ID ','  A1=atom ','  A2=atom ','  A3=atom ','  A4=atom')') -> ^(MODIFYSTROKE ID ^(PARAMS $A1 $A2 $A3 $A4))
        ;
//mida per al quadrat i elipsis
modifysize      :   (MODIFYSIZE '(' ID ','  A1=atom ','  A2=atom')') -> ^(MODIFYSIZE ID ^(PARAMS $A1 $A2))
        ;
//mida cercle
modifyradious   :   MODIFYRADIOUS '(' ID ','  A1=atom')' -> ^(MODIFYRADIOUS ID ^(PARAMS $A1))
        ;

modifyVisibility    :   MODIFYVISIBILITY '(' ID ','  A1=atom')' -> ^(MODIFYVISIBILITY ID ^(PARAMS $A1))
        ;
        
*/        

source          :  SOURCE^ STRING  '('!  atom (','! atom )* ')'! 
        ;



boolterm:   boolfact (AND^ boolfact)*
        ;

boolfact:   num_expr ((EQUAL^ | NOT_EQUAL^ | LT^ | LE^ | GT^ | GE^) num_expr)?
        ;

num_expr:   term ( (PLUS^ | MINUS^) term)*
        ;

term    :   factor ( (MUL^ | DIV^ | MOD^) factor)*
        ;

factor  :   (NOT^ | PLUS^ | MINUS^)? atom
        ;

// Atom of the expressions (variables, integer and boolean literals).
// An atom can also be a function call or another expression
// in parenthesis
atom    :   ID 
        |   INT
        |   DOUBLE
        |   (b=TRUE | b=FALSE)  -> ^(BOOLEAN[$b,$b.text])
        |   funcall
        |   '('! expr ')'!
        ;

// A function call has a lits of arguments in parenthesis (possibly empty)
funcall :   ID '(' expr_list? ')' -> ^(FUNCALL ID ^(ARGLIST expr_list?))
        ;

// A list of expressions separated by commas
expr_list:  expr (','! expr)*
        ;

// Basic tokens
EQUAL	: '=' ;
NOT_EQUAL: '!=' ;
LT	    : '<' ;
LE	    : '<=';
GT	    : '>';
GE	    : '>=';
PLUS	: '+' ;
MINUS	: '-' ;
MUL	    : '*';
DIV	    : '/';
MOD	    : '%' ;
NOT	    : 'not';
AND	    : 'and' ;
OR	    : 'or' ;	
IF  	: 'if' ;
THEN	: 'then' ;
ELSE	: 'else' ;
ENDIF	: 'endif' ;
WHILE	: 'while' ;
DO	    : 'do' ;
ENDWHILE: 'endwhile' ;
FUNC	: 'func' ;
ENDFUNC	: 'endfunc' ;
RETURN	: 'return' ;
READ	: 'read' ;
WRITE	: 'write' ;


CREATE	            : 'Create' ;
DESTRUCTION         : 'Destruction';
MOVE                : 'Move';
MODIFY              : 'Modify';
RADIOUS             : 'Radious';
COLOR               : 'Color';
STROKECOLOR         : 'StrokeColor';
SIZE                : 'Size';
VISIBILITY          : 'Visibility';
VERTEXPOSITION      : 'VertexPosition';
RADIUS              : 'Radius';
TWORADIUS           : 'TwoRadius';
HEIGHT              : 'Height';
WIDTH               : 'Width';
STROKE              : 'Stroke';
/*
MODIFYCOLOR         : 'ModifyColor';
MODIFYSTROKE        : 'ModifyStroke';
MODIFYSIZE          : 'ModifySize';
MODIFYRADIOUS       : 'ModifyRadious';
MODIFYVISIBILITY    : 'ModifyVisibility';
*/
SOURCE              : 'Source';


QUAD    : 'Quad' ;
CIRCLE  : 'Circle' ;
ELYPSE  : 'Elypse';
LINE    : 'Line';
POLYGON : 'Polygon';
TEXT    : 'Text';
TRUE    : 'true' ;
FALSE   : 'false';
ID  	:	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;
INT 	:	'0'..'9'+ ;
DOUBLE  :   ('0'..'9'+ '.' '0'..'9'*) | ('0'..'9'* '.' '0'..'9'+);

// C-style comments
COMMENT	: '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    	| '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    	;

// Strings (in quotes) with escape sequences        
STRING  :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
        ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    ;

// White spaces
WS  	: ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    	;



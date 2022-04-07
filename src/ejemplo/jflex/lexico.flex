/* JFlex example: partial Java language lexer specification */
package ejemplo.jflex;

/**
 * This class is a simple example lexer.
 */
%%

%public
%class MiLexico
%unicode
%type MiToken
%line
%column

%{
    /*************************************************************************
    * En esta sección se puede incluir código que se copiará textualmente
    * como parte de la definición de la clase del analizador léxico.
    * Típicamente serán variables de instancia o nuevos métodos de la clase.
    *************************************************************************/

    int string_yyline = 0;
    int string_yycolumn = 0;
    int comentario_multilinea = 0;

    StringBuffer string = new StringBuffer();

    private MiToken token(String nombre) {
        return new MiToken(nombre, this.yyline, this.yycolumn);
    }

    private MiToken token(String nombre, Object valor) {
        return new MiToken(nombre, this.yyline, this.yycolumn, valor);
    }

    private MiToken token(String nombre, int line, int column, Object valor) {
        return new MiToken(nombre, line, column, valor);
    }
%}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
    
while   = WHILE|while
integer = INTEGER|Integer|integer
float   = FLOAT|Float|float
boolean = BOOLEAN | Boolean | boolean
write   = WRITE|write
else    = ELSE|else
if  = IF|if
then = THEN | then
do = DO | do
end = END | End

display = DISPLAY | display
declareSection = DECLARE\.SECTION | declare\.section
enddeclareSection = ENDDECLARE\.SECTION | enddeclare\.section
programSection = PROGRAM\.SECTION | program\.section
endprogramSection = ENDPROGRAM\.SECTION | endprogram\.section 
sumaimpar = SUMAIMPAR | sumaimpar

Identifier = [^\W\d\.\_][^\W\.]*{1,20}

intLiteral = \d+ {1,50}
floatLiteral = \d+\.\d* | \.\d+ {1,50}
booleanLiteral = true | false

%state STRING
%state COMENTARIO

%%

<YYINITIAL> {

  /* keywords */

  {integer}            { return token("INTEGER",yytext());} 
  {float}              { return token("FLOAT", yytext());}
  {boolean}            { return token("BOOLEAN", yytext()); }

  "and"                { return token("AND", yytext());}
  "or"                 { return token("OR", yytext());}
  "not"                { return token("NOT", yytext());}

  {while}              { return token("WHILE", yytext());}
  {do}                 { return token("DO", yytext());}
  {end}                { return token("END", yytext());}

  {if}                 { return token("IF", yytext());}
  {then}               { return token("THEN", yytext());}

  {display}             { return token("DISPLAY", yytext());}
  {declareSection}    { return token("DECLARE.SECTION", yytext());}
  {enddeclareSection} { return token("ENDDECLARE.SECTION", yytext());}
  {programSection}    { return token("PROGRAM.SECTION", yytext());}
  {endprogramSection} { return token("ENDPROGRAM.SECTION", yytext());}

  {sumaimpar}           { return token("SUMAIMPAR", yytext());}

  /* operators */

  "\+"                           { return token("SUMA", yytext()); }
  "-"                            { return token("RESTA", yytext()); }
  "\*"                           { return token("MULTIPLICACION", yytext()); }
  "/"                            { return token("DIVISION", yytext()); }
  "="                            { return token("IGUAL", yytext()); }
  "=="                           { return token("IGUAL_IGUAL", yytext()); }
  "!="                           { return token("DESIGUAL", yytext()); }
  ">"                            { return token("MAYOR", yytext()); }
  ">="                           { return token("MAYOR_IGUAL", yytext()); }
  "<"                            { return token("MENOR", yytext()); }
  "<="                           { return token("MENOR_IGUAL", yytext()); }

  "\("                           { return token("PARENTESISA", yytext()); }
  "\)"                           { return token("PARENTESISC", yytext()); }
  "\{"                           { return token("LLAVESA", yytext()); }
  "\}"                           { return token("LLAVESC", yytext()); }
  "\["                           { return token("CORCHETESA", yytext()); }
  "\]"                           { return token("CORCHETESC", yytext()); }
  "\."                           { return token("PUNTO", yytext()); }
  "\,"                           { return token("COMA", yytext()); }
  "\;"                           { return token("EOL", yytext()); }
  ":"                            { return token("DOS_PUNTOS", yytext()); }

  /* literals */
  {booleanLiteral}               { return token("BOOLEAN_LITERAL", yytext()); } 
  {intLiteral}                   { return token("INTEGER_LITERAL", yytext()); }
  {floatLiteral}                 { return token("FLOAT_LITERAL", yytext());}
  
  \"                             {  string.setLength(0); 
                                    yybegin(STRING); 
                                    string_yyline = this.yyline;
                                    string_yycolumn = this.yycolumn; }

  "\(\*"                         { yybegin(COMENTARIO);
                                   comentario_multilinea += 1; }
                                   
  "\*\)"                         { throw new Error("Comentario no balanceado");}

  /* whitespace */
  {WhiteSpace}                   { /* ignore */ }

  /* identifiers */
  {Identifier}                   { return token("IDENTIFIER", yytext()); }
}


<STRING> {
  \"                             { yybegin(YYINITIAL);
                                   return token("STRING_LITERAL", string_yyline, string_yycolumn, string.toString()); }
  \\\"                           { string.append('\"'); }
  \\n                            { string.append('\n'); }
  \\t                            { string.append('\t'); }
  \\                             { string.append('\\'); }
  [^]                            { string.append( yytext() ); }
}

<COMENTARIO> {
  \(\*                           { comentario_multilinea ++;}
  \*\)                           { comentario_multilinea --;
                                   if(comentario_multilinea == 0){
                                      yybegin(YYINITIAL);}}
  #                              { string.append('#'); }
  <<EOF>>                        { throw new Error("Comentario no balanceado"); }
  [^]                            { string.append( yytext() ); }
}

/* error fallback */
/*[^]                              { throw new Error("Illegal character <"+yytext()+">"); }*/

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

Identifier = ^[^\W\d\.\_][^\W\.]*

DecIntegerLiteral = \d+


%state STRING
%state COMENTARIO

%%

<YYINITIAL> {

  /* keywords */
  "and"                { return token("AND", yytext());}
  "or"                 { return token("OR", yytext());}
  "not"                { return token("NOT", yytext());}

  "while"              { return token("WHILE", yytext());}
  "do"                 { return token("DO", yytext());}
  "end"                { return token("END", yytext());}

  "if"                 { return token("IF", yytext());}
  "then"               { return token("THEN", yytext());}
  
  "boolean"            { return token("BOOLEAN", yytext()); }
  "int"                { return token("INT", yytext()); }
  "float"              { return token("FLOAT", yytext());}

  "display"            { return token("DISPLAY", yytext());}
  "declare\.section"   { return token("DECLARE.SECTION", yytext());}
  "enddeclare\.section"{ return token("ENDDECLARE.SECTION", yytext());}
  "program\.section"   { return token("PROGRAM.SECTION", yytext());}
  "endprogram\.section"{ return token("ENDPROGRAM.SECTION", yytext());}

  "sumaimpar"          { return token("SUMAIMPAR", yytext());}

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
  "\("                           { return token("PARENTESISC", yytext()); }
  "\{"                           { return token("LLAVESA", yytext()); }
  "\}"                           { return token("LLAVESC", yytext()); }
  "\["                           { return token("CORCHETESA", yytext()); }
  "\]"                           { return token("CORCHETESC", yytext()); }
  "\."                           { return token("PUNTO", yytext()); }
  "\,"                           { return token("COMA", yytext()); }
  "\;"                           { return token("EOL", yytext()); }

  /* identifiers */
  {Identifier}                   { return token("IDENTIFIER", yytext()); }

  /* literals */
  {DecIntegerLiteral}            { return token("INTEGER_LITERAL", yytext()); }
  \"                             {  string.setLength(0); 
                                    yybegin(STRING); 
                                    string_yyline = this.yyline;
                                    string_yycolumn = this.yycolumn; }

  "\(\*"                         { yybegin(COMENTARIO);
                                   comentario_multilinea += 1; }
                                   
  "\*\)"                         { throw new Error("Comentario no balanceado");}

  /* whitespace */
  {WhiteSpace}                   { /* ignore */ }
}


<STRING> {
  \"                             { yybegin(YYINITIAL);
                                   return token("STRING_LITERAL", string_yyline, string_yycolumn, string.toString()); }
  \\\"                           { string.append('\"'); }
  \\n                            { string.append('\n'); }
  \\t                            { string.append('\t'); }
  \\                             { string.append('\'); }
  \\\\                           { string.append('\\'); }
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

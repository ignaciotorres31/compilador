package compilador.ast.sentencias;

import compilador.ast.expresiones.Expresion;
import compilador.ast.expresiones.Identificador;



public class Asignacion extends Sentencia {
    
    private Identificador ident;
    private Expresion expresion;

    public Asignacion(Identificador ident, Expresion e) {
        super("=");
        this.ident = ident;
        this.expresion = e;
    }

    public Identificador getIdent() {
        return ident;
    }

    public void setIdent(Identificador ident) {
        this.ident = ident;
    }

    public void setExpresion(Expresion expresion) {
        this.expresion = expresion;
    }

    public Expresion getExpresion() {
        return expresion;
    }

}

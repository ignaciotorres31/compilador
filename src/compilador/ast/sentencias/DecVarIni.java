package compilador.ast.sentencias;
        
import compilador.ast.expresiones.Expresion;
import compilador.ast.expresiones.Identificador;


/** Variable inicializada al momento de crearse. */
public class DecVarIni extends DecVar {
    private Expresion expresion;

    public DecVarIni(Identificador ident, Expresion expr) {
        super(ident);
        this.expresion = expr;
    }

    public Expresion getExpresion() {
        return expresion;
    }

    public void setExpresion(Expresion expresion) {
        this.expresion = expresion;
    }
}

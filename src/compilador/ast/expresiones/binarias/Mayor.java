package compilador.ast.expresiones.binarias;

import compilador.ast.base.Tipo;
import compilador.ast.expresiones.Expresion;


public class Mayor extends OperacionBinaria {
    public Mayor(Expresion izquierda, Expresion derecha) {
        super(izquierda, derecha, ">");
        super.setTipo(Tipo.BOOLEAN);
    }

    @Override
    protected String getNombreOperacion() {
        return "Mayor";
    }
    
    public Mayor clonar(){
        return new Mayor(getIzquierda().clonar(), getDerecha().clonar());
    }

    @Override
    public String get_llvm_op_code() {
        return getIzquierda().getTipo().equals(Tipo.FLOAT) ? "ogt" : "sgt";
    }
}

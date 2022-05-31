package compilador.ast.expresiones.binarias;

import compilador.ast.base.Tipo;
import compilador.ast.expresiones.Expresion;

public class MenorIgual extends OperacionBinaria {
    public MenorIgual(Expresion izquierda, Expresion derecha) {
        super(izquierda, derecha, "<=");
        super.setTipo(Tipo.BOOLEAN);
    }
    
    @Override
    protected String getNombreOperacion() {
        return "MenorIgual";
    }
    
    public MenorIgual clonar(){
        return new MenorIgual(getIzquierda().clonar(), getDerecha().clonar());
    }
    

    @Override
    public String get_llvm_op_code() {
        return getIzquierda().getTipo().equals(Tipo.FLOAT) ? "ole" : "sle";
    }
}

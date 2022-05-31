package compilador.ast.expresiones.binarias;

import compilador.ast.base.Tipo;
import compilador.ast.expresiones.Expresion;



public class MayorIgual extends OperacionBinaria {
    
     public MayorIgual(Expresion izquierda, Expresion derecha) {
        super(izquierda, derecha, ">=");
        super.setTipo(Tipo.BOOLEAN);
    }

    @Override
    protected String getNombreOperacion() {
        return "MayorIgual"; 
    }
    
    public MayorIgual clonar(){
        return new MayorIgual(getIzquierda().clonar(), getDerecha().clonar());
    }

    @Override
    public String get_llvm_op_code() {
        return getIzquierda().getTipo().equals(Tipo.FLOAT) ? "oge" : "sge";
    }
}

package compilador.ast.expresiones.binarias;

import compilador.ast.base.Tipo;
import compilador.ast.expresiones.Expresion;

public class Menor extends OperacionBinaria {
    public Menor(Expresion izquierda, Expresion derecha) {
        super(izquierda, derecha, "<");
        super.setTipo(Tipo.BOOLEAN);
    }

    @Override
    protected String getNombreOperacion() {
       return "Menor";
    }
    
    public Menor clonar(){
        return new Menor(getIzquierda().clonar(), getDerecha().clonar());
    }

    @Override
    public String get_llvm_op_code() {
        return getIzquierda().getTipo().equals(Tipo.FLOAT) ? "olt" : "slt";
    }
}

package compilador.ast.expresiones.binarias;

import compilador.ast.expresiones.Expresion;
import compilador.ast.base.Tipo;


public class Igualdad extends OperacionBinaria {
    public Igualdad(Expresion izquierda, Expresion derecha) {
        super(izquierda, derecha, "==");
        super.setTipo(Tipo.BOOLEAN);
    }

    @Override
    protected String getNombreOperacion() {
        return "Igualdad";
    }
    
    public Igualdad clonar(){
        return new Igualdad(getIzquierda().clonar(), getDerecha().clonar());
    }

    @Override
    public String get_llvm_op_code() {
        return getIzquierda().getTipo().equals(Tipo.FLOAT) ? "oeq" : "eq";
    }
}

package compilador.ast.expresiones.binarias;

import compilador.ast.base.Tipo;
import compilador.ast.expresiones.Expresion;

public class Desigualdad extends OperacionBinaria {
    
    public Desigualdad(Expresion izquierda, Expresion derecha) {
        super(izquierda, derecha, "!=");
        super.setTipo(Tipo.BOOLEAN);
    }

    @Override
    protected String getNombreOperacion() {
        return "Desigualdad"; 
    }
    
    public Desigualdad clonar(){
        return new Desigualdad(getIzquierda().clonar(), getDerecha().clonar());
    }

    @Override
    public String get_llvm_op_code() {
        return getIzquierda().getTipo().equals(Tipo.FLOAT) ? "one" : "ne";
    }
}

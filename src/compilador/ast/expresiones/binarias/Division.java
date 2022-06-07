package compilador.ast.expresiones.binarias;

import compilador.ast.base.Tipo;
import compilador.ast.expresiones.Expresion;

/**
 *
 * @author facundo
 */
public class Division extends OperacionBinaria {

    public Division(Expresion izquierda, Expresion derecha, Tipo tipo) {
        super(izquierda, derecha, tipo);
    }

    @Override
    protected String getNombreOperacion() {
        return "/";
    }
    
    public Division clonar(){
        return new Division(getIzquierda().clonar(), getDerecha().clonar(), getTipo());
    }
    
    @Override
    public String get_llvm_op_code() {
        return this.getTipo().equals(Tipo.FLOAT) ? "fdiv" : "sdiv"; 
    }

}

package compilador.ast.expresiones.binarias;

import compilador.ast.base.Tipo;
import compilador.ast.expresiones.Expresion;

/**
 *
 * @author facundo
 */
public class Resta extends OperacionBinaria {

    public Resta(Expresion izquierda, Expresion derecha, Tipo tipo) {
        super(izquierda, derecha, tipo);
    }

    @Override
    protected String getNombreOperacion() {
        return "-";
    }
    
    public Resta clonar(){
        return new Resta(getIzquierda().clonar(), getDerecha().clonar(), getTipo());
    }
    @Override
    public String get_llvm_op_code() {
        return getTipo().equals(Tipo.FLOAT) ? "fsub" : "sub";
    }
}

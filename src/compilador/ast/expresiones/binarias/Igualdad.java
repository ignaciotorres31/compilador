package compilador.ast.expresiones.binarias;

import compilador.ast.expresiones.Expresion;
import compilador.ast.base.Tipo;


public class Igualdad extends OperacionBinaria {
    
    public Igualdad(Expresion izquierda, Expresion derecha, String idVar) {
        super(izquierda, derecha, Tipo.BOOLEAN, idVar);
    }

    @Override
    protected String getNombreOperacion() {
        return "Igualdad";
    }
    
    public Igualdad clonar(){
        return new Igualdad(getIzquierda().clonar(), getDerecha().clonar(), getIdVar());
    }

    @Override
    public String get_llvm_op_code() {
        return getIzquierda().getTipo().equals(Tipo.FLOAT) ? "oeq" : "eq";
    }

    @Override
    public String generarCodigo(){
        return "%dest"+getIdVar()+" = "+get_llvm_arithmetic_op_code()+" "+get_llvm_op_code()+" "+get_llvm_type_code()+"  %dest"+getIzquierda().getIdVar()+", %dest"+getDerecha().getIdVar()+"\n";
    }
}

package compilador.ast.expresiones.binarias;

import compilador.ast.base.Tipo;
import compilador.ast.expresiones.Expresion;

public class Menor extends OperacionBinaria {
    
    public Menor(Expresion izquierda, Expresion derecha, String idVar) {
        super(izquierda, derecha, Tipo.BOOLEAN, idVar);
    }

    @Override
    protected String getNombreOperacion() {
       return "Menor";
    }
    
    public Menor clonar(){
        return new Menor(getIzquierda().clonar(), getDerecha().clonar(), getIdVar());
    }

    @Override
    public String get_llvm_op_code() {
        return getIzquierda().getTipo().equals(Tipo.FLOAT) ? "olt" : "slt";
    }

    @Override
    public String generarCodigo(){
        return "%dest"+getIdVar()+" = "+get_llvm_arithmetic_op_code()+" "+get_llvm_op_code()+" "+get_llvm_type_code()+"  %dest"+getIzquierda().getIdVar()+", %dest"+getDerecha().getIdVar()+"\n";
    }
}

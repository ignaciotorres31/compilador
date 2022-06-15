package compilador.ast.expresiones.binarias;

import compilador.ast.base.CodeGeneratorHelper;
import compilador.ast.base.Tipo;
import compilador.ast.expresiones.Expresion;



public class MayorIgual extends OperacionBinaria {
    
    public MayorIgual(Expresion izquierda, Expresion derecha) {
        super(izquierda, derecha, Tipo.BOOLEAN);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
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

    @Override
    public String get_llvm_type_code(){
        return getIzquierda().getTipo().equals(Tipo.INTEGER) ? "i32" : "double";
    }

    @Override
    public String generarCodigo(){
        String codigo = getIzquierda().generarCodigo();
        codigo += getDerecha().generarCodigo();
        codigo += "%var"+getIdVar()+" = "+get_llvm_arithmetic_op_code()+" "+get_llvm_op_code()+" "+get_llvm_type_code()+" %var"+getIzquierda().getIdVar()+", %var"+getDerecha().getIdVar()+"\n";
        return codigo;
    }
}

package compilador.ast.expresiones.binarias;

import compilador.ast.base.CodeGeneratorHelper;
import compilador.ast.base.Tipo;
import compilador.ast.expresiones.Expresion;


public class Mayor extends OperacionBinaria {
    
    public Mayor(Expresion izquierda, Expresion derecha) {
        super(izquierda, derecha, Tipo.BOOLEAN);
    }

    @Override
    protected String getNombreOperacion() {
        return "Mayor";
    }
    
    public Mayor clonar(){
        return new Mayor(getIzquierda().clonar(), getDerecha().clonar());
    }

    @Override
    public String get_llvm_op_code() {
        return getIzquierda().getTipo().equals(Tipo.FLOAT) ? "ogt" : "sgt";
    }
    
     @Override
    public String get_llvm_type_code(){
        return getIzquierda().getTipo().equals(Tipo.FLOAT) ? "double" : "i32";
    }

    @Override
    public String generarCodigo(){
        String codigo = getIzquierda().generarCodigo();
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
        codigo += getDerecha().generarCodigo();
        codigo += "%var"+getIdVar()+" = "+get_llvm_arithmetic_op_code()+" "+get_llvm_op_code()+" "+get_llvm_type_code()+"  %var"+getIzquierda().getIdVar()+", %var"+getDerecha().getIdVar()+"\n";
        return codigo;
    }
}

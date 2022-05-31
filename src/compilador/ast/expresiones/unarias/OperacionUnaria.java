package compilador.ast.expresiones.unarias;

import compilador.ast.expresiones.Expresion;
import compilador.ast.base.Tipo;
import compilador.llvm.CodeGeneratorHelper;

/**
 *
 * @author facundo
 */
public abstract class OperacionUnaria extends Expresion {
    private Expresion expresion;

    public OperacionUnaria(String nombre, Expresion expresion) {
        super(Tipo.UNKNOWN, nombre);
        this.expresion = expresion;
    }

    public OperacionUnaria(String nombre, Expresion expresion, Tipo tipo) {
        super(tipo, nombre);
        this.expresion = expresion;
    }

    public Expresion getExpresion() {
        return expresion;
    }

    public void setExpresion(Expresion expresion) {
        this.expresion = expresion;
    }

    @Override
    public String toString() {
        return String.format("%s %s", getEtiqueta(), getExpresion());
    }
    
    public abstract String get_llvm_op_code();
    
    @Override
    public String generarCodigo() {
        StringBuilder resultado = new StringBuilder();        
        resultado.append(this.getExpresion().generarCodigo());
        this.setIr_ref(CodeGeneratorHelper.getNewPointer());
        resultado.append(String.format("%1$s = %2$s i32 %3$s, %3$s\n", this.getIr_ref(), 
                this.get_llvm_op_code(), this.getExpresion().getIr_ref()));
        return resultado.toString();
    }
    
    
    @Override
    public String graficar(String idPadre){
        String grafico = super.graficar(idPadre);
        grafico += getExpresion().graficar(getId());
        return grafico;
    }
    
}

package compilador.ast.expresiones.binarias;

import compilador.ast.expresiones.Expresion;
import compilador.ast.expresiones.Tipo;
import compilador.llvm.CodeGeneratorHelper;

public abstract class OperacionBinaria extends Expresion {
    
    private Expresion izquierda;
    private Expresion derecha;

    public OperacionBinaria(Expresion izquierda, Expresion derecha) {
        this.izquierda = izquierda;
        this.derecha = derecha;
    }
    
    public OperacionBinaria(Expresion izquierda, Expresion derecha, String nombre) {
        super(Tipo.UNKNOWN, nombre);
        this.izquierda = izquierda;
        this.derecha = derecha;
    }


    @Override
    protected String getEtiqueta() {
        return String.format("%s", this.getNombreOperacion());
    }

    protected abstract String getNombreOperacion();

    @Override
    public String graficar(String idPadre) {
        final String miId = this.getId();
        return super.graficar(idPadre) +
                izquierda.graficar(miId) +
                derecha.graficar(miId);
    }
    
    public void setIzquierda(Expresion izquierda) {
        this.izquierda = izquierda;
    }

    public void setDerecha(Expresion derecha) {
        this.derecha = derecha;
    }

    public Expresion getIzquierda() {
        return izquierda;
    }

    public Expresion getDerecha() {
        return derecha;
    }
    
    public abstract String get_llvm_op_code();
    
    @Override
    public String generarCodigo(){
        StringBuilder resultado = new StringBuilder();        
        resultado.append(this.getIzquierda().generarCodigo());
        resultado.append(this.getDerecha().generarCodigo());
        this.setIr_ref(CodeGeneratorHelper.getNewPointer());
        resultado.append(String.format("%1$s = %2$s i32 %3$s, %4$s\n", this.getIr_ref(), 
                this.get_llvm_op_code(), this.getIzquierda().getIr_ref(), 
                this.getDerecha().getIr_ref()));
        return resultado.toString();
    }
}

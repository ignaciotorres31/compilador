package compilador.ast.expresiones.binarias;

import compilador.ast.expresiones.Expresion;
import compilador.ast.base.Tipo;

public abstract class OperacionBinaria extends Expresion {
    
   private Expresion izquierda;
    private Expresion derecha;

    public OperacionBinaria(Expresion izquierda, Expresion derecha, Tipo tipo, String idVar) {
        this.izquierda = izquierda;
        this.derecha = derecha;
        super.setTipo(tipo);
        super.setIdVar(idVar);
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

    public String get_llvm_arithmetic_op_code() {
        return getIzquierda().getTipo().equals(Tipo.FLOAT) ? "fcmp" : "icmp";
    }
    
    @Override
    public String generarCodigo(){
        String codigo = getIzquierda().generarCodigo();
        codigo += getDerecha().generarCodigo();
        codigo += "%dest"+getIdVar()+" = "+get_llvm_op_code()+" "+get_llvm_type_code()+" %dest"+getIzquierda().getIdVar()+", %dest"+getDerecha().getIdVar()+"\n";
        return codigo;
    }
}

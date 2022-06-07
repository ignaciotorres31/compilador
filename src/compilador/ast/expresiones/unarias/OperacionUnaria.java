package compilador.ast.expresiones.unarias;

import compilador.ast.expresiones.Expresion;
import compilador.ast.base.Tipo;

/**
 *
 * @author facundo
 */
public abstract class OperacionUnaria extends Expresion {
    private Expresion expresion;

    public OperacionUnaria(String nombre, Expresion expresion, Tipo tipo) {
        setTipo(tipo);
        setNombre(nombre);
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
    public String graficar(String idPadre){
        String grafico = super.graficar(idPadre);
        grafico += getExpresion().graficar(getId());
        return grafico;
    }
    
}

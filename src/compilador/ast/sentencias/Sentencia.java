package compilador.ast.sentencias;

import compilador.ast.base.Nodo;

public abstract class Sentencia extends Nodo {
    
    private String ir_ref;
    
    public Sentencia() {
    }

    public Sentencia(String nombre) {
        super(nombre);
    }

    public String getIr_ref() {
        return ir_ref;
    }

    public void setIr_ref(String ir_ref) {
        this.ir_ref = ir_ref;
    }
    
    
    
    public abstract Sentencia clonar();
}

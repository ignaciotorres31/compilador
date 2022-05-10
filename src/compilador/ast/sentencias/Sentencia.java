package compilador.ast.sentencias;

import compilador.ast.base.Nodo;

public abstract class Sentencia extends Nodo {
    public Sentencia() {
    }

    public Sentencia(String nombre) {
        super(nombre);
    }
}

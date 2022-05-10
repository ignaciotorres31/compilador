package compilador.ast.sentencias;

import compilador.ast.expresiones.Expresion;

public abstract class Seleccion extends Sentencia {
    private Expresion condicion;

    public Seleccion(String nombre, Expresion condicion) {
        super(nombre);
        this.condicion = condicion;
    }

    public Expresion getCondicion() {
        return condicion;
    }

    public void setCondicion(Expresion condicion) {
        this.condicion = condicion;
    }
}

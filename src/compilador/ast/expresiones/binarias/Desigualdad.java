package compilador.ast.expresiones.binarias;

import compilador.ast.expresiones.Expresion;

public class Desigualdad extends Relacion {
    
    public Desigualdad(Expresion izquierda, Expresion derecha) {
        super(izquierda, derecha, "!=");
    }


    @Override
    protected boolean calcularResultado(double izq, double der) {
        return izq != der;
    }

    @Override
    protected boolean calcularResultado(int izq, int der) {
        return izq != der;
    }
    
    @Override
    protected boolean calcularResultado(boolean izq, boolean der) {
        return izq != der;
    }

    @Override
    protected String getNombreOperacion() {
        return "Desigualdad"; 
    }
}

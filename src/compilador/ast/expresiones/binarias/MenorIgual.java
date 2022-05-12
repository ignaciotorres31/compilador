package compilador.ast.expresiones.binarias;

import compilador.ast.expresiones.Expresion;

public class MenorIgual extends Relacion {
    public MenorIgual(Expresion izquierda, Expresion derecha) {
        super(izquierda, derecha, "<=");
    }

    @Override
    protected boolean calcularResultado(double izq, double der) {
        return izq <= der;
    }
    
    @Override
    protected boolean calcularResultado(int izq, int der) {
        return izq <= der;
    }

    @Override
    protected boolean calcularResultado(boolean izq, boolean der) {
        throw new IllegalStateException("No se puede comparar entre BOOLEAN: " + izq + " <= " + der);
    }

    @Override
    protected String getNombreOperacion() {
        return "MenorIgual";
    }
}

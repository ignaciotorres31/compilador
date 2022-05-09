package compilador.ast.expresiones.binarias;

import compilador.ast.expresiones.Expresion;


public class Mayor extends Relacion {
    public Mayor(Expresion izquierda, Expresion derecha) {
        super(izquierda, derecha, ">");
    }

    @Override
    protected boolean calcularResultado(double izq, double der) {
        return izq > der;
    }

    @Override
    protected boolean calcularResultado(boolean izq, boolean der) {
        // Esto ya viene validado desde el transformer de tipos
        throw new IllegalStateException("No se puede comparar entre BOOLEAN: " + izq + " > " + der);
    }

    @Override
    protected String getNombreOperacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

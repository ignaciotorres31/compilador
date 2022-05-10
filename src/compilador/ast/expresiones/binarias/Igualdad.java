package compilador.ast.expresiones.binarias;

import compilador.ast.expresiones.Expresion;
import compilador.ast.expresiones.Tipo;


public class Igualdad extends Relacion {
    public Igualdad(Expresion izquierda, Expresion derecha) {
        super(izquierda, derecha, "==");
    }

    @Override
    protected boolean calcularResultado(double izq, double der) {
        return izq == der;
    }

    @Override
    protected boolean calcularResultado(boolean izq, boolean der) {
        return izq == der;
    }

    @Override
    protected String getNombreOperacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
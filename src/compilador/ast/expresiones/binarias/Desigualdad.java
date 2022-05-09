package compilador.ast.expresiones.binarias;

import compilador.ast.expresiones.Expresion;

public class Desigualdad extends Relacion {
    
    public Desigualdad(Expresion izquierda, Expresion derecha) {
        super(izquierda, derecha, "!=");
    }


    @Override
    protected boolean calcularResultado(double litIzq, double litDer) {
        return litIzq != litDer;
    }

    @Override
    protected boolean calcularResultado(boolean izq, boolean der) {
        return izq != der;
    }

    @Override
    protected String getNombreOperacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

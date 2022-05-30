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

    @Override
    public String get_llvm_op_code() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

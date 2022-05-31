package compilador.ast.expresiones.binarias;

import compilador.ast.base.Tipo;
import compilador.ast.expresiones.Expresion;

public class Menor extends Relacion {
    public Menor(Expresion izquierda, Expresion derecha) {
        super(izquierda, derecha, "<");
    }

    @Override
    protected boolean calcularResultado(double izq, double der) {
        return izq < der;
    }
    
    @Override
    protected boolean calcularResultado(int izq, int der) {
        return izq < der;
    }

    @Override
    protected boolean calcularResultado(boolean izq, boolean der) {
        throw new IllegalStateException("No se puede comparar entre BOOLEAN: " + izq + " < " + der);
    }

    @Override
    protected String getNombreOperacion() {
       return "Menor";
    }

    @Override
    public String get_llvm_op_code() {
        return getIzquierda().getTipo().equals(Tipo.FLOAT) ? "olt" : "slt";
    }
}

package compilador.ast.expresiones.binarias;

import compilador.ast.expresiones.Expresion;
import compilador.ast.base.OperadorComparacion;
import compilador.ast.base.Tipo;
import compilador.ast.expresiones.factor.Booleano;
import compilador.ast.expresiones.factor.Literal;
        

public abstract class Relacion extends OperacionBinaria {

    public Relacion(Expresion izquierda, Expresion derecha, String nombre) {
        super(izquierda, derecha, nombre);
    }

    public Expresion evaluar() {
        Expresion izquierda = getIzquierda();
        Expresion derecha = getDerecha();
        if (!(izquierda instanceof Literal && derecha instanceof Literal)) {
            return this;
        }

        boolean resultado;

        if (izquierda.getTipo().equals(Tipo.BOOLEAN) && derecha.getTipo().equals(Tipo.BOOLEAN)) {
            boolean valorIzq = ((Booleano) izquierda).getValor();
            boolean valorDer = ((Booleano) derecha).getValor();
            resultado = calcularResultado(valorIzq, valorDer);
        } else {
            double valorIzq = Literal.getNumero(izquierda).doubleValue();
            double valorDer = Literal.getNumero(derecha).doubleValue();
            resultado = calcularResultado(valorIzq, valorDer);
        }

        return new Booleano(resultado);
    }

    protected abstract boolean calcularResultado(double izq, double der);
    
    protected abstract boolean calcularResultado(int izq, int der);

    protected abstract boolean calcularResultado(boolean izq, boolean der);

    public static Relacion getClaseRel(OperadorComparacion op, Expresion expr1, Expresion expr2) {
        switch (op) {
            case IGUAL_IGUAL:
                return new Igualdad(expr1, expr2);
            case DESIGUAL:
                return new Desigualdad(expr1, expr2);
            case MAYOR:
                return new Mayor(expr1, expr2);
            case MAYOR_IGUAL:
                return new MayorIgual(expr1, expr2);
            case MENOR:
                return new Menor(expr1, expr2);
            case MENOR_IGUAL:
                return new MenorIgual(expr1, expr2);
            default:
                throw new IllegalStateException("Operador inesperado: " + op);
        }
    }
}

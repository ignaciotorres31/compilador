package compilador.ast.expresiones;

import compilador.ast.base.Nodo;

/**
 *
 * @author Nacho
 */
public abstract class Expresion extends Nodo {

    public abstract Expresion clonar();
}

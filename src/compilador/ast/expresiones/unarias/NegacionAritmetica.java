/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.ast.expresiones.unarias;

import compilador.ast.expresiones.Expresion;
import compilador.ast.expresiones.Tipo;
import compilador.ast.expresiones.factor.Entero;
import compilador.ast.expresiones.factor.Flotante;
import compilador.ast.expresiones.factor.Literal;

/**
 *
 * @author facundo
 */
public class NegacionAritmetica extends OperacionUnaria {
    
    public NegacionAritmetica(Expresion expresion) {
        super("-", expresion);
    }

    public Expresion evaluar() {
        Expresion expresion = getExpresion();
        if (!(expresion instanceof Literal)) {
            return this;
        }

        Number valor = Literal.getNumero(expresion);
        if (expresion.getTipo().equals(Tipo.FLOAT)) {
            return new Flotante(-valor.doubleValue());
        } else {
            return new Entero(-valor.intValue());
        }
    }

}
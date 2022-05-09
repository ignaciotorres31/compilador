/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.ast.expresiones.unarias;

import compilador.ast.expresiones.Expresion;
import compilador.ast.expresiones.Tipo;
import compilador.ast.expresiones.valor.Entero;
import compilador.ast.expresiones.valor.Flotante;
import compilador.ast.expresiones.valor.Literal;

/**
 *
 * @author facundo
 */
public class NegacionAritmetica extends OperacionUnaria {
    
    public NegacionAritmetica(Expresion expresion) {
        super("-", expresion);
    }

    public Expresion evaluar() {
        Expresion expresion = getExpresion().evaluar();
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
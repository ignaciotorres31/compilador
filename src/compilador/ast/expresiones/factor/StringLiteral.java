/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ast.expresiones.factor;

import compilador.ast.expresiones.Tipo;

/**
 *
 * @author Nacho
 */
public class StringLiteral extends Literal{
    private final String valor;

    public StringLiteral(String valor) {
        super(Tipo.STRING);
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public String toString() {
        return valor.toString();
    }
    
}

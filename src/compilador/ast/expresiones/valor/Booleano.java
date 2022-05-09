/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.ast.expresiones.valor;

import compilador.ast.expresiones.Expresion;
import compilador.ast.expresiones.Tipo;

/**
 *
 * @author facundo
 */
public class Booleano extends Literal {
    private final Boolean valor;

    public Booleano(Boolean valor) {
        super(Tipo.BOOLEAN);
        this.valor = valor;
    }

    public Boolean getValor() {
        return valor;
    }

    @Override
    public String toString() {
        // Usamos las constantes de IR "true" y "false"
        return valor.toString();
    }

    @Override
    public Expresion evaluar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

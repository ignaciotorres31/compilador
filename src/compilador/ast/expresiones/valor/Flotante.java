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
public class Flotante extends Literal {
    private final Double valor;

    public Flotante(Double valor) {
        super(Tipo.FLOAT);
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor.toString();
    }

    @Override
    public Expresion evaluar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.ast.expresiones.factor;

import compilador.ast.expresiones.Expresion;
import compilador.ast.expresiones.Tipo;

/**
 *
 * @author facundo
 */
public class Flotante extends Literal {
    private final Float valor;

    public Flotante(Float valor) {
        super(Tipo.FLOAT);
        this.valor = valor;
        setNombre("Float");
    }

    public Float getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor.toString();
    }
}

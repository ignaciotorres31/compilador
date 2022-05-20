/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.ast.expresiones.factor;

import compilador.ast.expresiones.Tipo;

/**
 *
 * @author facundo
 */
public class Entero extends Literal {
    
    private Integer valor;

    public Entero(Integer valor) {
        super(Tipo.INTEGER);
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }
    
    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor.toString();
    }

}

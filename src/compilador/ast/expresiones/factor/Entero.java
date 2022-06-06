/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.ast.expresiones.factor;

import compilador.ast.base.Tipo;

/**
 *
 * @author Nacho
 */
public class Entero extends Literal {
    
    private Integer valor;

    public Entero(Integer valor) {
        super(Tipo.INTEGER);
        this.valor = valor;
        setNombre("Integer");
    }

    public Integer getValor() {
        return this.valor;
    }
    
    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor.toString();
    }
    
    public Entero clonar(){
        return new Entero(getValor());
    }

    @Override
    public String generarCodigo() {
        return "";
    }
}

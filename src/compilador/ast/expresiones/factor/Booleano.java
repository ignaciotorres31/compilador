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
public class Booleano extends Literal {
    private final Boolean valor;

    public Booleano(Boolean valor) {
        super(Tipo.BOOLEAN);
        this.valor = valor;
        setNombre("Boolean");
    }

    public Boolean getValor() {
        return valor;
    }

    @Override
    public String toString() {        
        return valor.toString();
    }

    @Override
    public String generarCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.ast.expresiones;

import compilador.ast.base.Nodo;

/**
 *
 * @author facundo
 */
public abstract class Expresion extends Nodo {

    private Tipo tipo;

    public Expresion() {
        this.tipo = Tipo.UNKNOWN;
    }

    public Expresion(Tipo tipo) {
        this.tipo = tipo;
    }

    public Expresion(Tipo tipo, String nombre) {
        super(nombre);
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    
}

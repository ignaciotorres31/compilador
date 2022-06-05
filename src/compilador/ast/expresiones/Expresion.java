/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.ast.expresiones;

import compilador.ast.base.Tipo;
import compilador.ast.base.Nodo;

/**
 *
 * @author Nacho
 */
public abstract class Expresion extends Nodo {

   public Expresion() {
        super.setTipo(Tipo.UNKNOWN);
    }

    public Expresion(Tipo tipo) {
        super.setTipo(tipo);
    }

    public Expresion(Tipo tipo, String nombre) {
        super(nombre);
        super.setTipo(tipo);
    }
    
    public Expresion(String nombre){
        super(nombre);
    }

    public abstract Expresion clonar();
}

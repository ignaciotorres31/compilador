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

     private Tipo tipo;
    private String ir_ref;

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
    
    public Expresion(String nombre){
        super(nombre);
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getIr_ref() {
        return ir_ref;
    }

    public void setIr_ref(String ir_ref) {
        this.ir_ref = ir_ref;
    }

    public abstract Expresion clonar();
}

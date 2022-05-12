/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ast.base;

import compilador.ast.expresiones.Expresion;

/**
 *
 * @author Nacho
 */
public class ProgramaCompleto extends Nodo{
    
    private Bloque bloqueDeclaraciones;
    private Programa cuerpo;

    public ProgramaCompleto(String nombre, Bloque bloqueDeclaraciones, Programa cuerpo){
        super(nombre);
        this.bloqueDeclaraciones = bloqueDeclaraciones;      
        this.cuerpo = cuerpo;
    }
    
    public ProgramaCompleto(String nombre, Programa cuerpo){
        super(nombre);
        this.cuerpo = cuerpo;
    }
    
    public ProgramaCompleto(String nombre, Bloque bloqueDeclaraciones){
        super(nombre);
        this.bloqueDeclaraciones = bloqueDeclaraciones;      
    }

    public Bloque getBloqueDeclaraciones() {
        return this.bloqueDeclaraciones;
    }

    public void setBloqueDeclaraciones(Bloque bloqueDeclaraciones) {
        this.bloqueDeclaraciones = bloqueDeclaraciones;
    }

    public Programa getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(Programa cuerpo) {
        this.cuerpo = cuerpo;
    }
    
    
}

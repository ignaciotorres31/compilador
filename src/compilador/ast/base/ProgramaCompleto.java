/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ast.base;

/**
 *
 * @author Nacho
 */
public class ProgramaCompleto extends Nodo{
    
    private Bloque bloqueDeclaraciones;
    private Programa cuerpo;

    public ProgramaCompleto(Bloque bloqueDeclaraciones, Programa cuerpo){
        super("Programa");
        this.bloqueDeclaraciones = bloqueDeclaraciones;      
        this.cuerpo = cuerpo;
    }
    
    public ProgramaCompleto(Programa cuerpo){
        super("Programa");
        this.cuerpo = cuerpo;
    }
    
    public ProgramaCompleto(Bloque bloqueDeclaraciones){
        super("Programa");
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

    public String graficar() {
        // Acá se dispara la invocación a los métodos graficar() de los nodos.
        // Como la Impresion no tiene padre, se inicia pasando null.  
        StringBuilder resultado = new StringBuilder();
        resultado.append("graph G {");
        resultado.append(this.graficar(null));
        resultado.append(this.cuerpo.graficar(this.getId()));
        resultado.append("}");
        return resultado.toString();
    }
    
}

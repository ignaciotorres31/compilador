/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.ast.base;

import compilador.ast.expresiones.Expresion;
import compilador.ast.base.Programa;

/**
 *
 * @author facundo
 */
public class Impresion extends Nodo{
    
    private final ProgramaCompleto programa;
    
    public Impresion(ProgramaCompleto programa){
        this.programa = programa;
    }
    
    public String graficar() {
        // Acá se dispara la invocación a los métodos graficar() de los nodos.
        // Como la Impresion no tiene padre, se inicia pasando null.  
        StringBuilder resultado = new StringBuilder();
        resultado.append("graph G {");
        resultado.append(this.graficar(null));
        resultado.append(this.programa.graficar(this.getId()));
        resultado.append("}");
        return resultado.toString();
    }
    
}


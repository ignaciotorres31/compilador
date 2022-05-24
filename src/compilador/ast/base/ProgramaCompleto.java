/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ast.base;

import compilador.ast.expresiones.Expresion;
import compilador.llvm.CodeGeneratorHelper;

/**
 *
 * @author Nacho
 */
public class ProgramaCompleto extends Nodo{
    
    private Bloque bloqueDeclaraciones;
    private Programa cuerpo;
    private final Expresion expresion;

    public ProgramaCompleto(Bloque bloqueDeclaraciones, Programa cuerpo){
        super("Programa");
        this.bloqueDeclaraciones = bloqueDeclaraciones;      
        this.cuerpo = cuerpo;
    }
    
    public ProgramaCompleto(Expresion expresion){
        this.expresion = expresion;
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

    public Expresion getExpresion() {
        return expresion;
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
    
    @Override
    public String generarCodigo() {
        StringBuilder resultado = new StringBuilder();
        resultado.append(";Programa: Prueba\n");
        resultado.append("source_filename = \"Prueba.txt\"\n");
        resultado.append("target datalayout = \"e-m:w-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128\"\n");
        resultado.append("target triple = \"x86_64-pc-windows-msvc19.16.27038\"\n\n");
        resultado.append("declare i32 @printf(i8*, ...)\n");
        resultado.append("\n");
        resultado.append("@.integer = private constant [4 x i8] c\"%d\\0A\\00\"\n");
        resultado.append("\n");
        resultado.append("define i32 @main(i32, i8**) {\n\t");
        
        StringBuilder resultado_programa = new StringBuilder();

        resultado_programa.append(this.getExpresion().generarCodigo());
        
        resultado.append(resultado_programa.toString().replaceAll("\n", "\n\t"));
        
        resultado.append(String.format("%1$s = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i32 %2$s)\n", 
                    CodeGeneratorHelper.getNewPointer(), this.getExpresion().getIr_ref()));   
        
        resultado.append("\tret i32 0\n");
        resultado.append("}\n\n");
        

        return resultado.toString();    
    }
}

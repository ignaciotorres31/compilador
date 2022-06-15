package compilador.ast.base;


import java.util.ArrayList;
import java.util.Hashtable;
import java.text.Normalizer;
import java.util.Iterator;
import java.util.Map;



/**
 *
 * @author Nacho
 */
public class ProgramaCompleto extends Nodo{
    
    private Bloque bloqueDeclaraciones;
    private Programa cuerpo;
    private Hashtable tablaSimbolos;
    private ArrayList<String> valoresString;
    
    public ProgramaCompleto(Bloque bloqueDeclaraciones, Programa cuerpo, Hashtable tablaSimbolos, ArrayList<String> valoresString){
        super("Programa");
        this.bloqueDeclaraciones = bloqueDeclaraciones;      
        this.cuerpo = cuerpo;
        this.tablaSimbolos = tablaSimbolos;
        this.valoresString = valoresString;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    public ProgramaCompleto(Programa cuerpo, Hashtable tablaSimbolos, ArrayList<String> valoresString){
        super("Programa");
        this.cuerpo = cuerpo;
        this.tablaSimbolos = tablaSimbolos;
        this.valoresString = valoresString;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    public ProgramaCompleto(Bloque bloqueDeclaraciones,Hashtable tablaSimbolos, ArrayList<String> valoresString){
        super("Programa");
        this.bloqueDeclaraciones = bloqueDeclaraciones;      
        this.tablaSimbolos = tablaSimbolos;
        this.valoresString = valoresString;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    public Hashtable getTablaSimbolos() {
        return tablaSimbolos;
    }

    public void setTablaSimbolos(Hashtable tablaSimbolos) {
        this.tablaSimbolos = tablaSimbolos;
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
    
    private String getTipo_llvm(String tipo){
        return (tipo == "INTEGER") ? "i32" : ((tipo == "FLOAT") ? "double" : "i1");
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
        resultado.append("declare i32 @puts(i8*)\n");
        resultado.append("declare i32 @scanf(i8* %0, ...)\n");
        resultado.append("\n");
        resultado.append("@str.listavacia = private constant [20 x i8] c\"La lista esta vacia\\00\"\n");
        resultado.append("@str.pivotpositivo = private constant [22 x i8] c\"El valor debe ser >=1\\00\"\n");
        resultado.append("@str.cantinsuficiente = private constant [47 x i8] c\"La lista tiene menos elementos que el indicado\\00\"\n");
        resultado.append("@str.cantidadimpares = private constant [57 x i8] c\"No existen suficientes elementos impares para el calculo\\00\"\n");
        resultado.append("@.integer = private constant [4 x i8] c\"%d\\0A\\00\"\n");
        resultado.append("@.float = private constant [5 x i8] c\"%lf\\0A\\00\"\n");
        resultado.append("@.int_read_format = unnamed_addr constant [3 x i8] c\"%d\\00\"\n");
        resultado.append("@.double_read_format = unnamed_addr constant [4 x i8]  c\"%lf\\00\"\n");
        resultado.append("\n\n");
        
        for(String str : valoresString){
            resultado.append(str);
        }        
        
//        for (Iterator it = tablaSimbolos.entrySet().iterator(); it.hasNext();) {
//            Map.Entry<String,String> set = (Map.Entry<String,String>) it.next();
//            resultado.append(String.format("@%s = global %s ", set.getKey().toString(), getTipo_llvm(set.getValue().toString())));
//            if(getTipo_llvm(set.getValue().toString()) == "double"){
//                resultado.append("0.0\n");
//            }
//            else{
//                resultado.append("0\n");
//            }
//        }
        
        tablaSimbolos.forEach((k, v) -> {
            resultado.append(String.format("@%s = global %s ", k.toString(), getTipo_llvm(v.toString())));
            if(getTipo_llvm(v.toString()) == "double"){
                resultado.append("0.0\n");
            }
            else{
                resultado.append("0\n");
            }
        });
        resultado.append("\n\n");
        resultado.append("define i32 @main(i32, i8**) {\n\t");
        
        StringBuilder resultado_programa = new StringBuilder();

        resultado_programa.append(this.getCuerpo().generarCodigo());
        
        resultado.append(resultado_programa.toString().replaceAll("\n", "\n\t"));
        
        resultado.append("\n\tret i32 0\n");
        resultado.append("}");
//        resultado = new StringBuilder(Normalizer.normalize(resultado.toString(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));

        return resultado.toString();    
    }
}

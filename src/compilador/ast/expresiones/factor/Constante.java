/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compilador.ast.expresiones.factor;

import compilador.ast.expresiones.Expresion;
import compilador.ast.base.Tipo;

import compilador.llvm.CodeGeneratorHelper;

/**
 *
 * @author facundo
 */
public abstract class Constante extends Expresion {
    
    private Tipo tipo;
    
   public Constante(Tipo tipo) {
        super(tipo);
    }

    public Constante(Tipo tipo, String nombre) {
        super(tipo, nombre);
    }
    
    public Constante(String nombre){
        super(nombre);
    }

    @Override
    public String graficar(String idPadre){
        StringBuilder grafico = new StringBuilder();
        grafico.append(String.format("%1$s[label=\"%2$s : %3$s\"]\n", this.getId(), this.getNombre(), this.getEtiqueta()));
        if(idPadre != null)
            grafico.append(String.format("%1$s--%2$s\n", idPadre, this.getId()));
        return grafico.toString();
    }
    
    @Override
    public String generarCodigo() {
        StringBuilder resultado = new StringBuilder();
        this.setIr_ref(CodeGeneratorHelper.getNewPointer());
        resultado.append(String.format("%1$s = add i32 0, %2$s\n", this.getIr_ref(), /*this.getValor()*/this.getNombre()));
        return resultado.toString();
    }
}

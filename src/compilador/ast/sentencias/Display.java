/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ast.sentencias;

import compilador.ast.expresiones.Expresion;
import compilador.ast.expresiones.factor.StringLiteral;
import compilador.llvm.CodeGeneratorHelper;

/**
 *
 * @author Nacho
 */
public class Display extends Sentencia{
    
    private Expresion display;
    
    public Display(Expresion display){
        super("DISPLAY");
        this.display = display;
    }
    
    public Display(StringLiteral display){
        super("DISPLAY");
        this.display = display;
    }
    

    public Expresion getDisplay() {
        return display;
    }

    public void setDisplay(Expresion display) {
        this.display = display;
    }
    
    @Override
    public String graficar(String idPadre){
        String grafico = super.graficar(idPadre);
        grafico += display.graficar(getId());
        return grafico;
    }   
    
    public Display clonar(){
        return new Display(getDisplay().clonar());
    }

    @Override
    public String generarCodigo() {
        StringBuilder resultado = new StringBuilder();        
        resultado.append(this.getDisplay().generarCodigo());
        this.setIr_ref(CodeGeneratorHelper.getNewPointer());
        resultado.append(String.format("%1$s = call i32 @puts(i8* getelementptr ([11 x i8], [11 x i8] * %2$s, i32 0, i32 0))\n", this.getIr_ref(), 
                this.getDisplay().getIr_ref()));
        return resultado.toString();
    }
    
}

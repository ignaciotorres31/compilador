/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.ast.sentencias;

import compilador.ast.expresiones.Expresion;
import compilador.ast.expresiones.factor.StringLiteral;

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
        String codigo = "";
        switch (getDisplay().get_llvm_type_code()) {
            case "INTEGER":
                codigo += "%dest"+getIdVar()+"= call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), integer"
                        + "%"+ getIdVar();
                break;
            case "FLOAT":
                codigo += "%dest"+getIdVar()+"= call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.double, i32 0, i32 0), double"
                        + "%"+ getIdVar();
                break;
            case "BOOLEAN":
                codigo += "%dest"+getIdVar()+"= call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.boolean, i32 0, i32 0), boolean"
                        + "%"+ getIdVar();
                break;
            default:
                codigo += "%dest"+getIdVar()+"= call i32 @puts(i8* getelementptr ([11 x i8], [11 x i8] * @"+getIdVar()+", i32 0, i32 0))";
                break;
        }
        return codigo;
    }
    
}

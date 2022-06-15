package compilador.ast.sentencias;

import compilador.ast.base.CodeGeneratorHelper;
import compilador.ast.expresiones.Expresion;

/**
 *
 * @author Nacho
 */
public class Display extends Sentencia{
    
    private Expresion display;
    private Integer cantidadDigitos;
    
    public Display(Expresion display, Integer cantidadDigitos){
        setNombre("DISPLAY");
        this.display = display;
        setCantidadDigitos(cantidadDigitos);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    public Display(Expresion display){
        setNombre("DISPLAY");
        this.display = display;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }   

    public Expresion getDisplay() {
        return display;
    }

    public void setDisplay(Expresion display) {
        this.display = display;
    }

    public Integer getCantidadDigitos() {
        return cantidadDigitos;
    }
    
    public void setCantidadDigitos(Integer cantidadDigitos) {
        this.cantidadDigitos = cantidadDigitos;
    }
    
    @Override
    public String graficar(String idPadre){
        String grafico = super.graficar(idPadre);
        grafico += display.graficar(getId());
        return grafico;
    }   
    
    @Override
    public Display clonar(){
        return new Display(getDisplay().clonar(), getCantidadDigitos());
    }

    @Override
    public String generarCodigo() {
        String codigo = "";
        switch (getDisplay().getTipo()){
            case INTEGER:
                codigo += getDisplay().generarCodigo();
                codigo += "%dest"+getIdVar()+" = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i32"
                        + " %var"+ getDisplay().getIdVar()+")\n";
                break;
            case FLOAT:
                codigo += getDisplay().generarCodigo();
                codigo += "%dest"+getIdVar()+" = call i32 (i8*, ...) @printf(i8* getelementptr([5 x i8], [5 x i8]* @.float, i32 0, i32 0), double"
                        + " %var"+ getDisplay().getIdVar()+")\n";
                break;
            case BOOLEAN:
                codigo += getDisplay().generarCodigo();
                codigo += "%dest"+getIdVar()+" = call i32 (i8*, ...) @printf(i8* getelementptr([4 x i8], [4 x i8]* @.integer, i32 0, i32 0), i1"
                        + " %var"+ getDisplay().getIdVar()+")\n";
                break;
            default:
                codigo += "%dest"+getIdVar()+" = call i32 @puts(i8* getelementptr (["+(getCantidadDigitos()+1)+" x i8], ["+(getCantidadDigitos()+1)
                        +" x i8] * @str"+getDisplay().getIdVar()+", i32 0, i32 0))\n";
                break;
        }
        return codigo;
    }
    
}

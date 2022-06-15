
package compilador.ast.expresiones.factor;

import compilador.ast.base.CodeGeneratorHelper;
import compilador.ast.base.Tipo;
import compilador.ast.expresiones.Expresion;

/**
 *
 * @author nacho torres
 */
public class EnteroAFlotante extends Expresion {
    
    private Expresion entero;

    public EnteroAFlotante(Expresion entero){
        setEntero(entero);
        setTipo(Tipo.FLOAT);
        setNombre("IntegerToFloat");
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    public Expresion getEntero() {
        return entero;
    }
    public void setEntero(Expresion entero) {
        this.entero = entero;
    }

    public String graficar(String idPadre){
        String graph = super.graficar(idPadre);
        graph += getEntero().graficar(getId());
        return graph;
    }

    public String generarCodigo(){
        String codigo = getEntero().generarCodigo();
        codigo += "%var"+getIdVar()+" = sitofp i32 %var"+getEntero().getIdVar()+" to double\n";
        return codigo;
    }

    @Override
    public Expresion clonar() {
        return new EnteroAFlotante(getEntero().clonar());
    }
}

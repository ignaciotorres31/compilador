package compilador.ast.sentencias;

import compilador.ast.base.CodeGeneratorHelper;
import compilador.ast.expresiones.Expresion;
import compilador.ast.expresiones.Identificador;


public class Asignacion extends Sentencia {
    
   private Identificador ident;
    private Expresion expresion;

    public Asignacion(Identificador ident, Expresion e) {
        setNombre("=");
        this.ident = ident;
        this.expresion = e;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    public Identificador getIdent() {
        return ident;
    }

    public void setIdent(Identificador ident) {
        this.ident = ident;
    }

    public void setExpresion(Expresion expresion) {
        this.expresion = expresion;
    }

    public Expresion getExpresion() {
        return expresion;
    }
    
    @Override
    public String graficar(String idPadre){
        String grafico = super.graficar(idPadre);
        grafico += ident.graficar(getId());
        grafico += expresion.graficar(getId());
        return grafico;
    }
    
    public Asignacion clonar(){
        return new Asignacion(getIdent().clonar(), getExpresion().clonar());
    }

    @Override
    public String generarCodigo() {
        String codigo = getExpresion().generarCodigo();
        codigo += "store "+getExpresion().get_llvm_type_code()+" %var"+getExpresion().getIdVar()+", "+getIdent().get_llvm_type_code()+"* @"+getIdent().getNombre()+"\n";
        return codigo;
    }


}

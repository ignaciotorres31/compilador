package compilador.ast.sentencias;
        
import compilador.ast.expresiones.Identificador;
import compilador.ast.base.Tipo;

public class Declaracion extends Sentencia {
    private Identificador ident;
    private Tipo tipo;
    
    public Declaracion(Tipo tipo, Identificador ident){
        this.tipo = tipo;
        this.ident = ident;
    }

    public Identificador getIdent() {
        return ident;
    }

    public void setIdent(Identificador ident) {
        this.ident = ident;
    }

    public Tipo getTipo() {
        return ident.getTipo();
    }

    public void setTipo(Tipo tipo) {
        ident.setTipo(tipo);
    }

    @Override
    public String toString() {
        return ident.toString();
    }

    @Override
    public String getEtiqueta() {
        return getClass().getSimpleName();
    }
    
    public Declaracion clonar(){
        return new Declaracion(getTipo(), getIdent().clonar());
    }

    @Override
    public String generarCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

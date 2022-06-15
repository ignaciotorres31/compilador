package compilador.ast.sentencias;
        
import compilador.ast.base.Bloque;
import compilador.ast.base.CodeGeneratorHelper;
import compilador.ast.expresiones.Expresion;

public class Mientras extends Sentencia {
    
    private Expresion condicion;
    private Bloque bloqueSentencias;

    public Mientras(Expresion condicion, Bloque bloqueSentencias) {
        setNombre("WHILE");
        this.condicion = condicion;
        bloqueSentencias.setNombre("DO");
        this.bloqueSentencias = bloqueSentencias;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    public Expresion getCondicion() {
        return condicion;
    }

    public void setCondicion(Expresion condicion) {
        this.condicion = condicion;
    }

    public Bloque getBloqueSentencias() {
        return bloqueSentencias;
    }

    public void setBloqueSentencias(Bloque bloqueSentencias) {
        this.bloqueSentencias = bloqueSentencias;
    }
    
    public Mientras clonar(){
        return new Mientras(getCondicion().clonar(), getBloqueSentencias().clonar());
    }
    
    @Override
    public String graficar(String idPadre) {
        final String miId = this.getId();
        return super.graficar(idPadre) +
                condicion.graficar(miId) +
                bloqueSentencias.graficar(miId);
    }

    @Override
    public String generarCodigo() {
        StringBuilder codigo = new StringBuilder();
        codigo.append(String.format("br label %%etwhile%s\n", getIdVar()));
        codigo.append(String.format("etwhile%s:\n", getIdVar()));
        codigo.append(getCondicion().generarCodigo());
        codigo.append(String.format("br i1 %%var%s, label %%etwhiletrue%s, label %%etfinwhile%s\n", getCondicion().getIdVar(), getIdVar(), getIdVar()));
        codigo.append(String.format("etwhiletrue%s:\n", getIdVar()));
        codigo.append(getBloqueSentencias().generarCodigo());
        codigo.append(String.format("br label %%etwhile%s\n", getIdVar()));
        codigo.append(String.format("etfinwhile%s:\n", getIdVar()));
        return codigo.toString();
    }
}

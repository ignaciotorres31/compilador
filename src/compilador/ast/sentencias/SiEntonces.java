package compilador.ast.sentencias;

import compilador.ast.base.Bloque;
import compilador.ast.base.CodeGeneratorHelper;
import compilador.ast.expresiones.Expresion;

public class SiEntonces extends Seleccion {
    
    private Bloque bloqueSiEntonces;
    private Bloque bloqueSino;

    public SiEntonces(Expresion condicion, Bloque bloqueSiEntonces, Bloque bloqueSino) {
        setNombre("IF");
        setCondicion(condicion);
        bloqueSiEntonces.setNombre("THEN");
        bloqueSino.setNombre("ELSE");
        this.bloqueSiEntonces = bloqueSiEntonces;
        this.bloqueSino = bloqueSino;
    }
    public SiEntonces(Expresion condicion, Bloque bloqueSiEntonces) {
        setNombre("IF");
        setCondicion(condicion);
        bloqueSiEntonces.setNombre("THEN");
        this.bloqueSiEntonces = bloqueSiEntonces;
    }

    public Bloque getBloqueSiEntonces() {
        return bloqueSiEntonces;
    }
    public void setBloqueSiEntonces(Bloque bloqueSiEntonces) {
        this.bloqueSiEntonces = bloqueSiEntonces;
    }

    public Bloque getBloqueSino() {
        return bloqueSino;
    }
    public void setBloqueSino(Bloque bloqueSino) {
        this.bloqueSino = bloqueSino;
    }
    
     @Override
    public SiEntonces clonar(){
        if(getBloqueSino() != null){
            return new SiEntonces(getCondicion().clonar(), getBloqueSiEntonces().clonar(), getBloqueSino().clonar());   
        }
        return new SiEntonces(getCondicion().clonar(), getBloqueSiEntonces().clonar());
    }
    
    
    @Override
    public String graficar(String idPadre) {
        final String miId = this.getId();
        String grafico = super.graficar(idPadre) + 
            super.getCondicion().graficar(miId) +
            bloqueSiEntonces.graficar(miId);
        if(getBloqueSino() != null){
            grafico += getBloqueSino().graficar(getId());
        }
        return grafico;
    }

    @Override
    public String generarCodigo() {
        StringBuilder codigo = new StringBuilder();
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
        codigo.append(getCondicion().generarCodigo());
        if(getBloqueSino() == null){
            codigo.append(String.format("br i1 %%var%s, label %%etthen%s, label %%etfinif%s\n", getCondicion().getIdVar(), getIdVar(), getIdVar()));
            codigo.append(String.format("etthen%s:\n", getIdVar()));
            codigo.append(getBloqueSiEntonces().generarCodigo());
            codigo.append(String.format("br label %%etfinif%s\n", getIdVar()));
        }
        else{
            codigo.append(String.format("br i1 %%var%s, label %%etthen%s, label %%etelse%s\n", getCondicion().getIdVar(), getIdVar(), getIdVar()));
            codigo.append(String.format("etthen%s:\n", getIdVar()));
            codigo.append(getBloqueSiEntonces().generarCodigo());
            codigo.append(String.format("br label %%etfinif%s\n", getIdVar()));
            codigo.append(String.format("etelse%s:\n", getIdVar()));
            codigo.append(getBloqueSino().generarCodigo());
            codigo.append(String.format("br label %%etfinif%s\n", getIdVar()));
        }
        codigo.append(String.format("etfinif%s:\n", getIdVar()));
        return codigo.toString();
    }
}

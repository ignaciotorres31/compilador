package compilador.ast.base;

import compilador.ast.sentencias.Sentencia;
import java.util.*;

public class Programa extends Nodo {
    
    private ArrayList<Sentencia> cuerpo;

    public Programa(ArrayList<Sentencia> cuerpo) {
        this.cuerpo = cuerpo;
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    public ArrayList<Sentencia> getCuerpo() {
        return this.cuerpo;
    }

    public void setCuerpo(ArrayList<Sentencia> cuerpo) {
        this.cuerpo = cuerpo;
    }
    
    @Override
    public String graficar(String idPadre){
        String grafico = super.graficar(idPadre);
        for(Nodo prog : getCuerpo()){
            grafico += prog.graficar(getId());
        }
        return grafico;
    }

    @Override
    public String generarCodigo() {
        StringBuilder codigo = new StringBuilder();
        for(Nodo prog : getCuerpo()){
            codigo.append(prog.generarCodigo());
        }
        return codigo.toString();
    }

}

package compilador.ast.expresiones;

import compilador.ast.base.CodeGeneratorHelper;
import compilador.ast.base.Tipo;
import compilador.ast.expresiones.factor.Constante;
import compilador.ast.sentencias.Asignacion;
import compilador.ast.sentencias.Sentencia;
import java.util.ArrayList;

/**
 *
 * @author Nacho
 */
public class SumaImpar extends Expresion{
    
     private Constante pivot;
    private ArrayList<Sentencia> lista;
    private Asignacion contador;
    private Asignacion suma;
    private String nombreAux;
    private String nombreSuma;

    public SumaImpar(Constante pivot, ArrayList<Sentencia> lista, String nombreAux, String nombreSuma, Asignacion contador, Asignacion suma){
        this.pivot = pivot;
        this.lista = lista;
        this.nombreAux = nombreAux;
        this.nombreSuma = nombreSuma;
        this.contador = contador;
        this.suma = suma;
        super.setTipo(Tipo.INTEGER);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    public SumaImpar(Constante pivot, ArrayList<Sentencia> lista){
        this.pivot = pivot;
        this.lista = lista;
        super.setTipo(Tipo.INTEGER);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());        
    }
    
    public SumaImpar(ArrayList<Sentencia> lista){
        this.lista = lista;
        super.setTipo(Tipo.INTEGER);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }
    
    public Constante getPivot() {
        return pivot;
    }
    public void setPivot(Constante pivot) {
        this.pivot = pivot;
    }

    public ArrayList<Sentencia> getLista() {
        return lista;
    }
    public void setLista(ArrayList<Sentencia> lista) {
        this.lista = lista;
    }

    public Asignacion getContador() {
        return contador;
    }
    public void setContador(Asignacion contador) {
        this.contador = contador;
    }

    public Asignacion getSuma() {
        return suma;
    }
    public void setSuma(Asignacion suma) {
        this.suma = suma;
    }
    
    @Override
    public String graficar(String idPadre) {
        final String miId = this.getId();
        String grafico =  super.graficar(idPadre);
        if(getSuma() != null){
            grafico += contador.graficar(miId);
            grafico += suma.graficar(miId);
        }
        for(Sentencia exp : getLista()){
            grafico += exp.graficar(getId());
        }
        return grafico;
    }
    
    public SumaImpar clonar(){
        ArrayList<Sentencia> sentencias = new ArrayList<>();
        for(Sentencia sen : getLista()){
            Sentencia senCopia = sen.clonar();
            sentencias.add(senCopia);
        }
        return new SumaImpar(getPivot().clonar(), sentencias, this.nombreAux, this.nombreSuma, getContador().clonar(), getSuma().clonar());
    }

    @Override
    public String generarCodigo() {
        StringBuilder codigo = new StringBuilder();
        if(getSuma() != null){
            codigo.append(getSuma().generarCodigo());
            codigo.append(getContador().generarCodigo());
            for(Sentencia sen : getLista()){
                codigo.append(sen.generarCodigo());
            }
            codigo.append(String.format("%%var%s = load i32, i32* @%s\n", getIdVar(), this.nombreSuma));
        }
        else{
            for(Sentencia sen : getLista()){
                codigo.append(sen.generarCodigo());
            }
            codigo.append(String.format("%%var%s = add i32 0,0\n", getIdVar()));
        }
        return codigo.toString();
    }
    
}
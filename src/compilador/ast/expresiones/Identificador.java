package compilador.ast.expresiones;

import compilador.ast.base.CodeGeneratorHelper;
import compilador.ast.base.Tipo;
import compilador.ast.expresiones.factor.Constante;

/**
 *
 * @author Nacho
 */
public class Identificador extends Constante {
    
    private String nombreNodo = "ID";

    public Identificador(String nombre, Tipo tipo) {
        setTipo(tipo);
        setNombre(nombre);
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    @Override
    public String getEtiqueta() {
        return String.format("%s\\n<%s>", super.getNombre(), getTipo().toString());
    }
    
    @Override
    public String graficar(String idPadre){
        StringBuilder grafico = new StringBuilder();
        grafico.append(String.format("%1$s[label=\"%2$s : %3$s\"]\n", this.getId(), this.nombreNodo, this.getEtiqueta()));
        if(idPadre != null)
            grafico.append(String.format("%1$s--%2$s\n", idPadre, this.getId()));
        return grafico.toString();
    }

    public String getNombreNodo() {
        return nombreNodo;
    }

    public void setNombreNodo(String nombreNodo) {
        this.nombreNodo = nombreNodo;
    }

    @Override
    public String generarCodigo() {
        return "%var"+getIdVar()+" = load "+get_llvm_type_code()+", "+get_llvm_type_code()+"* @"+getNombre()+"\n";
    }
    
    public Identificador clonar(){
        return new Identificador(getNombre(), getTipo());
    }
}


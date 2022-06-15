package compilador.ast.expresiones.factor;

import compilador.ast.base.CodeGeneratorHelper;
import compilador.ast.base.Tipo;

/**
 *
 * @author Nacho
 */
public class StringLiteral extends Literal{
    private final String valor;

    public StringLiteral(String valor) {
        setTipo(Tipo.STRING);
        this.valor = valor;
        setNombre("String");
        this.setIdVar(CodeGeneratorHelper.getNewPointer());
    }

    public String getValor() {
        return valor;
    }

    public String toString() {
        return valor.toString();
    }
    
    public StringLiteral clonar(){
        StringLiteral str = new StringLiteral(getValor());
        if(getIdVar() == ".listavacia" | getIdVar() == ".cantinsuficiente" | getIdVar() == ".cantidadimpares" | getIdVar() == ".pivotpositivo"){
            str.setIdVar(getIdVar());
        }
        return str;
    }

    @Override
    public String generarCodigo() {
        StringBuilder codigo = new StringBuilder();
        codigo.append(String.format("@str%1$s = private constant [%2$s x i8] c\"%3$s\\00\"\n", 
                getIdVar(), (getValor().length()+1), getValor()));
        return codigo.toString();
    }
    
}

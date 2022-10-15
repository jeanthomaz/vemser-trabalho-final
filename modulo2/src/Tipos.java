import java.util.HashMap;
import java.util.Map;

public enum Tipos {
    JOGOS(1),
    CONSOLE(2),
    COLECIONAVEL(3);

    private int tipo;
    private String nome;

    private static final Map<Integer, Tipos> funcaoPorInt = new HashMap<>();

    static {
        for (Tipos tipo : Tipos.values()) {
         funcaoPorInt.put(tipo.getTipo(), tipo);
        }
    }

    public static Tipos pegaTipoPorValor(int inteiro) { return funcaoPorInt.get(inteiro);

    }

    Tipos(int tipo){
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

public class Produto {
    private String nome;
    private long id; //TESTE CRUD ID ÚNICO
    private int quantidade;
    private double valor; //TESTE CRUD VALOR > 0
    private String descricao;
    Tipos tipo;

    public Produto(){

    }

    public Produto(String nome, long id, int quantidade, double valor, String descricao, Tipos tipo) {
        this.nome = nome;
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                ", tipo=" + tipo +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {

        this.tipo = tipo;
    }
}

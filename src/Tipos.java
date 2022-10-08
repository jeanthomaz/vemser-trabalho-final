public enum Tipos {
    JOGOS(1, "jogos"),
    CONSOLE(2, "console"),
    COLECIONAVEL(3, "colecionável");

    private int tipo;
    private String nome;

    Tipos(int tipo, String nome){
        this.tipo = tipo;
        this.nome = nome;
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

import java.util.List;

public class Cliente extends Cadastro implements Comprar, Vender {

    private String email;
    private String senha;

    private String pix;

    private Cadastro cadastro;

    Cliente cliente;

    public Cliente(){

    }

    public Cliente(String nome, String endereco, String cpf, String cidade, String estado, String telefone, String email, String senha, String pix) {
        super(nome, endereco, cpf, cidade, estado, telefone);
        this.email = email;
        this.senha = senha;
        this.pix = pix;
    }

    public Cadastro getCadastro() {

        return cadastro;
    }

    public void setCadastro(Cadastro cadastro) {

        this.cadastro = cadastro;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cpf='" + cpf + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    @Override
    public void comprar() {
        System.out.println("Compra realizada com sucesso.");
    }


    @Override
    public void vender() {
        System.out.println("Venda feita com sucesso! ");
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void formaPag(Cliente cliente, String pix) {
        cliente.getPix();
    }


    public String getPix() {
        return pix;
    }

    public void setPix(String pix) {
        this.pix = pix;
    }
}

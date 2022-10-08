import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteManipulacao {

    private List<Cliente> listaDeClientes;

    public ClienteManipulacao() {

        this.listaDeClientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {

        this.listaDeClientes.add(cliente);
    }

    public void removerClientePorIndice(Integer index) {

        this.listaDeClientes.remove(index.intValue());

    }

    public void editarCliente(Integer index, Cliente cliente) {
        Cliente clienteProcurado = listaDeClientes.get(index);
        clienteProcurado.setNome(cliente.getNome());
        clienteProcurado.setEndereco(cliente.getEndereco());
        clienteProcurado.setCpf(cliente.getCpf());
        clienteProcurado.setCidade(cliente.getCidade());
        clienteProcurado.setEstado(cliente.getEstado());
        clienteProcurado.setTelefone(cliente.getTelefone());
        clienteProcurado.setEmail(cliente.getEmail());
        clienteProcurado.setSenha(cliente.getSenha());
    }

    public boolean testarEmail(String email) throws EmailRepetidoException {
        Optional<Cliente> testEmail = listaDeClientes.stream()
                .filter(cliente -> cliente.getEmail().contains(email))
                .findFirst();
        if (testEmail.isEmpty()) {
            return true;
        } else {
            throw new EmailRepetidoException("E-mail existente, digitar novamente");
        }
    }

    public Cliente fazerLogin(String email, String senha) throws EmailRepetidoException {
        Optional<Cliente> acessarEmail = listaDeClientes.stream()
                .filter(cliente -> cliente.getEmail().contains(email))
                .findFirst();
        if (acessarEmail.isPresent()) {
            Optional<Cliente> senhaIgual = acessarEmail.stream()
                    .filter(cliente -> cliente.getSenha().contains(senha))
                    .findFirst();
            if (senhaIgual.isPresent()) {
                return senhaIgual.get();
            } else {
                throw new EmailRepetidoException("Senha não existente, digitar novamente");
            }
        } else {
            throw new EmailRepetidoException("E-mail não existente, digitar novamente");
        }
    }

    public void listarClientes() {
        for (int i = 0; i < listaDeClientes.size(); i++) {
            System.out.println("id=" + i + " | " + listaDeClientes.get(i));
        }
    }
}

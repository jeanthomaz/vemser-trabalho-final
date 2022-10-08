import java.util.ArrayList;
import java.util.List;

public class CupomManipulacao {

    private List<Cupom> listaDeCupons;

    public CupomManipulacao() {
        this.listaDeCupons = new ArrayList<>();
    }

    public void adicionarCupom(Cupom cupom) {
        this.listaDeCupons.add(cupom);
    }

    public void removerCupomPorIndice(Integer index) {
        this.listaDeCupons.remove(index.intValue());
    }

    public void editarCupom(Integer index, Cupom cupom) {
        Cupom cupomProcurado = listaDeCupons.get(index);
        cupomProcurado.setValor(cupom.getValor());
        cupomProcurado.setValidade(cupom.isValidade());
    }

    public void listarCupons() {
        for (int i = 0; i < listaDeCupons.size(); i++) {
            System.out.println("id=" + i + " | " + listaDeCupons.get(i));
        }
    }
}

import java.util.*;

public class ElfoVerde extends Elfo {

    public ElfoVerde(String nome) {
        super(nome);
    }

    public void atirarFlecha(Dwarf dwarf) {
        super.atirarFlecha(dwarf);
        this.experiencia++;
    }

    public void adicionarItem(Item item) {
        String[] validas = new String[] { 
                "Espada de aço valiriano", 
                "Arco e Flecha de Vidro"
            };
        boolean podeAdicionar = item != null && new ArrayList<>(Arrays.asList(validas)).contains(item.getDescricao());

        if (podeAdicionar) {
            super.adicionarItem(item);
        }
    }
}

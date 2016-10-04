import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest {
    
    @Test
    public void elfoVerdeAdicionaEspadaValiriana() {
        ElfoVerde sortudo = new ElfoVerde("Sortudo");
        Item espada = new Item("Espada de aço valiriano", 1);
        sortudo.adicionarItem(espada);
        assertEquals(3, sortudo.getInventario().getItens().size());
        assertEquals(espada, sortudo.getInventario().getItens().get(2));
    }

    @Test
    public void elfoVerdeAdicionaItemComDescricaoInvalida() {
        ElfoVerde sortudo = new ElfoVerde("Mugless");
        Item caneca = new Item("Caneca", 1);
        sortudo.adicionarItem(caneca);
        boolean adicionou = sortudo.getInventario().getItens().contains(caneca);
        assertEquals(2, sortudo.getInventario().getItens().size());
        assertFalse(adicionou);
    }

    @Test
    public void elfoVerdeAdicionaArcoEFlechaVidroENulo() {
        ElfoVerde sortudo = new ElfoVerde("Celeborn");
        Item arcoEFlecha = new Item("Arco e Flecha de Vidro", 1);
        sortudo.adicionarItem(arcoEFlecha);
        sortudo.adicionarItem(null);
        assertEquals(3, sortudo.getInventario().getItens().size());
        assertEquals(arcoEFlecha, sortudo.getInventario().getItens().get(2));
    }

    @Test
    public void elfoVerdeAdicionaArcoEFlechaVidroEDescricaoNula() {
        ElfoVerde sortudo = new ElfoVerde("Celeborn");
        Item arcoEFlecha = new Item("Arco e Flecha de Vidro", 1);
        Item descricaoNula = new Item(null, 1);
        sortudo.adicionarItem(arcoEFlecha);
        sortudo.adicionarItem(descricaoNula);
        assertEquals(3, sortudo.getInventario().getItens().size());
        assertEquals(arcoEFlecha, sortudo.getInventario().getItens().get(2));
    } 
}

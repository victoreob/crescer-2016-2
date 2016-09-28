import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void elfoNasceComNome() {
        // Arrange
        String nomeEsperado = "Bruce Wayne";
        // Act
        Elfo elfoDoTeste = new Elfo(nomeEsperado);
        // Assert
        assertEquals(nomeEsperado, elfoDoTeste.getNome());
    }

    @Test
    public void elfoNasceComArco() {
        // Act
        Elfo elfoDoTeste = new Elfo("Elrond");
        // Assert
        assertEquals("Arco", elfoDoTeste.getArco().getDescricao());
        assertEquals(1, elfoDoTeste.getArco().getQuantidade());
    }

    @Test
    public void elfoNasceCom42Flechas() {
        // Act
        Elfo elfoDoTeste = new Elfo("Elrond");
        // Assert
        assertEquals("Flechas", elfoDoTeste.getFlecha().getDescricao());
        assertEquals(42, elfoDoTeste.getFlecha().getQuantidade());
    }

    @Test
    public void elfoAtiraUmaFlecha() {
        // Arrange
        Elfo legolas = new Elfo("Elfo");
        // Act
        legolas.atirarFlecha();
        // Assert
        assertEquals(41, legolas.getFlecha().getQuantidade());
        assertEquals(1, legolas.getExperiencia());
    }

    @Test
    public void elfoAtiraDuasFlecha() {
        // Arrange
        Elfo legolas = new Elfo("Elfo");
        // Act
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        // Assert
        assertEquals(40, legolas.getFlecha().getQuantidade());
        assertEquals(2, legolas.getExperiencia());
    }
    
    @Test
    public void elfoNaoAtiraFlecha() {
        // Arrange & Act
        Elfo legolas = new Elfo("Elfo");
        // Assert
        assertEquals(42, legolas.getFlecha().getQuantidade());
        assertEquals(0, legolas.getExperiencia());
    }

    @Test
    public void elfoAtira42Flechas() {
        // Arrange
        Elfo legolas = new Elfo("Elfo");
        // Act
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        // Assert
        assertEquals(0, legolas.getFlecha().getQuantidade());
        assertEquals(42, legolas.getExperiencia());
    }

    @Test
    public void elfoAtira43Flechas() {
        // Arrange
        Elfo legolas = new Elfo("Elfo");
        // Act
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        // Assert
        assertEquals(-1, legolas.getFlecha().getQuantidade());
        assertEquals(43, legolas.getExperiencia());
    }
}


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoDeElfosTest {
    @Test
    public void alistarUmElfoVerde() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfoVerde = new ElfoVerde("Elfo Verde");
        exercito.alistar(elfoVerde);
        assertEquals(elfoVerde, exercito.getContingente()[0]);
    }

    @Test
    public void alistarUmElfoNoturno() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfoNoturno = new ElfoNoturno("Night Elf");
        exercito.alistar(elfoNoturno);
        assertEquals(elfoNoturno, exercito.getContingente()[0]);
    }

    @Test
    public void alistarUmElfoNormal() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfoNormal = new Elfo("Elfo Normal");
        exercito.alistar(elfoNormal);
        assertEquals(0, exercito.getContingente().length);
    }

    @Test
    public void alistarDosTresTiposSoEntramVerdesENoturnos() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfoVerde = new ElfoVerde("Elfo Verde");
        Elfo elfoNormal = new Elfo("Elfo Normal");
        Elfo elfoNoturno = new ElfoNoturno("Night Elf");
        exercito.alistar(elfoVerde);
        exercito.alistar(elfoNormal);
        exercito.alistar(elfoNoturno);
        assertEquals(2, exercito.getContingente().length);
        assertEquals(elfoVerde, exercito.getContingente()[0]);
        assertEquals(elfoNoturno, exercito.getContingente()[1]);
    }

    @Test
    public void buscarExercitoVazio() {
        assertNull(new ExercitoDeElfos().buscar("Nenhum"));
    }

    @Test
    public void buscarPorNomeTendoApenasUmComAqueleNome() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo recruta1 = new ElfoVerde("Elfo Recruta 1");
        Elfo recruta2 = new ElfoNoturno("Elfo Recruta 2");
        Elfo recruta3 = new ElfoVerde("Elfo Recruta 3");
        exercito.alistar(recruta1);
        exercito.alistar(recruta2);
        exercito.alistar(recruta3);
        assertEquals(recruta2, exercito.buscar("Elfo Recruta 2"));
    }

    @Test
    public void buscarPorNomeTendoVariosComAqueleNome() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo recruta1 = new ElfoVerde("Elfo Recruta");
        Elfo recruta2 = new ElfoNoturno("Elfo Recruta 2");
        Elfo recruta3 = new ElfoVerde("Elfo Recruta");
        exercito.alistar(recruta1);
        exercito.alistar(recruta2);
        exercito.alistar(recruta3);
        assertEquals(recruta1, exercito.buscar("Elfo Recruta"));
    }
}
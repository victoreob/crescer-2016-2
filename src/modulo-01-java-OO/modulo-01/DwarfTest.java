import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void dwarfNasceCom110Vida() {
        Dwarf gimli = new Dwarf();
        assertEquals(110, gimli.getVida());
    }

    @Test
    public void dwarfPerdeVidaUmaVez() {
        Dwarf gimli = new Dwarf();
        gimli.perderVida();
        assertEquals(100, gimli.getVida());
    }

    @Test
    public void dwarfPerdeVidaDuasVezes() {
        Dwarf gimli = new Dwarf();
        gimli.perderVida();
        gimli.perderVida();
        assertEquals(90, gimli.getVida());
    }

    @Test
    public void dwarfPerdeVidaVinteVezes() {
        Dwarf gimli = new Dwarf();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        assertEquals(-90, gimli.getVida());
    }

    @Test
    public void dwarfCriadoInformandoNomeENascimento() {
        Dwarf gimli = new Dwarf("Gimli", new DataTerceiraEra(12, 11, 1900));
        assertEquals("Gimli", gimli.getNome());
        assertEquals(12, gimli.getDataNascimento().getDia());
        assertEquals(11, gimli.getDataNascimento().getMes());
        assertEquals(1900, gimli.getDataNascimento().getAno());
    }
    
    @Test
    public void dwarfCriadoSemInformarNomeENascimento() {
        Dwarf gimli = new Dwarf();
        assertNull(gimli.getNome());
        assertEquals(1, gimli.getDataNascimento().getDia());
        assertEquals(1, gimli.getDataNascimento().getMes());
        assertEquals(1, gimli.getDataNascimento().getAno());
    }
}


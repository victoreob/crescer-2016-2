public class Dwarf {
    private int vida;
    private DataTerceiraEra dataNascimento;
    private String nome;

    // java type initializer
    // vai ser replicado para cada construtor
    {
        vida = 110;
    }

    public Dwarf() {
        this(null, new DataTerceiraEra(1,1,1));
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public void perderVida() {
        vida -= 10;
    }

    public int getVida() {
        return vida;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public DataTerceiraEra getDataNascimento() {
        return this.dataNascimento;
    }
}
// Dwarf gimli;
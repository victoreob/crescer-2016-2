public class Dwarf {
    private int vida, experiencia;
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
        double numero = this.getNumeroSorte();
        if (numero < 0) {
            this.experiencia += 2;
        } 
        if (numero > 100) {
            vida -= 10;
        }
    }

    public int getVida() {
        return vida;
    }
    
    public int getExperiencia() {
        return experiencia;
    }

    public String getNome() {
        return this.nome;
    }

    public DataTerceiraEra getDataNascimento() {
        return this.dataNascimento;
    }

    public double getNumeroSorte() {
        double resultado = 101.;

        if (dataNascimento.ehBissexto() && this.vida >= 80 && this.vida <= 90) {
            resultado *= -33.0;
        }

        if (!dataNascimento.ehBissexto() && ("Seixas".equals(this.nome) || "Meireles".equals(this.nome))) {
            resultado = resultado * 33 % 100;
        }

        return resultado;
    }
}
// Dwarf gimli;
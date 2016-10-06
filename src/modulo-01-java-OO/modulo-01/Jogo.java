import java.util.Scanner;

public class Jogo {

    private static String texto = "EA Sports. It's in the game...";

    public static void main(String[] args) {
        System.out.println(texto);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o tipo de Exército:");
        System.out.println("1 - Exército normal");
        System.out.println("2 - Batalhão especial");
        System.out.println("3 - Faca na caveira");
        int tipo = scanner.nextInt();
        Exercito exercito = Jogo.criarExercito(tipo);
        exercito.atacar();
    }

    private static Exercito criarExercito(int tipo) {
        Exercito exercito = null;
        switch (tipo) {
            case 1:
            exercito = new ExercitoDeElfos();
            break;
            case 2:
            exercito = new BatalhaoEspecialDeElfos();
            break;
            case 3:
            exercito = new BOPElfos();
        }
        return exercito;
    }

}


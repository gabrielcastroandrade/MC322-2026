import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);

        System.out.println("Boa noite Ogro, seja bem vindo ao Shrek 2077: a volta dos que não foram!!!");

        // inicio do jogo
        String in_nome; int dificuldade;
        System.out.println("Digite o nome de seu heroi ogro: ");
        in_nome = input.nextLine();
        System.out.println("Informe a dificuldade do jogo (fácil >>> 1, 2 ou 999 >>> difícil): ");
        dificuldade = input.nextInt();
        while (dificuldade != 1 && dificuldade != 2 && dificuldade != 999) 
        {
            System.out.println("Dificuldade inválide, tente novamente (fácil >>> 1, 2 ou 999 >>> difícil): ");
            dificuldade = input.nextInt();
        }
        
        Jogo jogo = new Jogo(in_nome, dificuldade);
    }
}

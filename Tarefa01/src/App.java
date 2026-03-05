import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);

        System.out.println("Boa noite Ogro, seja bem vindo ao Shrek 2077: a volta dos que não foram!!!");

        // leitura do nome do jogador
        String in_nome; int dificuldade;
        System.out.println("Digite o nome de seu heroi ogro: ");
        in_nome = input.nextLine();

        // leitura da dificuldade
        System.out.println("Escolha seu oponente: ");
        System.out.println("1 - A Dragoa");
        System.out.println("2 - A Morte Encarnada");
        System.out.println("3 - #@%$&¨@*%");

        dificuldade = input.nextInt();
        while (dificuldade != 1 && dificuldade != 2 && dificuldade != 3) 
        {
            System.out.println("Oponente inválido, tente novamente: ");
            dificuldade = input.nextInt();
        }
        
        // inicialização do jogo
        Jogo jogo = new Jogo(in_nome, dificuldade);
        jogo.rodar();
    }
}

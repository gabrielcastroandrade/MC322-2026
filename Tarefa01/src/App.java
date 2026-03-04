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

        // configurações da dificuldade
        int vida_jogador = 0;
        int escudo_i = 0;
        int energia_i = 0;
        int dano_jogador = 0;

        int vida_inimigo = 0;
        String nome_inimigo = "Midon";
        int dano_inimigo = 0;

        if (dificuldade == 1) 
        {
            vida_jogador = 3;
            escudo_i = 3;
            energia_i = 3;
            dano_jogador = 3;

            vida_inimigo = 4;
            dano_inimigo = 1;
            nome_inimigo = "A Dragoa";
        }

        if (dificuldade == 2) 
        {
            vida_jogador = 2;
            escudo_i = 2;
            energia_i = 2;
            dano_jogador = 2;

            vida_inimigo = 5;
            dano_inimigo = 1;
            nome_inimigo = "A Morte";
        }

        if (dificuldade == 999) 
        {
            vida_jogador = 1;
            escudo_i = 1;
            energia_i = 1;
            dano_jogador = 1;

            vida_inimigo = 10000;
            dano_inimigo = 1;
            nome_inimigo = "O BURRO !!!";
        }

        Heroi jogador = new Heroi(in_nome, vida_jogador, escudo_i);
        Inimigo oponente = new Inimigo(nome_inimigo, vida_inimigo, escudo_i);

    }
}

import java.util.Scanner;

public class Jogo {

    private Heroi jogador;
    private Inimigo inimigo;

    private String nome_jogador;
    private String nome_inimigo;

    private int dificuldade = 1;
    private int vida_jogador = 3;
    private int energia_base = 3;
    private int dano_base = 1;
    private int vida_inimigo = 0;

    Scanner scanner = new Scanner(System.in);


    public Jogo (String nome_jogador, int dificuldade) 
    {
        this.nome_jogador = nome_jogador;
        this.dificuldade = dificuldade;

        if (dificuldade == 1) 
        {
            vida_inimigo = 2;
            nome_inimigo = "A Dragoa";
        }

        if (dificuldade == 2) 
        {
            vida_inimigo = 3;
            nome_inimigo = "A Morte Encarnada";
        }

        if (dificuldade == 3) 
        {
            vida_inimigo = 10000;
            nome_inimigo = "O BURRO !!!";
        }

        jogador = new Heroi(nome_jogador, vida_jogador);
        inimigo = new Inimigo(nome_inimigo, vida_inimigo);
        }
        
        public void rodar() 
        {
            while (jogador.estarVivo() && inimigo.estarVivo()) 
            {
                Rodada round = new Rodada(jogador, inimigo, energia_base, dano_base);
                round.rodar();
                System.out.println("Pressione Enter para continuar: ");
                scanner.nextLine(); 
            }

            if (jogador.estarVivo()) 
            {
                System.out.println("Parabéns, você derrotou o inimigo");
            }

            if (inimigo.estarVivo()) 
            {
                System.out.println("Derrota, o inimigo acabou com você");
            }
            
        }

}



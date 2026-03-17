import java.util.Scanner;

public class Jogo {

    private Heroi jogador;
    private Inimigo inimigo;

    private String nome_jogador;
    private String nome_inimigo;

    private int oponente = 1;
    private int vida_jogador = 3;
    private int energia_base = 5;
    private int dano_inimigo = 1;
    private int vida_inimigo = 0;
    private Scanner input;

    public Jogo (String nome_jogador, int oponente, Scanner input) 
    {
        this.nome_jogador = nome_jogador;
        this.oponente = oponente;
        this.input = input;

        if (oponente == 1) 
        {
            vida_inimigo = 4;
            dano_inimigo = 1;
            nome_inimigo = "A Dragão";
        }

        if (oponente == 2) 
        {
            vida_inimigo = 6;
            dano_inimigo = 2;
            nome_inimigo = "A Morte Encarnada";
        }

        if (oponente == 3) 
        {
            vida_inimigo = 10000;
            dano_inimigo = 3;
            nome_inimigo = "O BURRO";
        }

        jogador = new Heroi(nome_jogador, vida_jogador);
        inimigo = new Inimigo(nome_inimigo, vida_inimigo, dano_inimigo);
        }
        
        public void rodar() 
        {
            while (jogador.estarVivo() && inimigo.estarVivo()) 
            {
                Rodada round = new Rodada(jogador, inimigo, energia_base, input);
                round.rodar();
                System.out.println("Pressione Enter para continuar: ");
                input.nextLine(); 
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



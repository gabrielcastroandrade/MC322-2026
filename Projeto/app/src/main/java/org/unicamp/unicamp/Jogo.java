package org.unicamp.unicamp;

import java.util.Scanner;

/**
 * Classe Jogo extende a classe abstrata publisher.
 * Classe responsável pelas rodadas e suas sucessões.
 */
public class Jogo extends Publisher{

    private final int vida_jogador = 3;
    private final int energia_base = 5;
    private final int num_cartas_mao = 4;
    private final int dano_base_jogador = 1;

    private int dano_inimigo = 1;
    private final Heroi jogador;
    private final Inimigo inimigo;
    private String nome_inimigo;
    private int vida_inimigo = 0;
    private final Scanner input;

    public Jogo (String nome_jogador, int oponente, Scanner input) 
    {
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

        jogador = new Heroi(nome_jogador, vida_jogador, dano_base_jogador);
        inimigo = new Inimigo(nome_inimigo, vida_inimigo, dano_inimigo);
    }

    /**
     * Método responsável por fazer uma rodada acontecer (inclui o turno do inimigo e do jogador).
     */
    public void rodarRound() 
    {
        // inicializa os dados dos baralhos
        Baralho baralho = new Baralho(jogador);
        int energia = energia_base;
        
        int acao_inimigo = inimigo.escolherAcao();

        // se o inimigo for defender, já defende agora
        this.notificar("inimgo vai defender");
        inimigo.agirDefesa(acao_inimigo);
        
        // turno do jogador
        this.notificar("jogador começará seu turno");
        while (baralho.getLenMao() < num_cartas_mao && baralho.getLenCompra() > 0) {baralho.comprar();}
        while (energia > 0) 
        {
            if (!inimigo.estarVivo()) {break;}

            // dados do duelo -------------------------------------------------------------------------------------------
            System.out.println("-//-");
            System.out.println(
                jogador.getNome() 
                + " (vida: " + jogador.getVida() 
                + " / escudo: " + jogador.getEscudo() + ")"
            );
            System.out.println("efeitos:");
            jogador.printEfeitos();
            System.out.println("vs");
            System.out.println(
                inimigo.getNome() 
                + " (vida: " + inimigo.getVida() 
                + " / escudo: " + inimigo.getEscudo() + ")"
            );
            System.out.println("efeitos:");
            inimigo.printEfeitos();
            System.out.println("-//-");
            System.out.println();


            // opções de ação do jogador -----------------------------------------------------------------------------------
            // System.out.println("(pilha de compra: " + baralho.getLenCompra() + " cartas)");
            // System.out.println("(pilha de descarte: " + baralho.getLenDescarte() + " cartas)");
            System.out.println("(energia: " + energia + ")");
            System.out.println("["+0+"]" + " - Encerrar turno");
            for (int i = 0; i < baralho.getLenMao(); i++) 
            {
                Carta carta = baralho.getMaoIndice(i);
                System.out.println("["+(i+1)+"]" + " - " + carta.nome + " - " + carta.descricao + " - (custo " + carta.custo + ")");
            }
            System.out.println("Digite o número da sua próxima ação: ");
            int escolha;
            escolha = input.nextInt();
            while (escolha < 0 || escolha > baralho.getLenMao()) 
            {
                System.out.println("Opção indisponível, tente novamente: ");
                escolha = input.nextInt();
            }
            escolha -= 1;
            if (escolha == -1) {break;}
            Carta carta_escolhida = baralho.getMaoIndice(escolha);
            while (carta_escolhida.getCusto() > energia) 
            {
                System.out.println("Energia insulficiente, tente novamente: ");
                escolha = input.nextInt();
                carta_escolhida = baralho.getMaoIndice(escolha);
            }

            // lidando com a escolha -------------------------------------------------------------------------------------
            this.notificar("jogador vai realizar sua ação");
            int custo = jogador.agir(escolha, carta_escolhida, inimigo, baralho, this);
            energia -= custo;
            if (baralho.getLenCompra() == 0) {baralho.reiniciar();}
        }    

        // fim do turno do jogador ------------------------------------------------------------------------------------------
        this.notificar("fim do turno do jogador");
        System.out.println("fim do turno do jogador");        
        if (!inimigo.estarVivo()) {return;}
        if (!jogador.estarVivo()) {return;}

        // se o inimigo for atacar, ataca aqui -------------------------------------------------------------------------------
        this.notificar("inimmgo vai atacar");
        inimigo.agirAtaque(acao_inimigo, jogador);      
        // fim da rodada ----------------------------------------------------------------------------------------------------
        System.out.println();

        jogador.zerarEscudo();
        inimigo.zerarEscudo();
        jogador.limpezaEfeitos();
        inimigo.limpezaEfeitos();

        this.notificar("fim da rodada");
    };
       
    /**
     * Método responsável por fazer o jogo rodar.
     * Gera um loop de rodadas enquanto nenhum dos oponentes for derrotado.
     */
    public void rodarJogo() 
    {
        while (jogador.estarVivo() && inimigo.estarVivo()) 
        {
            this.rodarRound();
            System.out.println("Pressione Enter para continuar: ");
            System.out.println();
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
    };

    // achar um lugar bunitin pra isso, tá dificil
    public void limparTerminal() 
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}



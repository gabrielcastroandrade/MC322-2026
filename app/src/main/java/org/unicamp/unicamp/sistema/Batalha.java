package org.unicamp.unicamp.sistema;

import java.util.Scanner;

import org.unicamp.unicamp.conteudos.Carta;
import org.unicamp.unicamp.conteudos.Entidade;
import org.unicamp.unicamp.conteudos.Heroi;
import org.unicamp.unicamp.conteudos.Inimigo;

/**
 * Classe Batalha extende a classe abstrata publisher.
 * Classe responsável pelas rodadas e suas sucessões.
 */
public class Batalha extends Publisher{

    private final int energia_base;
    private final int num_cartas_mao;

    private int dano_inimigo = 1;
    private final Heroi jogador;
    private final Inimigo inimigo;
    private String nome_inimigo;
    private int vida_inimigo = 0;
    private final Scanner input;

    public Batalha (Heroi jogador, String oponente, Scanner input, int energia_base, int num_cartas_mao) 
    {
        this.input = input;
        this.jogador = jogador;
        this.energia_base = energia_base;
        this.num_cartas_mao = num_cartas_mao;

        if (oponente.equals("A Dragão")) 
        {
            vida_inimigo = 5;
            dano_inimigo = 1;
            nome_inimigo = "A Dragão";
        }

        if (oponente.equals("A Morte")) 
        {
            vida_inimigo = 4;
            dano_inimigo = 2;
            nome_inimigo = "A Morte";
        }

        if (oponente.equals("O Burro")) 
        {
            vida_inimigo = 3;
            dano_inimigo = 3;
            nome_inimigo = "O Burro";
        }

        inimigo = new Inimigo(nome_inimigo, vida_inimigo, dano_inimigo);
        jogador.reinscreverEfeitos(this);
        inimigo.reinscreverEfeitos(this);
    }

    public String getNomeInimigo() 
    {
        return inimigo.getNome();
    }

    /**
     * Método responsável por fazer uma rodada acontecer (inclui o turno do inimigo e do jogador).
     */
    public void rodarRound() 
    {
        // inicializa os dados dos baralhos
        Baralho baralho = new Baralho();
        int energia = energia_base;
        
        int acao_inimigo = inimigo.escolherAcao();
        this.notificar("inimgo vai defender");
        inimigo.agirDefesa(acao_inimigo, jogador);
        
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
                System.out.println("["+(i+1)+"]" + " - " + carta.getNome() + " - " + carta.getDescricao() + " - (custo " + carta.getCusto() + ")");
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
        System.out.println("fim do turno");        
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
       
    @Override

    /**
     * Método responsável por fazer a batalha rodar.
     * Gera um loop de rodadas enquanto nenhum dos oponentes for derrotado.
     * @return Entidade vencedora
     */
    public Entidade iniciar(Heroi jogador) 
    {
        while (jogador.estarVivo() && inimigo.estarVivo()) 
        {
            this.rodarRound();
            System.out.println("Pressione [1] para continuar: ");
            System.out.println();
            input.nextInt();
        }

        if (jogador.estarVivo()) 
        {
            return jogador;
        }

        if (inimigo.estarVivo()) 
        {
            return inimigo;
        }

        return inimigo;
    };

    // achar um lugar bunitin pra isso, tá dificil
    public void limparTerminal() 
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}



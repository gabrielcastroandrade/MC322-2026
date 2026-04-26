package org.unicamp.unicamp.sistema;

import java.util.Scanner;
import java.util.Stack;

import org.unicamp.unicamp.conteudos.Alongamento;
import org.unicamp.unicamp.conteudos.BanhoDeLama;
import org.unicamp.unicamp.conteudos.Entidade;
import org.unicamp.unicamp.conteudos.Heroi;
import org.unicamp.unicamp.conteudos.Inimigo;

/**
 * Classe responsável por organizar o jogo, incluindo os diferentes combates
 */
public class Jogo {

    private final Scanner input;

    private final int vida_jogador = 3;
    private final int energia_base = 5;
    private final int num_cartas_mao = 4;
    private final int dano_base_jogador = 1;
    private final Stack<String> escolhas = new Stack<>();;
    private Baralho baralho;
    private Mapa mapa;

    private Heroi jogador;

    public Jogo(Scanner input) 
    {
        this.input = input;
        escolhas.push("Enfrentar a Dragão");
        escolhas.push("Enfrentar a Morte");
        escolhas.push("Enfrentar o Burro");
        escolhas.push("Tomar um Banho"); 
        escolhas.push("Alongar");
        this.mapa = new Mapa(escolhas);
        this.baralho = new Baralho(); 
    }

    /**
     * Coloca o jogo em movimento
     * @return boolean - retorna True se o jogador ganhou de todos os inimigos, False se ele perdeu para algum
     */
    public boolean rodarJogo() 
    {
        // criação do personagem do jogador
        String nome_jogador = this.lerNome();
        jogador = new Heroi(nome_jogador, vida_jogador, dano_base_jogador);

        System.out.println("");
        System.err.println("Três desafiantes secretos invadem seu pântano...");

        while(!escolhas.empty()) 
        {
            String proxEscolha = this.lerEscolha();
            mapa.proxEscolha(proxEscolha);
            this.processarEscolha(proxEscolha);
            
            // confere se o jogador morreu
            if (!jogador.estarVivo()) 
            {
                return false;
            }

            System.out.println();
            mapa.printCaminho();
            System.out.println();
        }
        return true;

    }

    /**
     * Cuida de todo o processo de ler o nome do jogador
     * @return String - nome do jogador
     */
    public String lerNome() 
    {
        String nome_jogador;
        System.out.println("Digite o nome de seu heroi ogro: ");
        nome_jogador = input.nextLine();
        return nome_jogador;
    }

    /**
     * Cuida de todo o processo do jogador selecionar sua próxima escolha
     * @return String - o nome da escolha selecionada
     */
    public String lerEscolha() 
    {
        System.out.println("");
        System.out.println("Escolha sua ação: ");
        escolhas.forEach(nome -> System.out.println("[" + escolhas.indexOf(nome) + "] - " + nome));
        int escolha = input.nextInt();
        while ( !escolhas.contains((escolhas.get(escolha))) ) 
        {
            System.out.println("Escolha inválida, tente novamente: ");
            escolha = input.nextInt();
        }
        return (escolhas.get(escolha));
    }

    /**
     * Processa a escolha do jogador, identificando qual tipo de evento se trata e o realizando
     * @param escolha String - nome do evento escolhido
     */
    public void processarEscolha(String escolha) 
    {
        // evento do tipo batalha
        if (escolha.equals("Enfrentar a Dragão") || escolha.equals("Enfrentar a Morte") || escolha.equals("Enfrentar o Burro")) 
        {
            Batalha dueloAtual = new Batalha(jogador, this.getNomeAcao(escolha), input, energia_base, num_cartas_mao);
            Entidade vencedor = dueloAtual.iniciar(jogador, baralho);
            if (vencedor instanceof Heroi) 
            {
                System.out.println("");
                System.out.println("Você derrotou " + this.getNomeAcao(escolha));
                baralho.upgrade();
            }
            if (vencedor instanceof Inimigo)
            {
                System.out.println("");
                System.out.println(this.getNomeAcao(escolha) + " te derrotou");
            } 
        }
        // evento de banho de lama
        else if (escolha.equals("Tomar um Banho")) 
        {
            BanhoDeLama evento = new BanhoDeLama();
            evento.iniciar(jogador, null); 
        }
        // evento de alongamento
        else if (escolha.equals("Alongar")) 
        {
            Alongamento evento = new Alongamento();
            evento.iniciar(jogador, baralho); 
        }
    }

    /**
     * Recebe a String da ação e devolve a String a ser impressa.
     * @param acao String - nome da ação
     * @return String - pode printar
     */
    public String getNomeAcao(String acao) 
    {
        if (acao.equals("Enfrentar a Dragão")) 
        {
            return "A Dragão";
        }
        else if (acao.equals("Enfrentar a Morte")) 
        {
            return "A Morte";
        }
        else if (acao.equals("Enfrentar o Burro")) 
        {
            return "O Burro";
        }
        else {return "";}
    }


}

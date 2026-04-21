package org.unicamp.unicamp.sistema;

import java.util.Scanner;
import java.util.Stack;

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

    private Heroi jogador;

    public Jogo(Scanner input) 
    {
        this.input = input;
        escolhas.push("A Dragão");
        escolhas.push("A Morte");
        escolhas.push("O Burro");
        escolhas.push("Banho de lama"); // recupera toda sua vida, te dando +1 de brinde
        escolhas.push("Treinamento ogro"); // adiciona as cartas de tecnica faixa preta e aura + ego ao seu deque
    }

    /**
     * Coloca o jogo em movimento
     * @return boolean - retorna True se o jogador ganhou de todos os inimigos, False se ele perdeu para algum
     */
    public boolean rodarJogo() 
    {
        String nome_jogador = this.lerNome();
        jogador = new Heroi(nome_jogador, vida_jogador, dano_base_jogador);
        Mapa mapa = new Mapa(escolhas);

        System.err.println("Três desafiantes secretos invadem seu pântano...");
        while(!escolhas.empty()) 
        {
            String proxInimigo = this.lerEscolha();
            mapa.proxEscolha(proxInimigo);
            Batalha dueloAtual = new Batalha(jogador, proxInimigo, input, energia_base, num_cartas_mao);
            Entidade vencedor = dueloAtual.rodarBatalha();
            if (vencedor instanceof Heroi) 
            {
                System.out.println("Você derrotou " + proxInimigo);
                System.out.println();
                mapa.printCaminho();
                System.out.println();
            }
            if (vencedor instanceof Inimigo)
            {
                System.out.println(proxInimigo + " te derrotou");
                System.out.println();
                mapa.printCaminho();
                System.out.println();
                return false;
            }
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
        System.out.println("Escolha seu oponente: ");
        escolhas.forEach(nome -> System.out.println("[" + escolhas.indexOf(nome) + "] - " + nome));
        int oponente = input.nextInt();
        while ( !escolhas.contains((escolhas.get(oponente))) ) 
        {
            System.out.println("Oponente inválido, tente novamente: ");
            oponente = input.nextInt();
        }
        return (escolhas.get(oponente));
    }


}

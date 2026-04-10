package org.unicamp.unicamp;

import java.util.Scanner;
import java.util.Stack;

public class Jogo {

    private final Scanner input;

    private final int vida_jogador = 3;
    private final int energia_base = 5;
    private final int num_cartas_mao = 4;
    private final int dano_base_jogador = 1;
    private final Stack<String> inimigos = new Stack<>();;

    private Heroi jogador;

    public Jogo(Scanner input) 
    {
        this.input = input;
        inimigos.push("A Dragão");
        inimigos.push("A Morte");
        inimigos.push("O Burro");

    }

    public boolean rodarJogo() 
    {
        String nome_jogador = this.lerNome();
        jogador = new Heroi(nome_jogador, vida_jogador, dano_base_jogador);
        Mapa mapa = new Mapa(inimigos);

        System.err.println("Três desafiantes secretos invadem seu pântano...");
        while(!inimigos.empty()) 
        {
            String proxInimigo = this.lerInimigo();
            mapa.proxInimigo(proxInimigo);
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

    public String lerNome() 
    {
        String nome_jogador;
        System.out.println("Digite o nome de seu heroi ogro: ");
        nome_jogador = input.nextLine();
        return nome_jogador;
    }

    public String lerInimigo() 
    {
        System.out.println("Escolha seu oponente: ");
        inimigos.forEach(nome -> System.out.println("[" + inimigos.indexOf(nome) + "] - " + nome));
        int oponente = input.nextInt();
        while ( !inimigos.contains((inimigos.get(oponente))) ) 
        {
            System.out.println("Oponente inválido, tente novamente: ");
            oponente = input.nextInt();
        }
        return (inimigos.get(oponente));
    }


}

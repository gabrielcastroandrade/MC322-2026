package org.unicamp.unicamp;

import java.util.Scanner;

/**
 * Classe App é a principal classe para rodar o jogo, nela está contido o método main(), que faz todo o jogo rodar
 * 
 */
public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);

        System.out.println("Boa noite Ogro, seja bem vindo ao Shrek 2077: a volta dos que não foram!!!");

        // leitura do nome do jogador
        String in_nome; int oponente;
        System.out.println("Digite o nome de seu heroi ogro: ");
        in_nome = input.nextLine();

        // leitura da oponente
        System.out.println("Escolha seu oponente: ");
        System.out.println("[1] - A Dragão");
        System.out.println("[2] - A Morte Encarnada");
        System.out.println("[3] - #@%$&¨@*%");

        oponente = input.nextInt();
        while (oponente != 1 && oponente != 2 && oponente != 3) 
        {
            System.out.println("Oponente inválido, tente novamente: ");
            oponente = input.nextInt();
        }

        // inicialização do jogo
        Jogo jogo = new Jogo(in_nome, oponente, input);
        jogo.rodarJogo();
        System.out.println("Jogo encerrado. Obrigado por jogar!!!");
        System.out.println("Créditos: Arthur Midon (247271) e Gabriel Castro (280869)");
        input.close();
    }

}

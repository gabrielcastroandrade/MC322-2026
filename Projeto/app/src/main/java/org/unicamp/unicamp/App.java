package org.unicamp.unicamp;

import java.util.Scanner;

/**
 * Classe App é a principal classe para rodar o jogo, nela está contido o método main(), que faz todo o jogo rodar.
 */
public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);

        System.out.println("");
        System.out.println("Boa noite Ogro, seja bem vindo ao Shrek 2077: a volta dos que não foram!!!");

        Jogo jogo = new Jogo(input);
        boolean resultado = jogo.rodarJogo();
        if (resultado) 
        {
            System.out.println("Parabéns, você agora pode ficar em paz e seu pântano.");
        }
        if (!resultado) 
        {
            System.out.println("Não foi dessa vez, os invasores acabaram com você e seu pântano.");
        }

        System.out.println("");
        System.out.println("Jogo encerrado. Obrigado por jogar!!!");
        System.out.println("Créditos: Arthur Midon (247271) e Gabriel Castro (280869)");
        input.close();
    }

}

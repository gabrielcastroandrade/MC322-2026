package org.unicamp.unicamp.conteudos;

import org.unicamp.unicamp.sistema.Baralho;

/**
* Classe extensão de Escolha
* Permite que o jogador ganhe 2 novas cartas para usar
*/
public class Alongamento extends Escolha {

    @Override

    /**
     * Adiciona novas cartas ao baralho do jogador
     * @param jogador Heroi
     * @param baralho Baralho 
     */
    public Entidade iniciar(Heroi jogador, Baralho baralho) 
    {
        System.out.println("");
        System.out.println("Você parou para tomar dar uma alongadinha rápida, os inimigos podem esperar.");
        System.out.println("Você ganhou 2 novas cartas: Farmar aura + ego e Ataque faixa preta");
        baralho.upgrade();
        return jogador;
    }
}

package org.unicamp.unicamp.conteudos;

import org.unicamp.unicamp.sistema.Baralho;

/**
* Classe extensão de Escolha
* Permite que o jogador ganhe novas cartas 
*/
public class Alongamento extends Escolha {

    @Override

    /**
     * Adiciona uma nova carta ao baralho do jogador
     * @param jogador Heroi
     * @param baralho Baralho 
     */
    public Entidade iniciar(Heroi jogador, Baralho baralho) 
    {
        System.out.println("");
        System.out.println("Você parou para dar uma alongadinha rápida, os inimigos podem esperar");
        baralho.upgrade();
        return jogador;
    }
}

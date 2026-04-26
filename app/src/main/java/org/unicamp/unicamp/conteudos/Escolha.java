package org.unicamp.unicamp.conteudos;

import org.unicamp.unicamp.sistema.Baralho;

/**
 * Classe extensão de Evento, repreenta os acontecimentos que não são batalhas
 */
public abstract class Escolha extends Evento {

    @Override

    /**
     * Inicia e raliza o evento
     * @param jogador Heroi
     * @param baralho Baralho
     * @return Entidade - desconsiderar
     */
    public abstract Entidade iniciar(Heroi jogador, Baralho baralho);
}

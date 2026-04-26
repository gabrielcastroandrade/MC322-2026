package org.unicamp.unicamp.conteudos;
import org.unicamp.unicamp.sistema.Baralho;

/**
 * Classe responsável prlos diferentes eventos do jogo
 */
public abstract class Evento {

    /**
     * Inicia e raliza o evento
     * @param jogador Heroi
     * @param baralho Baralho
     * @return Entidade - nas batalhas, retorna a entidade vencedora
     */
    public abstract Entidade iniciar(Heroi jogador, Baralho baralho);
}

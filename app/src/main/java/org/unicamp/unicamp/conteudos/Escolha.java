package org.unicamp.unicamp.conteudos;

import org.unicamp.unicamp.sistema.Baralho;

public abstract class Escolha extends Evento {

    @Override

    public abstract Entidade iniciar(Heroi jogador, Baralho baralho);
}

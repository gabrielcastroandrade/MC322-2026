package org.unicamp.unicamp;

/**
 * Extensão da classe abstrata Entidade.
 * Se refere ao próprio jogador.
 */
public class Heroi extends Entidade{

    public Heroi(String nome, int vida, int dano_base) 
    {
        super(nome, vida, dano_base);
    }

}
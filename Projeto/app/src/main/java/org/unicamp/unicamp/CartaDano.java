package org.unicamp.unicamp;

public class CartaDano extends Carta{

    public CartaDano(String nome, String descricao, int custo)
    {
        super(nome, descricao, custo);
    }

    // jogo
    @Override
    public void usar(Entidade alvo, int dano)
    {
        alvo.receberDano(dano);
    }

}

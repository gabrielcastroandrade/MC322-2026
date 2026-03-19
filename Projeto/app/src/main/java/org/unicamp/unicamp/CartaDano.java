package org.unicamp.unicamp;

public class CartaDano extends Carta{

    protected int dano;

    public CartaDano(String nome, String descricao, int custo, int dano)
    {
        super(nome, descricao, custo);
        this.dano = dano;
    }

    // getters

    public int getDano() 
    {
        return dano;
    }

    // jogo
    @Override
    public void usar(Entidade alvo)
    {
        alvo.receberDano(dano);
    }

}

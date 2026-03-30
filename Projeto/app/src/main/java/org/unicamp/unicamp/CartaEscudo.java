package org.unicamp.unicamp;

public class CartaEscudo extends Carta{

    public CartaEscudo(String nome, String descricao, int custo)
    {
        super(nome, descricao, custo);
    }

    // getters

    // jogo
    @Override
    public void usar(Entidade alvo, int ganho)
    {
        alvo.ganharEscudo(ganho);
    }

}

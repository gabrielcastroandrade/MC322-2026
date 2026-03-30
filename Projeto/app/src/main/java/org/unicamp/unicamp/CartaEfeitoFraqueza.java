package org.unicamp.unicamp;

public class CartaEfeitoFraqueza extends Carta{

    protected Efeito efeito;

    public CartaEfeitoFraqueza(String nome, String descricao, int custo) 
    {
        super(nome, descricao, custo);
    }

    @Override
    public void usar(Entidade alvo, int poder) 
    {
        efeito = new EfeitoFraqueza("fraqueza", alvo);
        alvo.adicionarEfeito(efeito);
    }

    public Efeito getEfeito() 
    {
        return efeito;
    }
}

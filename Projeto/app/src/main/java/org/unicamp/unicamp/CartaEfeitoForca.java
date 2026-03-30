package org.unicamp.unicamp;

public class CartaEfeitoForca extends Carta{

    protected Efeito efeito;

    public CartaEfeitoForca(String nome, String descricao, int custo) 
    {
        super(nome, descricao, custo);
    }

    @Override
    public void usar(Entidade alvo, Entidade caster) 
    {
        efeito = new EfeitoForca("força", alvo);
        alvo.adicionarEfeito(efeito);
    }

    public Efeito getEfeito() 
    {
        return efeito;
    }
}

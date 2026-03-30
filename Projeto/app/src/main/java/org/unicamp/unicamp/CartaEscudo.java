package org.unicamp.unicamp;

public class CartaEscudo extends Carta{

    protected int ganho;

    public CartaEscudo(String nome, String descricao, int custo, int ganho)
    {
        super(nome, descricao, custo);
        this.ganho = ganho;
    }

    public void usar(Inimigo alvo, int ganhar)
    {
        alvo.ganharEscudo(ganhar);
        System.out.println("Você levantou " + ganho + " de escudo");
    }

    // getters
    public int getGanho() 
    {
        return ganho;
    }

    // jogo
    @Override
    public void usar(Entidade alvo, Entidade caster)
    {
        alvo.ganharEscudo(ganho);
    }

}

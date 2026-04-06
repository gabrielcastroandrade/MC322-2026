package org.unicamp.unicamp;

/**
 * Classe abstrata Carta é e base para todas as cartas do jogo
 */
public abstract class Carta {

    protected String nome;
    protected String descricao;
    protected int custo;

    public Carta(String nome, String descricao, int custo) 
    {
        this.nome = nome;
        this.descricao = descricao;
        this.custo = custo;
    }

    // getters
    public String getNome() 
    {
        return nome;
    }

    public String getDescricao() 
    {
        return descricao;
    }

    public int getCusto() 
    {
        return custo;
    }

    /**
     * Método usado para fazer a carta realiar sua ação principal. 
     * @param alvo Entidade - em quem será usada a carta
     * @param caster Entidade - quem está usando a carta
     * @param poder int - indica o quão forte será o efeito da carta
     */
    public abstract void usar(Entidade alvo, Entidade caster, int poder); 

}

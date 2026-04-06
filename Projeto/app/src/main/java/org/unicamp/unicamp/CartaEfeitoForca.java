package org.unicamp.unicamp;

/**
 * Extensão da classe abstrata Carta.
 * Carta capaz de dar o efeito de força a um alvo
 */
public class CartaEfeitoForca extends Carta{

    protected Efeito efeito;

    public CartaEfeitoForca(String nome, String descricao, int custo) 
    {
        super(nome, descricao, custo);
    }

    public Efeito getEfeito() 
    {
        return efeito;
    }

    @Override

    /**
     * Método para usar a carta, dando o efeito de força ao caster.
     * @param alvo Entidade - em quem será aplicado o efeito de força
     * @param caster Entidade - quemm está usando a carta
     * @param poder int - ainda não usado nessa carta na implmentação atual
     */
    public void usar(Entidade alvo, Entidade caster, int poder) 
    {
        efeito = new EfeitoForca("força", alvo);
        alvo.adicionarEfeito(efeito);
    }
}

package org.unicamp.unicamp;

/**
 * Extensão da classe abstrata Carta.
 * Carta capaz de aplciar o efeito de fraqueza a um alvo
 */
public class CartaEfeitoFraqueza extends Carta{

    protected Efeito efeito;

    public CartaEfeitoFraqueza(String nome, String descricao, int custo) 
    {
        super(nome, descricao, custo);
    }

    public Efeito getEfeito() 
    {
        return efeito;
    }

    @Override

    /**
     * Método para usar a carta, dando o efeito de fraqueza a um alvo.
     * @param alvo Entidade - em quem será aplicado o efeito de fraqueza
     * @param caster Entidade - quemm está usando a carta 
     * @param poder int - ainda não usado nessa carta na implmentação atual
     */
    public void usar(Entidade alvo, Entidade caster, int poder) 
    {
        efeito = new EfeitoFraqueza("fraqueza", alvo);
        alvo.adicionarEfeito(efeito);
    }
}

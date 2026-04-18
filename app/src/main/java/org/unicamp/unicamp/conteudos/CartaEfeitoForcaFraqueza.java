package org.unicamp.unicamp.conteudos;

/**
 * Extensão da classe abstrata Carta.
 * Carta capaz de aplicar o efeito de fraqueza a um alvo e força ao caster.
 */
public class CartaEfeitoForcaFraqueza extends Carta{

    protected Efeito efeito1;
    protected Efeito efeito2;

    public CartaEfeitoForcaFraqueza(String nome, String descricao, int custo) 
    {
        super(nome, descricao, custo);
    }

    public Efeito getEfeitoForca() 
    {
        return efeito2;
    }

    public Efeito getEfeitoFraqueza() 
    {
        return efeito1;
    }

    @Override

    /**
     * Método para usar a carta, dando o efeito de fraqueza a um alvo e força ao caster.
     * @param alvo Entidade - em quem será aplicado o efeito de fraqueza
     * @param caster Entidade - quemm está usando a carta, receberá força
     * @param poder int - ainda não usado nessa carta na implmentação atual
     */
    public void usar(Entidade alvo, Entidade caster, int poder) 
    {
        efeito1 = new EfeitoFraqueza("fraqueza", alvo);
        alvo.adicionarEfeito(efeito1);
        efeito2 = new EfeitoForca("força", caster);
        caster.adicionarEfeito(efeito2);
    }
}

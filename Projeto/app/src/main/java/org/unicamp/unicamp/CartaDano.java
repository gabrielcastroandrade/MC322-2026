package org.unicamp.unicamp;

/**
 * Extensão da classe abstrata Carta.
 * Carta capaz de inflingir dano a um alvo
 */
public class CartaDano extends Carta{

    public CartaDano(String nome, String descricao, int custo)
    {
        super(nome, descricao, custo);
    }

    @Override

    /**
     * Método para usar a carta, causando dano a um alvo
     * @param alvo Entidade - em quem será caudado o dano
     * @param dano int - qual será o dano causado
     */
    public void usar(Entidade alvo, int dano)
    {
        alvo.receberDano(dano);
    }

}

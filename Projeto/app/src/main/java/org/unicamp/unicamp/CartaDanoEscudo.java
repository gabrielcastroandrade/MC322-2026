package org.unicamp.unicamp;

/**
 * Extensão da classe abstrata Carta.
 * Carta capaz de causar dano a um alvo e levantar escudos ao caster, simultaneamente.
 */
public class CartaDanoEscudo extends Carta{

    public CartaDanoEscudo(String nome, String descricao, int custo)
    {
        super(nome, descricao, custo);
    }

    @Override

    /**
     * Método para usar a carta, levantando escudo no caster e atacando um alvo, simultaneamente.
     * @param alvo Entidade - em quem será levantado o escudo
     * @param caster Entidade - quemm está usando a carta
     * @param dano int - quanto será levantado de escudo
     */
    public void usar(Entidade alvo, Entidade caster, int poder)
    {
        caster.ganharEscudo(poder - 1);
        alvo.receberDano(poder - 2);
    }
}

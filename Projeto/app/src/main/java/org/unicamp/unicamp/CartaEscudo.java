package org.unicamp.unicamp;

/**
 * Extensão da classe abstrata Carta.
 * Carta capaz de levantar escudos em um alvo
 */
public class CartaEscudo extends Carta{

    public CartaEscudo(String nome, String descricao, int custo)
    {
        super(nome, descricao, custo);
    }

    @Override

    /**
     * Método para usar a carta, levantando escudo no alvo
     * @param alvo Entidade - em quem será levantado o escudo
     * @param caster Entidade - quemm está usando a carta
     * @param dano int - quanto será levantado de escudo
     */
    public void usar(Entidade alvo, Entidade caster, int ganho)
    {
        alvo.ganharEscudo(ganho);
    }

}

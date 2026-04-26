package org.unicamp.unicamp.conteudos;

/**
 * Extensão da classe efeito.
 * Causa em uma entidade alvo o efeito de fraqueza, que diminui o dano base da entidade
 */
public class EfeitoFraqueza extends Efeito {

    public EfeitoFraqueza(String nome, Entidade alvo) 
    {
        super(nome, alvo);
    }

    @Override

    /**
     * Implementação particular do método abstrato da classe Subscriber.
     * Faz com que o alvo tenha fraqueza quando for atacar.
     * @param mensagem String - informação do momento da rodada
     */
    public void serNotificado(String mensagem) 
    {
        if (carga != 0)
        {
            if (mensagem.equals("inimigo vai escolher sua acao") && alvo instanceof Inimigo) 
            {
                alvo.cutting(acumulo);
            }
            if (mensagem.equals("jogador começará seu turno") && alvo instanceof Heroi) 
            {
                alvo.cutting(acumulo);
            }
            if (mensagem.equals("fim da rodada")) 
            {
                alvo.bulking(acumulo);
                carga--;
            }
        }

    }

}

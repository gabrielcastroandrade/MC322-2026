package org.unicamp.unicamp;

/**
 * Extensão da classe efeito.
 * Causa em uma entidade alvo o efeito de força, que aumenta o dano base da entidade
 */
public class EfeitoForca extends Efeito{

    public EfeitoForca(String nome, Entidade alvo) 
    {
        super(nome, alvo);
    }

    @Override

    /**
     * Implementação particular do método da classe Subscriber.
     * Faz com que o alvo ganhe força quando for atacar.
     * @param mensagem String - informação do momento da rodada
     */
    public void serNotificado(String mensagem) 
    {
        if (carga != 0) 
        {
            if (mensagem.equals("fim do turno do jogador") && alvo instanceof Inimigo) 
            {
                alvo.bulking(acumulo);
            }
            if (mensagem.equals("jogador vai realizar sua ação") && alvo instanceof Heroi) 
            {
                alvo.bulking(acumulo);
            }
            if (mensagem.equals("fim da rodada")) 
            {
                alvo.cutting(acumulo);
                carga--;
            }
        }
    }

}

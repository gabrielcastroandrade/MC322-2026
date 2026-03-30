package org.unicamp.unicamp;

public class EfeitoFraqueza extends Efeito {

    public EfeitoFraqueza(String nome, Entidade alvo) 
    {
        super(nome, alvo);
    }

    @Override
    public void serNotificado(String mensagem) 
    {
        if (carga != 0)
        {
            if (mensagem.equals("fim do turno do jogador") && alvo instanceof Inimigo) 
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

package org.unicamp.unicamp;

public class EfeitoForca extends Efeito{

    public EfeitoForca(String nome, Entidade alvo) 
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

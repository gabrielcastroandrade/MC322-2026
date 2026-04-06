package org.unicamp.unicamp;

import java.util.Random;

/**
 * Extensão da classe abstrata Entidade.
 * Se refere aos inimigos.
 */
public class Inimigo extends Entidade{
    
    public Inimigo (String nome, int vida, int dano_base) 
    {
        super(nome, vida, dano_base);
    }

    // jogo

    /**
     * Causa dano em um Heroi alvo. 
     * O dano é baseado no dano base do inimigo
     * @param alvo Heroi - heroi a ser atacado
     */
    public void atacar(Heroi alvo) 
    {
        alvo.receberDano(dano_base);
    }

    /**
     * Escolhe aleatoriamente uma ação que o inimigo irá tomar.
     * @return acao_inimigo int - inteiro que representa qual ação o inimigo escolheu realizar
     */
    public int escolherAcao() 
    {
        Random aleatorio = new Random();
        int min = 1;
        int max = 7;
        int acao_inimigo = aleatorio.nextInt((max - min) + 1) + min;
        if (acao_inimigo == 1) {System.out.println(">> " + nome + " irá atacar com tudo que tem");}
        if (acao_inimigo == 2) {System.out.println(">> " + nome + " irá atacar como quem não quer nada");}
        if (acao_inimigo == 3) {System.out.println(">> " + nome + " irá defender como se sua vida estivesse em jogo");}
        if (acao_inimigo == 4) {System.out.println(">> " + nome + " irá defender com bastante preguiça");}
        if (acao_inimigo == 5) {System.out.println(">> " + nome + " farmou aura, você ficou fraco");}
        if (acao_inimigo == 6) {System.out.println(">> " + nome + " farmou ego, ele está mais forte agora");}
        if (acao_inimigo == 7) {System.out.println(">> " + nome + " farmou aura + ego, ele está mais forte agora, e você mais fraco");}
        return acao_inimigo;
    }

    /**
     * Faz o inimigo realizar sua ação se for uma defesa ou aplicação de efeito.
     * Esse método deve ser chamado assim que o inimigo escolher sua ação, antes do jogador escolher a sua ação.
     * @param acao_inimigo int - ação que o inimgo ecolheu tomar
     */
    public void agirDefesa(int acao_inimigo) 
    {
        if (acao_inimigo == 3) 
        {
            this.ganharEscudo(2);    
        }
        if (acao_inimigo == 4) 
        {
            this.ganharEscudo(1);    
        }
        if (acao_inimigo == 5) 
        {
            Efeito efeito = new EfeitoFraqueza("fraqueza", this);
            this.adicionarEfeito(efeito);
        }
        if (acao_inimigo == 6) 
        {
            Efeito efeito = new EfeitoForca("força", this);
            this.adicionarEfeito(efeito);  
        }
        if (acao_inimigo == 7) 
        {
            Efeito efeito = new EfeitoFraqueza("fraqueza", this);
            this.adicionarEfeito(efeito); 
            Efeito efeito2 = new EfeitoForca("força", this);
            this.adicionarEfeito(efeito2);   
        }
    }

    /**
     * Faz o inimigo realizar sua ação se for um ataque.
     * Esse método deve ser chamado do jogador escolher a sua ação.
     * @param acao_inimigo int - qual ação o inimigo escolheu tomar
     * @param alvo Herois - alvo do ataque
     */
    public void agirAtaque(int acao_inimigo, Heroi alvo) 
    {
        if (acao_inimigo == 1) 
        {
            this.atacar(alvo);
            this.atacar(alvo);
        }
        if (acao_inimigo == 2) 
        {
            this.atacar(alvo);
        } 
    }
}

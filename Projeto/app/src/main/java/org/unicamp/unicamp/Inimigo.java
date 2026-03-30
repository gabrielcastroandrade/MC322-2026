package org.unicamp.unicamp;

public class Inimigo extends Entidade{
    
    public Inimigo (String nome, int vida, int dano_base) 
    {
        super(nome, vida, dano_base);
    }

    // jogo

    public void atacar(Heroi alvo) 
    {
        alvo.receberDano(dano_base);
    }
}

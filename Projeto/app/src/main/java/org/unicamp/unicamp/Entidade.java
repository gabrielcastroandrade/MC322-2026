package org.unicamp.unicamp;

public abstract class Entidade {

    protected  String nome;
    protected  int vida;
    protected  int escudo = 0;

    public Entidade(String nome, int vida) 
    {
        this.nome = nome;
        this.vida = vida;
    }

    // getters
    public String getNome() 
    {
        return nome;
    }

    public int getVida() 
    {
        return vida;
    }

    public int getEscudo() 
    {
        return escudo;
    }

    // jogo
    public void receberDano(int dano) 
    {
        if (escudo > dano) 
        {
            escudo -= dano;
        }
        if (escudo > 0 && escudo < dano) 
        {
            vida -= (dano - escudo);
        }
        if (escudo == 0) 
        {
            vida -= dano;
        }
    } 

    public void ganharEscudo(int ganho)
    {
        escudo += ganho;
    }

    public boolean estarVivo()
    {
        return (vida > 0); 
    }

    public void zerarEscudo() 
    {
        escudo = 0;
    }

}

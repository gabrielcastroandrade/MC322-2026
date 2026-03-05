public class Inimigo {
    
    private String nome;
    private int vida;
    private int escudo = 0;
    
    public Inimigo (String nome, int vida) 
    {
        this.nome = nome;
        this.vida = vida;
    }

    public void receberDano(int dano) 
    {
        if (escudo > 0) 
        {
            escudo -= dano;
        }
        else 
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

    public void atacar(Heroi alvo, int dano) 
    {
        alvo.receberDano(dano);
    }

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

    public void zerarEscudo() 
    {
        escudo = 0;
    }
}

public class Inimigo {
    
    private String nome;
    private int vida;
    private int escudo;
    
    public Inimigo (String nome, int vida, int escudo) 
    {
        this.nome = nome;
        this.vida = vida;
        this.escudo = escudo;
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
}

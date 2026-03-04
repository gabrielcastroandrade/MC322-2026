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
        vida -= dano;
    } 

    public boolean estarVivo()
    {
        return (vida != 0); 
    }

    public void atacar(Heroi alvo, int dano) 
    {
        alvo.receberDano(dano);
    }

}

public class Inimigo extends Entidade{
    
    protected int dano;

    public Inimigo (String nome, int vida, int dano) 
    {
        super(nome, vida);
        this.dano = dano;
    }

    // jogo

    public void atacar(Heroi alvo) 
    {
        alvo.receberDano(dano);
    }
}

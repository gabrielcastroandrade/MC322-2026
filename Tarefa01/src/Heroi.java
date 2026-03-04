public class Heroi {

    private String nome;
    private int vida;
    private int escudo;

    public Heroi(String nome, int vida, int escudo) 
    {
        this.nome = nome;
        this.vida = vida;
        this.escudo = escudo;
    }

    public void receberDano(int dano) 
    {
        vida -= dano;
    } 

    public void ganharEscudo(int ganho)
    {
        escudo += ganho;
    }

    public boolean estarVivo()
    {
        return (vida != 0); 
    }
}
public class Heroi {

    private String nome;
    private int vida;
    private int escudo = 0;

    public Heroi(String nome, int vida) 
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

    public void zerarEscudo() 
    {
        escudo = 0;
    }
}
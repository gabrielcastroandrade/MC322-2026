public class Rodada {

    private Heroi jogador;
    private Inimigo inimigo;
    private int energia;

    public Rodada(Heroi jogador, Inimigo inimigo, int energia) 
    {
        this.jogador = jogador;
        this.inimigo = inimigo;
        this.energia = energia;
    }

    public void rodar() 
    {
        System.out.println("-//-");
        System.out.println(
            jogador.getNome() 
            + " (vida: " + jogador.getVida() 
            + " / escudo: " + jogador.getEscudo() + ")"
        );
        System.out.println("vs");
        System.out.println(
            inimigo.getNome() 
            + " (vida: " + inimigo.getVida() 
            + " / escudo: " + inimigo.getEscudo() + ")"
        );
        System.out.println();
        System.out.println("(energia: " + energia + ")");
        // continuar

    }

}

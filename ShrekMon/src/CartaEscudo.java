public class CartaEscudo {

    private String nome;
    private int custo;

    public CartaEscudo(String nome, int custo)
    {
        this.nome = nome;
        this.custo = custo;
    }

    public void usar(Heroi alvo, int ganhar)
    {
        alvo.ganharEscudo(ganhar);
    }

}

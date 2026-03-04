public class CartaDano {

    private String nome;
    private int custo;

    public CartaDano(String nome, int custo)
    {
        this.nome = nome;
        this.custo = custo;
    }

    public void usar(Inimigo alvo, int dano)
    {
        alvo.receberDano(dano);
    }

}

public class Jogo {

    private Heroi jogador;
    private Inimigo inimigo;
    private String nome_jogador;
    private String nome_inimigo;
    private int rodada = 0;
    private int dificuldade = 1;

    private int vida_jogador = 0;
    private int escudo_i = 0;
    private int energia_i = 0;
    private int dano_jogador = 0;

    private int vida_inimigo = 0;
    private int dano_inimigo = 0;

    public Jogo (String nome_jogador, int dificuldade) 
    {
        this.nome_jogador = nome_jogador;
        this.dificuldade = dificuldade;

        if (dificuldade == 1) 
        {
        vida_jogador = 3;
        escudo_i = 2;
        energia_i = 3;
        dano_jogador = 1;

        vida_inimigo = 4;
        dano_inimigo = 1;
        nome_inimigo = "A Dragoa";
        }

        if (dificuldade == 2) 
        {
            vida_jogador = 2;
            escudo_i = 2;
            energia_i = 2;
            dano_jogador = 2;

            vida_inimigo = 5;
            dano_inimigo = 1;
            nome_inimigo = "A Morte";
        }

        if (dificuldade == 999) 
        {
            vida_jogador = 1;
            escudo_i = 1;
            energia_i = 1;
            dano_jogador = 1;

            vida_inimigo = 10000;
            dano_inimigo = 1;
            nome_inimigo = "O BURRO !!!";
        }

        jogador = new Heroi(nome_jogador, vida_jogador, escudo_i);
        inimigo = new Inimigo(nome_inimigo, vida_inimigo, escudo_i);

    }

}

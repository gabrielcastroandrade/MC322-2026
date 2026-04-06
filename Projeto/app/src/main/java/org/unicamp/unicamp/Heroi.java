package org.unicamp.unicamp;

/**
 * Extensão da classe abstrata Entidade.
 * Se refere ao próprio jogador.
 */
public class Heroi extends Entidade{

    public Heroi(String nome, int vida, int dano_base) 
    {
        super(nome, vida, dano_base);
    }

    /**
     * Método responsável por fazer o jogador realizar sua ação.
     * @param indice_carta_escolhida int
     * @param carta_escolhida Carta
     * @param inimigo Inimigo
     * @param baralho Baralho
     * @param jogo Jogo
     * @return int - curto da ação realizada
     */
    public int agir(int indice_carta_escolhida, Carta carta_escolhida, Inimigo inimigo, Baralho baralho, Jogo jogo) 
    {
        if (carta_escolhida instanceof CartaDano c) 
        {
            c.usar(inimigo, c.getCusto()*this.getDano());
            System.out.println("-//-");
            System.out.println("Você atacou seu oponente com " + c.getCusto()*this.getDano() + " de dano");
            System.out.println("-//-");
            System.out.println();
            baralho.descartar(indice_carta_escolhida);
            return c.getCusto();
        }
        if (carta_escolhida instanceof CartaEscudo c) 
        {
            c.usar(this, c.getCusto());
            System.out.println("-//-");
            System.out.println("Você levantou " + c.getCusto() + " de escudo");
            System.out.println("-//-");
            System.out.println();
            baralho.descartar(indice_carta_escolhida);
            return c.getCusto();
        }
        if (carta_escolhida instanceof CartaEfeitoFraqueza c)
        {
            c.usar(inimigo, 0);
            Efeito efeito = c.getEfeito();
            jogo.inscrever(efeito);
            System.out.println("-//-");
            System.out.println("Você jogou no seu oponente o efeito de " + efeito.getString());
            System.out.println("-//-");
            System.out.println();
            baralho.descartar(indice_carta_escolhida);
            return c.getCusto();
        }
        if (carta_escolhida instanceof CartaEfeitoForca c)
        {
            c.usar(this, 0);
            Efeito efeito = c.getEfeito();
            jogo.inscrever(efeito);
            System.out.println("-//-");
            System.out.println("Você jogou em si mesmo o efeito de " + efeito.getString());
            System.out.println("-//-");
            System.out.println();
            baralho.descartar(indice_carta_escolhida);
            return c.getCusto();
        }
        return 0;
    }
}
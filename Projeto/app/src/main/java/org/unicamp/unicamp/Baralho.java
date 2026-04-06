package org.unicamp.unicamp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Classe responsável por guardar e gerenciar todos os baralhos do jogo (pilhas de compra, descarte e mão do jogador)
 */
public class Baralho {

    private final List<Carta> mao; 
    private final Stack<Carta> compra;
    private final Stack<Carta> descarte;

    public Baralho(Entidade jogador) 
    {
        this.mao  = new ArrayList<>();
        this.compra = new Stack<>();
        this.descarte = new Stack<>();

        compra.push(new CartaDano("ataque fofo", "causa dano base", 1));
        compra.push(new CartaDano("ataque sagaz", "causa 2 vezes o dano", 2));
        compra.push(new CartaDano("ataque violento", "causa 3 vezes o dano", 3));
        compra.push(new CartaEscudo("defesa desajeitada", "levanta 1 de escudo", 1));
        compra.push(new CartaEscudo("defesa eficiente", "levanta 2 de escudo", 2));
        compra.push(new CartaEscudo("defesa impenetrável", "levanta 3 de escudo", 3));
        compra.push(new CartaEfeitoFraqueza("farmar aura", "enfraquece os ataques do seu inimigo", 2));
        compra.push(new CartaEfeitoForca("farmar ego", "torna seus ataques mais fortes", 2));
        Collections.shuffle(compra);
    }

    /**
     * Retorna a carta de um índice específico da mão do jogador
     * @param indice int - indice da carta que se quer obter
     * @return Carta
     */
    public Carta getMaoIndice(int indice) 
    {
        return mao.get(indice);
    }

    public int getLenCompra() 
    {
        return compra.size();
    }

    public int getLenMao() 
    {
        return mao.size();
    }

    public int getLenDescarte() 
    {
        return descarte.size();
    }

    // jogo
    public void embaralhar() 
    {
        Collections.shuffle(descarte);
    }

    public void comprar() 
    {
        Carta carta;
        carta = compra.removeFirst();
        mao.addFirst(carta);
    }

    /**
     * Envia uma carta da mão do jogador para o baralho de descarte.
     * @param indice int - indice que a carta a ser descartada está na mão do jogador
     */
    public void descartar(int indice) 
    {
        Carta carta = mao.remove(indice);
        descarte.push(carta);
    }

    /**
     * Devolve todas as cartas da mão do jogador e do descarte para a pilha de compra, embaralhando
     */
    public void reiniciar() 
    {
        while (!mao.isEmpty()) 
        {
            Carta carta = mao.removeFirst();
            descarte.addLast(carta);
        }
        Collections.shuffle(descarte);
        while (!descarte.empty()) 
        {
            Carta carta = descarte.removeFirst();
            compra.addLast(carta);
        }
        Collections.shuffle(compra);
    }
}

package org.unicamp.unicamp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Dados {

    private List<Carta> mao; 
    private Stack<Carta> compra;
    private Stack<Carta> descarte;

    public Dados() 
    {
        this.mao  = new ArrayList<>();
        this.compra = new Stack<>();
        this.descarte = new Stack<>();

        compra.push(new CartaDano("ataque fofo", "causa 1 de dano", 1, 1));
        compra.push(new CartaDano("ataque sagaz", "causa 2 de dano", 2, 2));
        compra.push(new CartaDano("ataque violento", "causa 3 de dano", 3, 3));
        compra.push(new CartaEscudo("defesa desajeitada", "levanta 1 de escudo", 1, 1));
        compra.push(new CartaEscudo("defesa eficiente", "levanta 2 de escudo", 2, 2));
        compra.push(new CartaEscudo("defesa impenetrável", "levanta 3 de escudo", 3, 3));
        Collections.shuffle(compra);
    }

    // getters
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

    public void descartar(int indice) 
    {
        Carta carta = mao.remove(indice);
        descarte.push(carta);
    }

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

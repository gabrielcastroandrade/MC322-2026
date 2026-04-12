package org.unicamp.unicamp.conteudos;

import java.util.ArrayList;

/**
 * Classe abstrata Entidade é a base para todos os personagens do jogo.
 */
public abstract class Entidade {

    protected String nome;
    protected int vida;
    protected int escudo;
    protected ArrayList<Efeito> efeitos;
    protected int dano_base = 1;

    public Entidade(String nome, int vida, int dano_base) 
    {
        this.nome = nome;
        this.vida = vida;
        this.dano_base = dano_base;
        this.efeitos = new ArrayList<>();
        this.escudo = 0;
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

    public int getDano () 
    {
        return dano_base;
    }

    /**
     * Faz a entidade receber dano
     * @param dano int - dano a ser recebido
     */
    public void receberDano(int dano) 
    {
        if (dano <= 0) {return;}
        if (escudo < dano) {vida -= (dano - escudo);}
        else if (escudo > dano) {escudo -= dano;}
    } 

    /**
     * Adiciona um efeito à entidade.
     * @param adicionar Efeito - efeito a ser adicionado à entidade
     */
    public void adicionarEfeito(Efeito adicionar) 
    {
        for (int i = 0; i < efeitos.size(); i++) {if (efeitos.get(i).getNome().equals(adicionar.getNome())) {efeitos.get(i).acumular(); return;}}
        efeitos.add(adicionar);
    }

    /**
     * Levanta escudo na entidade.
     * @param ganho int - quantidade de escunho que será levantado na entidade
     */
    public void ganharEscudo(int ganho)
    {
        escudo += ganho;
    }

    /**
     * Aumenta o dano base da entidade.
     * @param acumulo int - acrescimo de dano
     */
    public void bulking(int acumulo) 
    {
        dano_base += acumulo;
    }

    /**
     * Diminui o dano base da entidade.
     * @param acumulo int - decrescimo de dano
     */
    public void cutting(int acumulo) 
    {
        dano_base -= acumulo;
        if (dano_base < 0) {dano_base = 0;}
    }

    /**
     * Printa todos os efeitos que a entidade possui
     */
    public void printEfeitos() 
    {
        efeitos.forEach(efeito -> System.out.println(efeito.getString()));
    }

    /**
     * Verifica se a entidade está viva.
     * @return boolean - sim se vida, não se morta
     */
    public boolean estarVivo()
    {
        return (vida > 0); 
    }

    public void zerarEscudo() 
    {
        escudo = 0;
    }

    /**
     * Limpa os efeitos da entidade que estiverem com carga zerada.
     */
    public void limpezaEfeitos() 
    {
        efeitos.removeIf(efeito -> efeito.getCarga() == 0);
    }

}

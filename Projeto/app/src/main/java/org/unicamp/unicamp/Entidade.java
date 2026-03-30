package org.unicamp.unicamp;

import java.util.ArrayList;

public abstract class Entidade {

    protected String nome;
    protected int vida;
    protected int escudo = 0;
    protected ArrayList<Efeito> efeitos;
    protected int dano_base = 1;

    public Entidade(String nome, int vida, int dano_base) 
    {
        this.nome = nome;
        this.vida = vida;
        this.dano_base = dano_base;
        this.efeitos = new ArrayList<>();
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

    // jogo
    public void receberDano(int dano) 
    {
        if (dano <= 0) {return;}
        if (escudo < dano) {vida -= (dano - escudo);}
        else if (escudo > dano) {escudo -= dano;}
    } 

    public void adicionarEfeito(Efeito adicionar) 
    {
        for (int i = 0; i < efeitos.size(); i++) {if (efeitos.get(i).getNome().equals(adicionar.getNome())) {efeitos.get(i).acumular(); return;}}
        efeitos.add(adicionar);
    }

    public void ganharEscudo(int ganho)
    {
        escudo += ganho;
    }

    public void bulking(int acumulo) 
    {
        dano_base += acumulo;
    }

    public void cutting(int acumulo) 
    {
        dano_base -= acumulo;
    }

    public void printEfeitos() 
    {
        efeitos.forEach(efeito -> System.out.println(efeito.getString()));
    }

    public boolean estarVivo()
    {
        return (vida > 0); 
    }

    public void zerarEscudo() 
    {
        escudo = 0;
    }

    public void limpeza() 
    {
        for(int i = 0; i < efeitos.size(); i++) {if (efeitos.get(i).getCarga() == 0) {efeitos.remove(i);}}
    }

}

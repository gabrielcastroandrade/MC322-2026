package org.unicamp.unicamp.conteudos;

import org.unicamp.unicamp.sistema.Subscriber;

/**
 * Classe abstrata etensão de subscriber, representa os efeitos que entidades podem possuir.
 */
public abstract class Efeito extends Subscriber {

    protected String nome;
    protected Entidade alvo; 
    protected int acumulo;
    protected int carga;

    public Efeito(String nome ,Entidade alvo) 
    {
        this.nome = nome;
        this.alvo = alvo;
        acumulo = 1;
        carga = 3;
    }

    /**
     * Aumenta o acúmulo (poder) do efeito e ainda adiciona mais duas cargas (efeito dura mais)
     */
    public void acumular() 
    {
        acumulo++;
        carga += 2;
    }

    public String getString() 
    {
        return (nome + " " + acumulo);
    }

    public int getCarga() 
    {
        return carga;
    }

    public String getNome() 
    {
        return nome;
    }

}

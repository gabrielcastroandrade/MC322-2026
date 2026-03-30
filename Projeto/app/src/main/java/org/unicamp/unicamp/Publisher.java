package org.unicamp.unicamp;

import java.util.ArrayList;

public abstract class Publisher {

    protected ArrayList<Subscriber> inscritos;

    public Publisher() 
    {
        this.inscritos = new ArrayList<>();
    };

    public void inscrever(Subscriber inscrito) 
    {
        inscritos.add(inscrito);
    }

    public void desinscrever(Subscriber inscrito) 
    {
        inscritos.remove(inscrito);
    }

    public void notificar(String mensagem) 
    {
        if (inscritos.isEmpty()) {return;}
        inscritos.forEach(inscrito -> inscrito.serNotificado(mensagem));
    }


}

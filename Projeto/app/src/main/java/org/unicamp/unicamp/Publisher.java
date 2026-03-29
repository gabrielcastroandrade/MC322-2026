package org.unicamp.unicamp;

import java.util.List;

public abstract class Publisher {

    protected List<Subscriber> inscritos;

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
        inscritos.forEach(inscrito -> inscrito.serNotificado(mensagem));
    }


}

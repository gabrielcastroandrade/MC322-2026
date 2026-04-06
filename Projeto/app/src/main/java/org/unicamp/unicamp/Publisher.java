package org.unicamp.unicamp;

import java.util.ArrayList;

/**
 * Classe abstrata Publisher.
 * Classe capaz de inscrever cartas da classe Subscriber à si mesma, sendo capaz de mandar 
 * strings para suas inscritas pelo método notificar().
 */
public abstract class Publisher {

    protected ArrayList<Subscriber> inscritos;

    public Publisher() 
    {
        this.inscritos = new ArrayList<>();
    };

    /**
     * Método para inscrver Subscribers ao Publisher
     * @param inscrito Subscriber - quem será inscrito a esse Publisher
     */
    public void inscrever(Subscriber inscrito) 
    {
        inscritos.add(inscrito);
    }

    /**
     * Método para desinscrver Subscribers ao Publisher
     * @param inscrito Subscriber - quem será desinscrito a esse Publisher
     */
    public void desinscrever(Subscriber inscrito) 
    {
        inscritos.remove(inscrito);
    }

    /**
     * Método para notificar os Subscribers desse Publisher
     * @param mensagem String - mensagem a ser enviada para todos os Subscribers
     */
    public void notificar(String mensagem) 
    {
        if (inscritos.isEmpty()) {return;}
        inscritos.forEach(inscrito -> inscrito.serNotificado(mensagem));
    }


}

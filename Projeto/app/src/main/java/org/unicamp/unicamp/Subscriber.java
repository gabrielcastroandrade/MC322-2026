package org.unicamp.unicamp;

/**
 * Classe abstrata Subscriber.
 * Objetos dessa classe podem ser inscritos à Publishers, recebendo strings como notiicação desses Publishers.
 */
public abstract class Subscriber {

    /**
     * Método abstrato qeue vai lidar com a menssagem recebida do Publisher.
     * @param mensagem String - notificação recebida do Publisher
     */
    public abstract void serNotificado(String mensagem);

}

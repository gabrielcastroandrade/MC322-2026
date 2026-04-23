package org.unicamp.unicamp.conteudos;
import org.unicamp.unicamp.sistema.Baralho;

/**
* Classe extensão de Escolha
* Permite que o jogador recupera toda a vida +1
*/
public class BanhoDeLama extends Escolha {

    @Override

    /**
     * Recupera toda a vida do jogador +1
     * Se baseia no valor iniciar de vida com que o jogador foi criado
     * @param jogador Heroi
     * @param baralho Baralho - passar null
     */
    public Entidade iniciar(Heroi jogador, Baralho baralho) 
    {
        System.out.println("");
        System.out.println("Você parou para tomar um banhozinho rápido de lama, os inimigos podem esperar.");
        System.out.println("Você recuperou toda sua vida e ainda ganhou +1 ponto de bônus");
        jogador.recuperarVida();
        return jogador;
    }
}

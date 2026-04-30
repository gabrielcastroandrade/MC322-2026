package org.unicamp.unicamp.sistema;
import java.util.Stack;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Classe responsável por gerar um mapa de possibilidades de escolhas do jogador
 */
public class Mapa {

    private final DefaultMutableTreeNode raiz = new DefaultMutableTreeNode();
    private final Stack<String> escolhas;
    private DefaultMutableTreeNode no_atual;

    public Mapa(Stack<String> escolhas) 
    {
        this.escolhas = escolhas;
        no_atual = raiz;
    }

    /**
     * Recebe o nome da proxima escolha e processa essa informação, contruindo assim o mapa
     * @param proxEscolha String - nome da próxima escolha
     */
    public void proxEscolha(String proxEscolha) 
    {
        DefaultMutableTreeNode prox_no = null;
        for (int i = 0; i < escolhas.size(); i++) 
        {
            if (!escolhas.get(i).equals(proxEscolha)) 
            {
                DefaultMutableTreeNode no = new DefaultMutableTreeNode(escolhas.get(i));
                no_atual.add(no);
            }
            if (escolhas.get(i).equals(proxEscolha)) 
            {
                prox_no = new DefaultMutableTreeNode(escolhas.get(i));
                no_atual.add(prox_no);
            }
        }
        no_atual = prox_no;
        escolhas.remove(proxEscolha);
    }

    /**
     * Printa as escolhas que jogador ja realizou, na ordem em que foram enfrentados
     */
    public void printCaminho() 
    {
        Stack<String> caminho = new Stack<>();
        DefaultMutableTreeNode no_percorrer;
        no_percorrer = no_atual;
        while (no_percorrer != null && !no_percorrer.isRoot()) 
        {
            caminho.addFirst((String) no_percorrer.getUserObject());
            no_percorrer = (DefaultMutableTreeNode) no_percorrer.getParent();
        }
        System.out.print("Seu mapa de escolhas é: ");
        int num_inimigos = caminho.size();
        for (int i = 0; i < num_inimigos -1; i++) 
        {
            if (num_inimigos != 1) {System.out.print(caminho.get(i) + " -> ");}
        }
        System.out.print(caminho.get(num_inimigos - 1));
    }
}

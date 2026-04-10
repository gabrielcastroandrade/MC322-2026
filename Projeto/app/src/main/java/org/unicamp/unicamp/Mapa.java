package org.unicamp.unicamp;
import java.util.Stack;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Classe responsável por gerar um mapa de possibilidades de escolhas de combate do jogador
 */
public class Mapa {

    DefaultMutableTreeNode raiz = new DefaultMutableTreeNode();
    Stack<String> inimigos;
    DefaultMutableTreeNode no_atual;

    public Mapa(Stack<String> inimigos) 
    {
        this.inimigos = inimigos;
        no_atual = raiz;
    }

    /**
     * Recebe o nome do próximo inimigo a ser enfrentado e processa essa informação, contruindo assim o mapa
     * @param proxInimigo String - nome do próximo inimigo que o jogador escolheu ennfrantar
     */
    public void proxInimigo(String proxInimigo) 
    {
        DefaultMutableTreeNode prox_no = null;
        for (int i = 0; i < inimigos.size(); i++) 
        {
            if (!inimigos.get(i).equals(proxInimigo)) 
            {
                DefaultMutableTreeNode no = new DefaultMutableTreeNode(inimigos.get(i));
                no_atual.add(no);
            }
            if (inimigos.get(i).equals(proxInimigo)) 
            {
                prox_no = new DefaultMutableTreeNode(inimigos.get(i));
                no_atual.add(prox_no);
            }
        }
        no_atual = prox_no;
        inimigos.remove(proxInimigo);
    }

    /**
     * Printa os combates que o jogador ja realizou, na ordem em que foram enfrentados
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
        System.out.print("Seu mapa de combates é: ");
        int num_inimigos = caminho.size();
        for (int i = 0; i < num_inimigos -1; i++) 
        {
            if (num_inimigos != 1) {System.out.print(caminho.get(i) + " -> ");}
        }
        System.out.print(caminho.get(num_inimigos - 1));
        System.out.println("");
    }
}

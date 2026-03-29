package org.unicamp.unicamp;

import java.util.Random;
import java.util.Scanner;

public class Jogo {

    private Heroi jogador;
    private Inimigo inimigo;

    private String nome_jogador;
    private String nome_inimigo;

    private int oponente = 1;
    private int vida_jogador = 3;
    private int dano_inimigo = 1;
    private int vida_inimigo = 0;
    private Scanner input;
    private int energia = 5;
    private int energia_backup = energia;
    private int num_cartas_mao = 3;


    public Jogo (String nome_jogador, int oponente, Scanner input) 
    {
        this.nome_jogador = nome_jogador;
        this.oponente = oponente;
        this.input = input;

        if (oponente == 1) 
        {
            vida_inimigo = 4;
            dano_inimigo = 1;
            nome_inimigo = "A Dragão";
        }

        if (oponente == 2) 
        {
            vida_inimigo = 6;
            dano_inimigo = 2;
            nome_inimigo = "A Morte Encarnada";
        }

        if (oponente == 3) 
        {
            vida_inimigo = 10000;
            dano_inimigo = 3;
            nome_inimigo = "O BURRO";
        }

        jogador = new Heroi(nome_jogador, vida_jogador);
        inimigo = new Inimigo(nome_inimigo, vida_inimigo, dano_inimigo);
    }


    public void rodarRound() 
    {
        // inicializa os dados dos baralhos
        Dados d = new Dados();
        
        // escolha da ação do inimigo
        Random aleatorio = new Random();
        int min = 1;
        int max = 4;
        int acao_inimigo = aleatorio.nextInt((max - min) + 1) + min;
        if (acao_inimigo == 1) {System.out.println(">> " + inimigo.getNome() + " irá atacar com tudo que tem");}
        if (acao_inimigo == 2) {System.out.println(">> " + inimigo.getNome() + " irá atacar como quem não quer nada");}
        if (acao_inimigo == 3) {System.out.println(">> " + inimigo.getNome() + " irá defender como se sua vida estivesse em jogo");}
        if (acao_inimigo == 4) {System.out.println(">> " + inimigo.getNome() + " irá defender com bastante preguiça");}
        // se o inimigo for defender, já defende agora
        if (acao_inimigo == 3) 
        {
            inimigo.ganharEscudo(2);    
        }
        if (acao_inimigo == 4) 
        {
            inimigo.ganharEscudo(1);    
        }
        System.out.println();
        
        // turno do jogador
        while (d.getLenMao() < num_cartas_mao && d.getLenCompra() > 0) {d.comprar();}
        while (energia > 0) 
        {
            if (!inimigo.estarVivo()) {break;}

            // dados do duelo
            System.out.println("-//-");
            System.out.println(
                jogador.getNome() 
                + " (vida: " + jogador.getVida() 
                + " / escudo: " + jogador.getEscudo() + ")"
            );
            System.out.println("vs");
            System.out.println(
                inimigo.getNome() 
                + " (vida: " + inimigo.getVida() 
                + " / escudo: " + inimigo.getEscudo() + ")"
            );
            System.out.println("-//-");
            System.out.println();

            // opções de ação do jogador
            System.out.println("(pilha de compra: " + d.getLenCompra() + " cartas)");
            System.out.println("(pilha de descarte: " + d.getLenDescarte() + " cartas)");
            System.out.println("(energia: " + energia + ")");
            System.out.println("["+0+"]" + " - Encerrar turno");
            for (int i = 0; i < d.getLenMao(); i++) 
            {
                Carta carta = d.getMaoIndice(i);
                System.out.println("["+(i+1)+"]" + " - " + carta.nome + " - " + carta.descricao + " - (custo " + carta.custo + ")");
            }
            System.out.println("Digite o número da sua próxima ação: ");
            int escolha;
            escolha = input.nextInt();
            while (escolha < 0 || escolha > d.getLenMao()) 
            {
                System.out.println("Opção indisponível, tente novamente: ");
                escolha = input.nextInt();
            }
            escolha -= 1;
            if (escolha == -1) {break;}
            Carta carta_escolhida = d.getMaoIndice(escolha);
            while (carta_escolhida.getCusto() > energia) 
            {
                System.out.println("Energia insulficiente, tente novamente: ");
                escolha = input.nextInt();
                carta_escolhida = d.getMaoIndice(escolha);
            }

            // lidando com a escolha
            if (carta_escolhida instanceof CartaDano) 
            {
                carta_escolhida.usar(inimigo);
                System.out.println("-//-");
                System.out.println("Você atacou com " + ((CartaDano) carta_escolhida).getDano() + " de dano");
                System.out.println("-//-");
                System.out.println();
                energia -= carta_escolhida.getCusto();
                d.descartar(escolha);
            }
            if (carta_escolhida instanceof CartaEscudo) 
            {
                carta_escolhida.usar(jogador);
                System.out.println("-//-");
                System.out.println("Você levantou " + ((CartaEscudo) carta_escolhida).getGanho() + " de escudo");
                System.out.println("-//-");
                System.out.println();
                energia -= carta_escolhida.getCusto();
                d.descartar(escolha);
            }
            if (d.getLenCompra() == 0) {d.reiniciar();}
        }    

        // fim do turno do jogador
        System.out.println("-//-");        
        if (!inimigo.estarVivo()) {return;}
        if (!jogador.estarVivo()) {return;}
        
        // se o inimigo for atacar, ataca aqui
        if (acao_inimigo == 1) 
        {
            inimigo.atacar(jogador);
            inimigo.atacar(jogador);
        }
        if (acao_inimigo == 2) 
        {
            inimigo.atacar(jogador);
        } 
        
        System.out.println();

        jogador.zerarEscudo();
        inimigo.zerarEscudo();
    };

        
    public void rodarJogo() 
    {
        while (jogador.estarVivo() && inimigo.estarVivo()) 
        {
            this.rodarRound();
            System.out.println("Pressione Enter para continuar: ");
            input.nextLine(); 
        }

        if (jogador.estarVivo()) 
        {
            System.out.println("Parabéns, você derrotou o inimigo");
        }

        if (inimigo.estarVivo()) 
        {
            System.out.println("Derrota, o inimigo acabou com você");
        }
    };
}



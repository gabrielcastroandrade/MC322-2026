import java.util.Random;
import java.util.Scanner;

public class Rodada {

    private Heroi jogador;
    private Inimigo inimigo;
    private int energia;
    private int energia_backup;
    private int dano_base;
    private int num_cartas_mao = 3;

    public Rodada(Heroi jogador, Inimigo inimigo, int energia) 
    {
        this.jogador = jogador;
        this.inimigo = inimigo;
        this.energia = energia;
        this.energia_backup = energia;
    }
    
    public void rodar() 
    {   
        Dados d = new Dados();

        while (energia > 0) 
        {
            if (!inimigo.estarVivo()) {break;}
            while (d.getLenMao() < num_cartas_mao && d.getLenCompra() > 0) {d.comprar();}

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
            for (int i = 0; i < d.getLenMao(); i++) 
            {
                Carta carta = d.getMaoIndice(i);
                System.out.println(i + " - " + carta.nome + " - " + carta.descricao + " - (custo " + carta.custo + ")");
            }
            System.out.println((d.getLenMao()) + " - Encerrar turno");
            System.out.println("Digite o número da sua próxima ação: ");
            int escolha;
            Scanner input = new Scanner(System.in);
            escolha = input.nextInt();
            while (escolha < 0 || escolha > d.getLenMao()) 
            {
                System.out.println("Opção indisponível, tente novamente: ");
                escolha = input.nextInt();
            }
            if (escolha == d.getLenMao()) {break;}
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

        System.out.println("-//-");        
        if (inimigo.estarVivo()) {System.out.println("Seu turno acabou, o inimigo irá revidar");}
        System.out.println();
        Random aleatorio = new Random();
        while (energia_backup > 0) 
        { 
            if (!inimigo.estarVivo()) {break;}
            if (!jogador.estarVivo()) {break;}
            int min = 1;
            int max = 2;
            int reviravolta = aleatorio.nextInt((max - min) + 1) + min;
            if (reviravolta == 1) 
            {
                CartaDano ataque = new CartaDano("dano", "causa 1 de dano", 1, 1);
                ataque.usar(jogador);
                energia_backup -= ataque.getCusto();
                System.out.println("Seu inimigo te atacou, você recebeu " + ataque.getDano() + " de dano");
            }
            if (reviravolta == 2) 
            {
                if (energia_backup < 2) {energia_backup = 0;}
                CartaEscudo defesa = new CartaEscudo("defesa", "recebe 2 de escudo", 2,2 );
                defesa.usar(inimigo);
                energia_backup -= defesa.getCusto();
                System.out.println("Seu inimigo se defendeu, ele ganhou " + defesa.getGanho() + " de escudo");
                
            }
        }
        System.out.println();
        System.out.println("Turno finalizado.");
        System.out.println("-//-");
        System.out.println();

        jogador.zerarEscudo();
        inimigo.zerarEscudo();
    }

}

import java.util.Random;
import java.util.Scanner;

public class Rodada {

    private Heroi jogador;
    private Inimigo inimigo;
    private int energia;
    private int energia_backup;
    private int dano_base;

    public Rodada(Heroi jogador, Inimigo inimigo, int energia) 
    {
        this.jogador = jogador;
        this.inimigo = inimigo;
        this.energia = energia;
        this.energia_backup = energia;
    }
    
    public void rodar() 
    {   
        while (energia > 0) 
        {
            // dados do duelo
            if (!inimigo.estarVivo()) {break;}
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

            // opções de ação jogador
            System.out.println("(energia: " + energia + ")");
            System.out.println("1 - Usar Carta de Dano (custo 1)");
            System.out.println("2 - Usar Carta de Escudo (custo 2)");
            System.out.println("3 - Encerrar turno");
            System.out.println("Digite o número da sua próxima ação: ");
            int escolha;
            Scanner input = new Scanner(System.in);
            escolha = input.nextInt();
            while (escolha != 1 && escolha != 2 && escolha != 3) 
            {
                System.out.println("Opção indisponível, tente novamente: ");
                escolha = input.nextInt();
            }
            if (escolha == 1) 
            {
                CartaDano ataque = new CartaDano("dano", "causa 1 de dano", 1, 1);
                ataque.usar(inimigo);
                energia -= ataque.getCusto();
            }
            if (escolha == 2) 
            {
                if (energia < 2) 
                {
                    System.out.println("Você não possui energia o sulficiente. Sua rodada foi perdida");
                    energia = 0;
                }
                CartaEscudo defesa = new CartaEscudo("escudo", "recebe 2 de escudo", 2, 2);
                defesa.usar(jogador);
                energia -= defesa.getCusto();
            }
            if (escolha == 3) 
            {
                energia = 0;
            }
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

        jogador.zerarEscudo();
        inimigo.zerarEscudo();
    }

}

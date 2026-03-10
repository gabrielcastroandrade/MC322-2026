import java.util.Random;
import java.util.Scanner;

public class Rodada {

    private Heroi jogador;
    private Inimigo inimigo;
    private int energia;
    private int energia_backup;
    private int dano_base;

    public Rodada(Heroi jogador, Inimigo inimigo, int energia, int dano_base) 
    {
        this.jogador = jogador;
        this.inimigo = inimigo;
        this.energia = energia;
        this.dano_base = dano_base;
        this.energia_backup = energia;
    }
    
    public void rodar() 
    {
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
        
        while (energia > 0) 
        {
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
                CartaDano ataque = new CartaDano("Joao", 1);
                ataque.usar(inimigo, dano_base);
                energia -= 1;
            }
            if (escolha == 2) 
            {
                if (energia < 2) 
                {
                    System.out.println("Você não possui energia o sulficiente. Sua rodada foi perdida");
                    energia = 0;
                }
                jogador.ganharEscudo(2*dano_base);
                energia -= 2;
            }
            if (escolha == 3) 
            {
                energia = 0;
            }
        }    

        System.out.println("-//-");        
        System.out.println("Seu turno acabou, o inimigo irá revidar");
        System.out.println();
        Random aleatorio = new Random();
        while (energia_backup > 0) 
        { 
            int min = 1;
            int max = 2;
            int reviravolta = aleatorio.nextInt((max - min) + 1) + min;
            if (reviravolta == 1) 
            {
                jogador.receberDano(dano_base);
                System.out.println("Seu inimigo te atacou, você perdeu " + dano_base + " de vida");
                energia_backup -= 1;
            }
            if (reviravolta == 2) 
            {
                if (energia_backup < 2) {energia_backup = 0;}
                CartaEscudo defesa = new CartaEscudo("Joao", 2);
                defesa.usar(inimigo, 2*dano_base);
                System.out.println("Seu inimigo se defendeu, ele ganhou " + 2*dano_base + " de escudo");
                energia_backup -= 2;
            }
        }
        System.out.println();
        System.out.println("Turno finalizado.");
        System.out.println("-//-");

        jogador.zerarEscudo();
        inimigo.zerarEscudo();
    }

}

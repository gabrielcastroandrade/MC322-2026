import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Dados {

    private List<Carta> mao; 
    private Stack<Carta> compra;
    private Stack<Carta> lixeira;

    public Dados() 
    {
        this.mao  = new ArrayList<>();
        this.compra = new Stack<>();
        this.lixeira = new Stack<>();

        compra.push(new CartaDano("ataque leve", "causa 1 de dano", 1, 1));
        compra.push(new CartaDano("ataque pesado", "causa 2 de dano", 2, 2));
        compra.push(new CartaEscudo("defesa leve", "levanta 1 de escudo", 1, 1));
        compra.push(new CartaEscudo("defesa pesada", "levanta 2 de escudo", 2, 2));
    }

    public void getMao() {}

    public void embaralhar() 
    {
        Collections.shuffle(compra);
    }

    public void comprar() 
    {
        Carta carta;
        carta = compra.removeFirst();
        mao.addFirst(carta);
    }

    public void descartar() 
    {
        Carta carta;
        carta = mao.removeFirst();
        lixeira.push(carta);
    }

    public void reiniciar() {}
}

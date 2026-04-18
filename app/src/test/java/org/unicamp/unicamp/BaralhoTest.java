package org.unicamp.unicamp;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import org.junit.jupiter.api.Test;
import org.unicamp.unicamp.conteudos.Carta;
import org.unicamp.unicamp.sistema.Baralho;


public class BaralhoTest {

    @Test void compraEVenda() {
        Baralho b = new Baralho();
        int len_compra = b.getLenCompra();

        b.comprar();
        assertEquals(1, b.getLenMao());
        assertEquals(len_compra - 1, b.getLenCompra());
        assertEquals(0, b.getLenDescarte());
        assertInstanceOf(Carta.class, b.getMaoIndice(0));

        b.descartar(b.getLenMao() - 1);
        assertEquals(1, b.getLenDescarte());
        assertEquals(0, b.getLenMao());

        b.reiniciar();
        assertEquals(0, b.getLenMao());
        assertEquals(0, b.getLenDescarte());
        assertEquals(len_compra, b.getLenCompra());
    }


}

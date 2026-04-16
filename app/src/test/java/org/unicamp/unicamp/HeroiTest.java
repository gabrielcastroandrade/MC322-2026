package org.unicamp.unicamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.unicamp.unicamp.conteudos.Heroi;

public class HeroiTest {

    @Test void ganharEscudo() {
        Heroi h = new Heroi("heroi", 10, 1);
        h.ganharEscudo(10);
        assertEquals(10, h.getEscudo());
    }

    @Test void danoSemEscudo() {
        Heroi h = new Heroi("heroi", 10, 1);
        h.receberDano(5);
        assertEquals(5, h.getVida());
        assertEquals(0, h.getEscudo());
    }

    @Test void danoMenorEscudo() {
        Heroi h = new Heroi("heroi", 10, 1);
        h.ganharEscudo(10);
        h.receberDano(5);
        assertEquals(10, h.getVida());
        assertEquals(5, h.getEscudo());
    }

    @Test void danoMaiorEscudoMenorVidaTotal() {
        Heroi h = new Heroi("heroi", 10, 1);
        h.ganharEscudo(10);
        h.receberDano(15);
        assertEquals(5, h.getVida());
        assertEquals(0, h.getEscudo());
    }

    @Test void danoMaiorTotal() {
        Heroi h = new Heroi("heroi", 10, 1);
        h.ganharEscudo(10);
        h.receberDano(25);
        assertEquals(0, h.getVida());
        assertEquals(0, h.getEscudo());
    }

    @Test void bulking() {
        Heroi h = new Heroi("heroi", 10, 1);
        h.bulking(10);
        assertEquals(11, h.getDano());
    }

    @Test void cutting() {
        Heroi h = new Heroi("heroi", 10, 10);
        h.cutting(5);
        assertEquals(5, h.getDano());
    }

    @Test void bulkingECutting() {
        Heroi h = new Heroi("heroi", 10, 1);
        h.bulking(10);
        h.cutting(10);
        assertEquals(1, h.getDano());
    }

    @Test void estarMorto() {
        Heroi h = new Heroi("heroi", 10, 1);
        h.receberDano(10);
        assertEquals(false, h.estarVivo());
    }

    @Test void estarVivo() {
        Heroi h = new Heroi("heroi", 10, 1);
        h.receberDano(9);
        assertEquals(true, h.estarVivo());
    }

    



}

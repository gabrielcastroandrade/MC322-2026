package org.unicamp.unicamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;
import org.unicamp.unicamp.conteudos.Heroi;
import org.unicamp.unicamp.conteudos.Inimigo;
import org.unicamp.unicamp.sistema.Baralho;
import org.unicamp.unicamp.sistema.Batalha;
import org.unicamp.unicamp.conteudos.Carta;
import org.unicamp.unicamp.conteudos.CartaDano;
import org.unicamp.unicamp.conteudos.CartaDanoEscudo;
import org.unicamp.unicamp.conteudos.CartaEfeitoForca;
import org.unicamp.unicamp.conteudos.CartaEfeitoForcaFraqueza;
import org.unicamp.unicamp.conteudos.CartaEfeitoFraqueza;
import org.unicamp.unicamp.conteudos.CartaEscudo;
import org.unicamp.unicamp.conteudos.Efeito;
import org.unicamp.unicamp.conteudos.EfeitoForca;
import org.unicamp.unicamp.conteudos.EfeitoFraqueza;


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

    @Test void agirDanoEscudo() {
        Heroi h = new Heroi("heroi", 10, 1);
        Inimigo i = new Inimigo("inimigo", 100, 2);
        Baralho b = new Baralho();
        Batalha dueloAtual = new Batalha(h, "A Dragão", null, 100, 1);
        b.comprar();
        Carta carta_escolhida = new CartaDano("ataque", "ataque", 1);
        h.agir(0, carta_escolhida, i, b, dueloAtual);
        assertEquals(99, i.getVida());
        b.comprar();
        carta_escolhida = new CartaEscudo("escudo", "escudo", 1);
        h.agir(0, carta_escolhida, i, b, dueloAtual);
        assertEquals(1, h.getEscudo());
        b.comprar();
        carta_escolhida = new CartaDanoEscudo("duble", "duble", 3);
        h.agir(0, carta_escolhida, i, b, dueloAtual);
        assertEquals(98, i.getVida());
        assertEquals(3, h.getEscudo());
        b.comprar();
        carta_escolhida = new CartaEfeitoForcaFraqueza("efeitos", "efeitos", 1);
        h.agir(0, carta_escolhida, i, b, dueloAtual);
        assertInstanceOf(EfeitoForca.class, h.getEfeito(0));
        assertInstanceOf(EfeitoFraqueza.class, i.getEfeito(0));
        b.comprar();
        h.limpezaEfeitos();
        i.limpezaEfeitos();
        carta_escolhida = new CartaEfeitoForca("forca", "forca", 1);
        h.agir(0, carta_escolhida, i, b, dueloAtual);
        assertInstanceOf(EfeitoForca.class, h.getEfeito(0));
        b.comprar();
        carta_escolhida = new CartaEfeitoFraqueza("fraqueza", "fraqueza", 1);
        h.agir(0, carta_escolhida, i, b, dueloAtual);
        assertInstanceOf(EfeitoFraqueza.class, i.getEfeito(0));

    }
}

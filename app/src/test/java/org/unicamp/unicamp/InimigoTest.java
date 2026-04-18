package org.unicamp.unicamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.unicamp.unicamp.conteudos.Heroi;
import org.unicamp.unicamp.conteudos.Inimigo;

public class InimigoTest {

    @Test void ganharEscudo() {
        Inimigo i = new Inimigo("Inimigo", 10, 1);
        i.ganharEscudo(10);
        assertEquals(10, i.getEscudo());
    }

    @Test void danoSemEscudo() {
        Inimigo i = new Inimigo("Inimigo", 10, 1);
        i.receberDano(5);
        assertEquals(5, i.getVida());
        assertEquals(0, i.getEscudo());
    }

    @Test void danoMenorEscudo() {
        Inimigo i = new Inimigo("Inimigo", 10, 1);
        i.ganharEscudo(10);
        i.receberDano(5);
        assertEquals(10, i.getVida());
        assertEquals(5, i.getEscudo());
    }

    @Test void danoMaiorEscudoMenorVidaTotal() {
        Inimigo i = new Inimigo("Inimigo", 10, 1);
        i.ganharEscudo(10);
        i.receberDano(15);
        assertEquals(5, i.getVida());
        assertEquals(0, i.getEscudo());
    }

    @Test void danoMaiorTotal() {
        Inimigo i = new Inimigo("Inimigo", 10, 1);
        i.ganharEscudo(10);
        i.receberDano(25);
        assertEquals(0, i.getVida());
        assertEquals(0, i.getEscudo());
    }

    @Test void bulking() {
        Inimigo i = new Inimigo("Inimigo", 10, 1);
        i.bulking(10);
        assertEquals(11, i.getDano());
    }

    @Test void cutting() {
        Inimigo i = new Inimigo("Inimigo", 10, 10);
        i.cutting(5);
        assertEquals(5, i.getDano());
    }

    @Test void bulkingECutting() {
        Inimigo i = new Inimigo("Inimigo", 10, 1);
        i.bulking(10);
        i.cutting(10);
        assertEquals(1, i.getDano());
    }

    @Test void estarMorto() {
        Inimigo i = new Inimigo("Inimigo", 10, 1);
        i.receberDano(10);
        assertEquals(false, i.estarVivo());
    }

    @Test void estarVivo() {
        Inimigo i = new Inimigo("Inimigo", 10, 1);
        i.receberDano(9);
        assertEquals(true, i.estarVivo());
    }

    @Test void escolherAcao() {
        Inimigo i = new Inimigo("Inimigo", 10, 1);
        int acao = i.escolherAcao();
        boolean acertou = false;
        if (1 <= acao && acao <= 7) {acertou = true;}
        assertEquals(true, acertou);
    }

    @Test void executandoAtaqueDuplo() {
        Inimigo i = new Inimigo("Inimigo", 10, 1);
        int acao = 1;
        Heroi h = new Heroi("heroi", 10, 1);
        i.agirAtaque(acao, h);
        assertEquals(8, h.getVida());
    }

    @Test void executandoAtaqueSimples() {
        Inimigo i = new Inimigo("Inimigo", 10, 1);
        int acao = 2;
        Heroi h = new Heroi("heroi", 10, 1);
        i.agirAtaque(acao, h);
        assertEquals(9, h.getVida());
    }

    
    

}

package org.unicamp.unicamp;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.unicamp.unicamp.conteudos.Heroi;
import org.unicamp.unicamp.sistema.Batalha;

public class BatalhaTest {

    @Test void selecaoInimigo1 () {
        String i = "A Dragão";
        Heroi h = new Heroi("heroi", 10, 1);
        Scanner input = new Scanner(System.in);
        int e = 1, n = 1;
        Batalha b = new Batalha(h, i, input, e, n);
        assertEquals("A Dragão", b.getNomeInimigo());
    }

    @Test void selecaoInimigo2 () {
        String i = "A Morte";
        Heroi h = new Heroi("heroi", 10, 1);
        Scanner input = new Scanner(System.in);
        int e = 1, n = 1;
        Batalha b = new Batalha(h, i, input, e, n);
        assertEquals("A Morte", b.getNomeInimigo());
    }

    @Test void selecaoInimigo3 () {
        String i = "O Burro";
        Heroi h = new Heroi("heroi", 10, 1);
        Scanner input = new Scanner(System.in);
        int e = 1, n = 1;
        Batalha b = new Batalha(h, i, input, e, n);
        assertEquals("O Burro", b.getNomeInimigo());
    }

    
}

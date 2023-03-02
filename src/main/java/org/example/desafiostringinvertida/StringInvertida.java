package org.example.desafiostringinvertida;

import java.util.Scanner;

public class StringInvertida {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        final var palavraInicial = entrada.next();

        System.out.println(inverte(palavraInicial));
    }

    private static String inverte(String palavraInicial) {
        final var palavraFinal = new StringBuilder(palavraInicial.length());

        for (String s : palavraInicial.split(" ")) {
            for (int x = s.length() - 1; x >= 0; x--) {
                palavraFinal.append(s.charAt(x));
            }
        }

        return palavraFinal.toString();
    }
}

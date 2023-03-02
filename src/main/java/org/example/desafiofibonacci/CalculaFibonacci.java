package org.example.desafiofibonacci;

import java.util.Scanner;

public class CalculaFibonacci {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        Integer num = entrada.nextInt();

        System.out.println(validaFibonacci(num));
    }

    private static String validaFibonacci(final Integer numero) {

        int primeiroAntecessor = 0;
        int segundoAntecessor = 1;

        if (numero < 0) {
            return "Números negativos não são considerados";
        }

        while (segundoAntecessor < numero) {
            int somaAntecessores = primeiroAntecessor + segundoAntecessor;
            primeiroAntecessor = segundoAntecessor;
            segundoAntecessor = somaAntecessores;
        }

        if (segundoAntecessor == numero) {
           return numero + " pertence à sequência de Fibonacci";
        }

        return numero + " não pertence à sequência de Fibonacci";
    }
}

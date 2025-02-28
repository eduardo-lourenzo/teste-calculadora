package br.edu.zup;

import java.util.Scanner;

public class Calculadora {

    public double calcular(double leftHandSide, double rightHandSide, char operator) {
        return switch (operator) {
            case 'A' -> leftHandSide + rightHandSide;
            case 'S' -> leftHandSide - rightHandSide;
            case 'M' -> leftHandSide * rightHandSide;
            case 'D' -> {
                if (rightHandSide == 0.0d) {
                    throw new IllegalArgumentException("Não é possível dividir por zero.");
                }
                yield leftHandSide / rightHandSide;
            }
            default -> throw new IllegalArgumentException("Operação inválida.");
        };
    }

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        boolean remain = true;
        char operator = 'Z';
        short option = 1;
        double leftHandSide = 0.0d;
        double rightHandSide = 0.0d;
        double result = 0.0d;
        String inputBuffer = "";
        Scanner inputReader = new Scanner(System.in);

        while (remain) {
            System.out.println("\n===========================");
            System.out.println("Escolha o carácter da operação:");
            System.out.println("A: adição.");
            System.out.println("S: subtração.");
            System.out.println("M: multiplicação.");
            System.out.println("D: divisão.");
            System.out.println("0: sair.");

            inputBuffer = inputReader.next();

            if (inputBuffer.length() > 1) {
                System.out.println("Digite somente uma carácter.");
                continue;
            }

            operator = inputBuffer.toUpperCase().charAt(0);

            if (operator == '0') {
                System.out.println("Saindo...");
                break;
            }

            if (operator != 'A' && operator != 'S' && operator != 'M' && operator != 'D') {
                System.out.println("Operação inválida");
                continue;
            }

            System.out.print("Digite o primeiro número: ");
            leftHandSide = inputReader.nextDouble();

            System.out.print("Digite o segundo número: ");
            rightHandSide = inputReader.nextDouble();

            try {
                result = calculadora.calcular(leftHandSide, rightHandSide, operator);
                System.out.println("Resultado: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("\n================");
            System.out.println("Deseja continuar?");
            System.out.println("1: Sim ou 0: Não");
            option = inputReader.nextShort();

            remain = option == 1;
        }

        inputReader.close();
        System.out.println("Fim da calculadora!");
    }
}
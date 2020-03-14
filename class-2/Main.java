package com.college.exercise;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int bidimensionalList[][] = {{1, 3, 2}, {6, 5, 4}, {1, 0, 2}};

//        System.out.println("exibirMatriz():");
//        exibirMatriz(bidimensionalList);

//        System.out.println("\n lerTeclado():");
//        exibirMatriz(lerTeclado());

//        System.out.println("\n gerarNumeroAleatorio():");
//        exibirMatriz(gerarNumeroAleatorio());

//        System.out.println("\n media():");
//        System.out.println((media(bidimensionalList)));

//        System.out.println("\n maiorValor():");
//        System.out.println((maiorValor(bidimensionalList)));

//        System.out.println("\n mediaLinha():");
//        System.out.println((mediaLinha(bidimensionalList, 0)));

//        System.out.println("\n maiorLinha():");
//        System.out.println((Arrays.toString(maiorLinha(bidimensionalList))));

//        System.out.println("\n pesquisar():");
//        System.out.println(pesquisar(bidimensionalList, 3));

//        System.out.println("\n ordenarLinha():");
//        ordenarLinha(bidimensionalList, 1);

//        System.out.println("\n gerarArrayUnidimensional():");
//        System.out.println(Arrays.toString(gerarArrayUnidimensional(bidimensionalList)));

        System.out.println("\n generateMatriz():");
        exibirMatriz(generateMatriz(6));
    }

    public static void exibirMatriz(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }

    public static int[][] lerTeclado() {
        int bidemensionalList [][] = new int[3][3];
        Teclado keyboard = new Teclado();
        for (int i = 0; i < bidemensionalList.length; i++) {
            for (int j =  0; j < bidemensionalList[i].length; j++) {
                bidemensionalList[i][j] = keyboard.leInt("Set the value for [" + i + "] [" + j + "] = ");
            }
        }
        return bidemensionalList;
    }

    public static int[][] gerarNumeroAleatorio() {
        int bidemensionalList [][] = new int[3][3];
        for (int i = 0; i < bidemensionalList.length; i++) {
            for (int j =  0; j < bidemensionalList[i].length; j++) {
                bidemensionalList[i][j] = (int) (Math.random() * 100);
            }
        }
        return  bidemensionalList;
    }

    public static double media (int[][] m) {
        int valuesAmount = 0;
        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j =  0; j < m[i].length; j++) {
                sum += m[i][j];
                valuesAmount++;
            }
        }
        return sum/valuesAmount;
    }

    public static int maiorValor (int[][] m) {
        int biggestValue = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] > biggestValue) {
                    biggestValue = m[i][j];
                }
            }
        }
        return biggestValue;
    }

    public static double mediaLinha (int[][] m, int linha) {
        int valuesAmount = 0;
        double sum = 0;

        for (int i = 0; i < m[linha].length; i++) {
            valuesAmount = m[linha].length - 1;
            sum += m[linha][i];
        }

        return sum/valuesAmount;
    }

    public static int[] maiorLinha(int[][] m) {
        int biggestValueForEachLine[] = new int [3];
        int currentLineBiggestValue;

        for (int i = 0; i < m.length; i++) {
            currentLineBiggestValue = m[i][0];
            for (int j = 0; j < m[i].length; j++) {
                if (currentLineBiggestValue < m[i][j]) {
                    currentLineBiggestValue = m[i][j];
                }
                if (j == m[i].length - 1) {
                    biggestValueForEachLine[i] = currentLineBiggestValue;
                }
            }
        }

        return biggestValueForEachLine;
    }

    public static boolean pesquisar(int[][] m, int v) {
        boolean matrizContainsValue = false;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (v == m[i][j]) matrizContainsValue = true;
            }
        }

        return matrizContainsValue;
    }

    public static void ordenarLinha(int[][] m, int linha) {

        for (int i = 0; i < m[linha].length; i++) {
            for(int j = 0; j < m[linha].length - 1; j++) {
                if (m[linha][j] > m[linha][j + 1]) {
                    int currentValue = m[linha][j];
                    m[linha][j] = m[linha][j + 1];
                    m[linha][j + 1] = currentValue;
                }
            }
        }

        System.out.println(Arrays.toString(m[linha]));
    }

    public static int[] gerarArrayUnidimensional(int[][] m) {
        int valuesCounter = 0;
        int unidimensionalList[] = new int [9];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                unidimensionalList[valuesCounter] = m[i][j];
                valuesCounter++;
            }
        }

        return unidimensionalList;
    }

    public static int[][] generateMatriz(int lines) {
        int matriz [][] = new int[lines][lines];

        for (int i = 0; i < matriz.length; i++) {
            int counter = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                if (i <= j) {
                    counter++;
                }
                matriz[i][j] = counter;
            }
        }

        return  matriz;
    }
}
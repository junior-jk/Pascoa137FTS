// 1 - Pacote: e um conjunto de classes e o pai dele

package br.com.interasys;
// 2 - Bibliotecas - o que voce vai usar as bibliotecas


// 3 - Classe -  É sobre o que voce vai usar isso aqui(calculadora)
public class Calculadora {  // inicio da classe
// 3.1 - class sao sempre sustantivos
// Atributos - adjetivos - são caracteristicas - campos


// 3.2 - Funções e Metódos
         //usa os verbos e melhor para ler

    public static double somarDoisNumeros(double num1, double num2) {    //inicio da funcao
        return num1 + num2;
    }//final da funcao

    public static double subtrairDoisNumeros(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiplicarDoisNumeros(double num1, double num2) {
        return num1 * num2;
    }
    public static double dividirDoisNumeros(double num1, double num2) {
        return num1 / num2;
    }

     public static String dividirDoisNumerosInteiros(int numA, int numB){
        return ("Nao e possivel dividir por 0");
    }
}

 // final da classe

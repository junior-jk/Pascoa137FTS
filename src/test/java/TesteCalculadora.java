
package unitTest;

// Bibliotecas

import br.com.interasys.Calculadora;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Classes
public class TesteCalculadora {             // iniciou da classe
    // Atributos

    // Funções e Metódos
    @Test
    public void testesomarDoisNumeros() { // inicio da funcao SomarDoisNumeros
        // configurar
        // valores de entrada recebe

        double num1 = 10;
        double num2 = 7;
        //valores de saida
        double resultadoEsperado = 17;

        // executa
        double resultadoAtual = Calculadora.somarDoisNumeros(num1, num2);

        // valida
        assertEquals(resultadoEsperado, resultadoAtual);
    }   // final da funcao SomarDoisNumeros

    // Este e um teste data drive -  direcionados por dados
    // Este é um teste de unidade orientado a dados - direcionado por dados
    @ParameterizedTest
    @CsvSource(value = {
            "10, 7, 17.0",
            "56, 44, 100.0",
            "10, 0, 10.0",
            "15, -5, 10.0",
            "-8, -6, -14.0"
    }, delimiter = ',')

    public void testesomarDoisNumerosLendoLista(String txtNum1, String txtNum2, String resultadoEsperado) { // inicio da funcao SomarDoisNumeros
        // Configurar
        // Os dados de entrada e o resultado esperado vem da lista

        // Executa

        // executa
        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(txtNum1), Integer.valueOf(txtNum2));

        // valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    }   // final da funcao SomarDoisNumeros

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/massaSomar.csv",numLinesToSkip = 1, delimiter = ',')
    public void testesomarDoisNumerosLendoArquivo(String txtNum1, String txtNum2, String resultadoEsperado) { // inicio da funcao SomarDoisNumeros
        // Configurar
        // Os dados de entrada e o resultado esperado vem da lista

        // Executa

        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(txtNum1), Integer.valueOf(txtNum2));

        // valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    }   // final da funcao SomarDoisNumeros

    @Test
    public void testesubtrairDoisNumeros() {

        double num1 = 10;
        double num2 = 7;
        double resultadoEsperado = 3; // valores de saida
        double resultadoAtual = Calculadora.subtrairDoisNumeros(num1, num2); // executa
        assertEquals(resultadoEsperado, resultadoAtual); // valida
    }

    @ParameterizedTest
    @CsvSource(value = {
            "20,30,-10",
            "47,15,32",
            "31,28,3",
            "45,-34,79",
            "36,10,26"
    }, delimiter = ',')

    public void testesubtrairDoisNumerosLendoLista(String txtNum1, String txtNum2, String resultadoEsperado) { // inicio da funcao SomarDoisNumeros
        // configura           // os testes costuma ser mais void ele
        // valores de entrada recebe
        // os resultados esperado vem das listas

        // executa
        double resultadoAtual = Calculadora.subtrairDoisNumeros(Integer.valueOf(txtNum1), Integer.valueOf(txtNum2));

        // valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    } // final da funcao testesubtrairDoisNumerosLendoLista

    @CsvFileSource(resources = "/csv/massaSubtrair.csv", numLinesToSkip = 1, delimiter = ',')
    public void testesubtrairDoisNumerosLendoArquivo(String txtNum1, String txtNum2, String resultadoEsperado) { // inicio da funcao SomarDoisNumeros
        double resultadoAtual = Calculadora.subtrairDoisNumeros(Integer.valueOf(txtNum1), Integer.valueOf(txtNum2));
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    }

    @Test
    public void testemultiplicarDoisNumeros() {
        double num1 = 10;
        double num2 = 5;
        double resultadoEsperado = 50;  // valores de saida
        double resultadoAtual = Calculadora.multiplicarDoisNumeros(num1, num2);  // executa
        assertEquals(resultadoEsperado, resultadoAtual);  // valida
    }

    @ParameterizedTest
    @CsvSource(value = {

            "-12, -5, 60",
            "-7, 10, -70",
            "9, -11, -99",
            "-6, -18, 108",
            "17, 3, 51"

    }, delimiter = ',')


    @CsvFileSource(resources = "/csv/massamultiplicar.csv", numLinesToSkip = 1, delimiter = ',')
    public void testemultiplicarDoisNumerosLendoArquivo(String txtNum1, String txtNum2, String resultadoEsperado) {      // inicio da funcao SomarDoisNumeros
        double resultadoAtual = Calculadora.multiplicarDoisNumeros(Integer.valueOf(txtNum1), Integer.valueOf(txtNum2));
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    }

    @Test
    public void testedividirDoisNumeros() {

        double num1 = 10;
        double num2 = 2;
        double resultadoEsperado = 5;  // valores de saida
        double resultadoAtual = Calculadora.dividirDoisNumeros(num1, num2);  // executa
        assertEquals(resultadoEsperado, resultadoAtual);  // valida
    }


    @CsvSource(value = {
            "10,5,2",
            "6,3,2",
            "10,2,5",
            "7,7,1",
            "9,3,3"
    }, delimiter = ',')

    @CsvFileSource(resources = "csv/massaDividir.csv", numLinesToSkip = 1, delimiter = 1)
    public void testedividirDoisNumerosLendoArquivo(String txtNum1, String txtNum2, String resultadoEsperado) { // inicio da funcao SomarDoisNumeros
        double resultadoAtual = Calculadora.dividirDoisNumeros(Integer.valueOf(txtNum1), Integer.valueOf(txtNum2));
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    }

    @Test
    public void testedividirDoisNumerosInteiros(){

        // configura
        int numA = 10;
        int numB = 0;
        String resultadoEsperado = "Nao e possivel dividir por 0";

        // Executa
        String resultadoAtual = Calculadora.dividirDoisNumerosInteiros(numA, numB);

        // Valida
        assertEquals(resultadoEsperado,resultadoAtual);
        System.out.println(numA + " / " + numB + " = " + resultadoAtual);
        System.out.println("O resultado Esperado: " + resultadoEsperado);

    }
} // final da classe

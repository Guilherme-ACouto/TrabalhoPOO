package util;

//IMPORTAÇÃO DE BIBLIOTECAS
import java.util.Scanner;

//CRIANDO CLASSE INTERFACE USUARIO
public class InterfaceUsuario {
    private static Scanner scanner = new Scanner(System.in);

    //METODO PARA PEDIR VALOR DO IMOVEL
    public static double pedirValorImovel() {
        double valorImovel;

        System.out.print("\nDigite o valor do imóvel: ");
        valorImovel = scanner.nextDouble();

        //LOOP WHILE PARA VALOR POSITIVO
        while (valorImovel <= 0) {
            System.out.println("\n*** Valor não aceito *** ");
            System.out.println("\n*** Digite novamente ***");

            System.out.print("\nDigite o valor do imóvel: ");
            valorImovel = scanner.nextDouble();

        }
        return valorImovel;
    }

    //METODO PARA PEDIR PRAZO DE FINANCIAMENTO
    public static int pedirPrazoFinanciamento() {
        int prazoFinanciamento;

        //LOOP DO-WHILE PARA VALIDAR VALOR POSITIVO
        do {
            System.out.print("\nEm quantos anos quer financiar? ");
            prazoFinanciamento = scanner.nextInt();


            if (prazoFinanciamento <= 0) {
                System.out.println("\n*** Prazo de financiamento não aceito *** ");
                System.out.println("*** Digite novamente  ***");

            } else if (prazoFinanciamento >= 36) {                   // NAO ACEITA VALOR MAIOR
                System.out.println("\n*** Excede o prazo permitido *** ");
                System.out.println("*** Digite novamente ***");
            }

        } while (prazoFinanciamento <= 0 || prazoFinanciamento >= 50);

        return prazoFinanciamento;
    }

    //METODO PARA PEDIR TAXA DE JUROS
    public static double pedirTaxaJuros() {
        double taxaJuros;

        for (; ; ) {
            System.out.print("\nDigite a taxa de juros anual: ");
            taxaJuros = scanner.nextDouble();

            //IF PARA VALIDAR TAXA DE JUROS
            if (taxaJuros > 0) {
                break;
            } else {
                System.out.println("\n*** Taxa de juros inválida ***");
            }
        }
        return taxaJuros;
    }
}

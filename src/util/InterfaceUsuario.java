package util;

//IMPORTAÇÃO DE BIBLIOTECAS
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.InputMismatchException;

//CRIANDO CLASSE INTERFACE USUARIO
public class InterfaceUsuario {
    private static Scanner scanner = new Scanner(System.in);
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    //METODO PARA PEDIR VALOR DO IMOVEL
    public static double pedirValorImovel() {
        while (true) {
            try {
                System.out.print("Digite o valor do imóvel: ");
                double valor = scanner.nextDouble();
                if (valor <= 0) {
                    throw new Exception("O valor deve ser maior que zero.");
                }
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("\nValor inválido. Certifique-se de inserir um valor válido.\n");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }
    //METODO PARA PEDIR PRAZO DE FINANCIAMENTO
    public static int pedirPrazoFinanciamento() {
        int prazoFinanciamento;
        while (true)
            try {
                System.out.print("Em quantos anos quer financiar? ");
                prazoFinanciamento = scanner.nextInt();
                if (prazoFinanciamento <= 0 || prazoFinanciamento >= 35) {
                    throw new Exception("Prazo de financiamento não aceito.");
                }
                return prazoFinanciamento;
            } catch (InputMismatchException e) {
                System.out.println("\nValor inválido. Certifique-se de inserir um valor válido.\n");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine();
            }
    }
    //METODO PARA PEDIR TAXA DE JUROS
    public static double pedirTaxaJuros() {
        double taxaJuros;
        while (true) {
            try {
                System.out.print("Digite o valor da taxa de juros: ");
                taxaJuros = scanner.nextDouble();
                if (taxaJuros <= 0) {
                    throw new Exception("O valor deve ser maior que zero.");
                }
                return taxaJuros;
            } catch (InputMismatchException e) {
                System.out.println("\nValor inválido. Certifique-se de inserir um valor válido.\n");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }
}

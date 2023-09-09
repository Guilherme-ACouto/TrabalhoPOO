//IMPORTAÇÃO DE PACOTE
package main;
//IMPORTAÇÃO DE BIBLIOTECAS
import modelo.Casa;
import util.InterfaceUsuario;
import modelo.Financiamento;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

//INICIO DA APLICAÇÃOz
public class Main {
    public static void main(String[] args) {

        List<Financiamento> financiamentos = new ArrayList<>(); //CRIANDO A ARRAYLIST
        Scanner scanner = new Scanner(System.in);
        char continuar;

        //LAÇO DO-WHILE NO INICIO DA APLICAÇÃO SOLICITANDO ENTRADA DE DADOS ATRAVÉS DA INTERFACE USUÁRIO
        do {

            double valorDaCasa = InterfaceUsuario.pedirValorImovel();
            int  prazoFinanciamento = InterfaceUsuario.pedirPrazoFinanciamento();
            double taxaJurosAnual = InterfaceUsuario.pedirTaxaJuros();

            Financiamento financiamento = new Casa(valorDaCasa,prazoFinanciamento,taxaJurosAnual);

            financiamentos.add(financiamento);


            System.out.print("Deseja inserir outro financiamento? (S/N): "); //
            continuar = scanner.next().charAt(0);
        } while (continuar == 'S' || continuar == 's');

        double totalImoveis = 0;                                       //INICIANDO VARIAVEL
        double totalFinanciamentos = 0;                                //INICIANDO VARIAVEL

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")); //FORMATANDO PARA BR

        for (int i = 0; i < financiamentos.size(); i++) {              //FOR PARA ACESSAR OS FINANCIAMENTOS NA LISTA E MOSTRAR EM TELA
            Financiamento financiamento = financiamentos.get(i);
            System.out.println("\nFinanciamento " + (i + 1));
            System.out.println("º Valor do imóvel: " + currencyFormat.format(financiamento.getValorDaCasa()));
            System.out.println("º Valor do financiamento: " + currencyFormat.format(financiamento.calcularTotalPagamento()));
            System.out.println("º Valor da taxa de juros: " + currencyFormat.format(financiamento.getTaxaJurosAnual()));
            System.out.println("º Valor da parcela : " + currencyFormat.format(financiamento.calcularPagamentoMensal()));

            if (financiamento instanceof Casa) {
                System.out.println("º Desconto por parcela: " + currencyFormat.format(((Casa) financiamento).getDescontoPorParcela()));
            }

            if (financiamento instanceof Casa) {
                double proximaParcelaComDesconto = ((Casa) financiamento).calcularProximaParcelaComDesconto();
                System.out.println("º Próxima parcela com desconto: " + currencyFormat.format(proximaParcelaComDesconto));
            }

            System.out.println("º Prazo de financiamento: " + financiamento.getPrazoFinanciamento() + ", anos ");


            totalImoveis += financiamento.getValorDaCasa();                  //VARIAVEL RECEBENDO O VALOR ATRAVES DO METODO
            totalFinanciamentos += financiamento.calcularTotalPagamento();   //VARIAVEL RECEBENDO O VALOR ATRAVES DO METODO
        }

        //MOSTRANDO EM TELA O VALOR TOTAL DOS IMOVEIS E TOTAL DOS FINANCIAMENTOS
        System.out.println("\nTotal de todos os imóveis: " + currencyFormat.format(totalImoveis));
        System.out.println("Total de todos os financiamentos: " + currencyFormat.format(totalFinanciamentos));

        scanner.close();
    }
}

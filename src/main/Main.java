package main;

//IMPORTAÇÃO DE BIBLIOTECAS
import modelo.*;
import util.InterfaceUsuario;
import java.io.Writer;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import Dados.ArquivoTexto;
import Dados.ArquivoSerializado;
import java.io.IOException;
import static Dados.ArquivoTexto.lerDados;
import static Dados.ArquivoTexto.salvarDados;

//INICIO DA APLICAÇÃO
public class Main {
    public static void main(String[] args) throws DescontoMaiorDoQueJurosException, IOException {

        //CRIANDO A LISTA FINANCIAMENTOS
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        //COLETANDO VALORES DIGITADOS PELO USUÁRIO ATRAVÉS DO METODO SCANNER NA CLASSE INTERFACE USUÁRIO
        double valorDaCasa = InterfaceUsuario.pedirValorImovel();
        int  prazoFinanciamento = InterfaceUsuario.pedirPrazoFinanciamento();
        double taxaJurosAnual = InterfaceUsuario.pedirTaxaJuros();

        financiamentos.add(new Casa(valorDaCasa, prazoFinanciamento,taxaJurosAnual, 60, 350));
        financiamentos.add(new Casa(300000, 15,10, 40, 250));
        financiamentos.add(new Apartamento(400000, 25, 8,1,8));
        financiamentos.add(new Apartamento(500000, 30, 5,2,6));
        financiamentos.add(new Terreno(100, 5, 11,"Residencial"));
        financiamentos.add(new Terreno(200, 15, 8,"Comercial"));

       salvarDados(financiamentos);

        ArquivoSerializado.salvarListaSerializada(financiamentos, "DadosFinanciamentos.ser");

        String listaSerializada = String.valueOf(ArquivoSerializado.lerListaSerializada("DadosFinanciamentos.ser"));

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")); //FORMATANDO PARA BR

        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        //FOR PARA PERCORRER A LISTA
        for (Financiamento financiamento : financiamentos) {
            System.out.println(financiamento.toString());
            totalImoveis += financiamento.getValorDaCasa();                 //VARIÁVEL RECEBENDO OS VALORES TOTAIS DOS IMÓVEIS
            totalFinanciamentos += financiamento.calcularTotalPagamento();  //VARIÁVEL RECEBENDO OS VALORES TOTAIS DOS FINANCIAMENTOS
        }
        //IMPRIME VALOR TOTAL DOS IMOVEIS E TOTAL DOS FINANCIAMENTOS
        System.out.println("\nValor total de todos os imóveis: " + currencyFormat.format(totalImoveis));
        System.out.println("Valor total de todos os financiamentos: " + currencyFormat.format(totalFinanciamentos));

        lerDados(financiamentos);
        System.out.println("\nLendo lista serelizada:");
        System.out.println(listaSerializada);

    }

}

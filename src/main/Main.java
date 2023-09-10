package main;

//IMPORTAÇÃO DE BIBLIOTECAS
import modelo.Apartamento;
import modelo.Casa;
import modelo.Terreno;
import util.InterfaceUsuario;
import modelo.Financiamento;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

//INICIO DA APLICAÇÃO
public class Main {
    public static void main(String[] args) {

        //CRIANDO A LISTA FINANCIAMENTOS
        List<Financiamento> financiamentos = new ArrayList<>();

        //COLETANDO VALORES DIGITADOS PELO USUÁRIO ATRAVÉS DO METODO SCANNER NA CLASSE INTERFACE USUÁRIO
        double valorDaCasa = InterfaceUsuario.pedirValorImovel();
        int  prazoFinanciamento = InterfaceUsuario.pedirPrazoFinanciamento();
        double taxaJurosAnual = InterfaceUsuario.pedirTaxaJuros();

        //CRIANDO OS OBJETOS E ADICIONANDO NA LISTA FINANCIAMENTOS UTILIZANDO POLIMORFISMO
        financiamentos.add(new Casa(valorDaCasa, prazoFinanciamento,taxaJurosAnual, 60, 350));
        financiamentos.add(new Casa(300000, 15,10, 40, 250));
        financiamentos.add(new Apartamento(400000, 25, 8,1,8));
        financiamentos.add(new Apartamento(500000, 30, 5,2,6));
        financiamentos.add(new Terreno(150000, 5, 11,"Residencial"));
        financiamentos.add(new Terreno(350000, 15, 8,"Comercial"));


        //INICIANDO VARIÁVEIS
        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        //FORMATANDO PARA LINGUAGEM BR
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")); //FORMATANDO PARA BR

        //FOR PARA PERCORRER A LISTA E RETORNA O VALOR DE CADE POSIÇÃO ADICIONA NA VARIAVÉL i
        for (int i = 0; i < financiamentos.size(); i++) {
            Financiamento lista = financiamentos.get(i);

            //INSTANCEOF NA LISTA PARA CADA OBJETO CASA E IMPRIME AS INFORMAÇÕES ABAIXO
            if (lista instanceof Casa) {
                double proximaParcelaComDesconto = ((Casa) lista).calcularProximaParcelaComDesconto();
                System.out.println("\nCasa ");
                System.out.println("º Valor da casa: " + currencyFormat.format(lista.getValorDaCasa()));
                System.out.println("º Valor do financiamento: " + currencyFormat.format(lista.calcularTotalPagamento()));
                System.out.println("º Valor da taxa de juros: " + currencyFormat.format(lista.getTaxaJurosAnual()));
                System.out.println("º Valor da parcela : " + currencyFormat.format(lista.calcularPagamentoMensal()));
                System.out.println("º Desconto por parcela: " + currencyFormat.format(((Casa) lista).getDescontoPorParcela()));
                System.out.println("º Próxima parcela com desconto: " + currencyFormat.format(proximaParcelaComDesconto));
                System.out.println("º Tamanho da casa: " + ((Casa) lista).getAreaConstruida() + ", Metros quadrados");
                System.out.println("º Tamanho do terreno: " + ((Casa) lista).getTamanhoTerreno() + " Metros quadrados");
                System.out.println("º Prazo de financiamento: " + lista.getPrazoFinanciamento() + ", anos ");
            }

            //INSTANCEOF NA LISTA PARA CADA OBJETO APARTAMENTO E IMPRIME AS INFORMAÇÕES ABAIXO
            if (lista instanceof Apartamento) {
                System.out.println("\nApartamento ");
                System.out.println("º Valor do Apartamento: " + currencyFormat.format(lista.getValorDaCasa()));
                System.out.println("º Valor do financiamento: " + currencyFormat.format(lista.calcularTotalPagamento()));
                System.out.println("º Valor da taxa de juros: " + currencyFormat.format(lista.getTaxaJurosAnual()));
                System.out.println("º Valor da parcela : " + currencyFormat.format(lista.calcularPagamentoMensal()));
                System.out.println("º (1ª) Parcela com desconto: " + currencyFormat.format(((Apartamento) lista).calcularProximaParcelaComDesconto(3)));
                System.out.println("º (2ª) Parcela com desconto: " + currencyFormat.format(((Apartamento) lista).calcularProximaParcelaComDesconto(2)));
                System.out.println("º (3ª) Parcela com desconto: " + currencyFormat.format(((Apartamento) lista).calcularProximaParcelaComDesconto(1)));
                System.out.println("º Vagas de garagem: " + ((Apartamento) lista).garagem() + ", vagas");
                System.out.println("º Andar: " + ((Apartamento) lista).andar() + "º");
                System.out.println("º Prazo de financiamento: " + lista.getPrazoFinanciamento() + ", anos ");

            }

            //INSTANCEOF NA LISTA PARA CADA OBJETO TERRENO E IMPRIME AS INFORMAÇÕES ABAIXO
            if (lista instanceof Terreno) {
                System.out.println("\nTerreno ");
                System.out.println("º Valor do terreno: " + currencyFormat.format(lista.getValorDaCasa()));
                System.out.println("º Valor do financiamento com acréscimo: " + currencyFormat.format(((Terreno) lista).calcularAcrescimo()));
                System.out.println("º Valor da taxa de juros: " + currencyFormat.format(lista.getTaxaJurosAnual()));
                System.out.println("º Valor da parcela : " + currencyFormat.format(lista.calcularPagamentoMensal()));
                System.out.println("º Valor do terreno sem acréscimo: " + currencyFormat.format(((Terreno) lista).calcularTotalPagamentoSemAcrescimo()));
                System.out.println("º Tipo de terreno: " + ((Terreno) lista).tipo());
                System.out.println("º Prazo de financiamento: " + lista.getPrazoFinanciamento() + ", anos ");
            }

            //VARIÁVEL RECEBENDO OS VALORES TOTAIS DOS IMÓVEIS
            totalImoveis += lista.getValorDaCasa();
            //VARIÁVEL RECEBENDO OS VALORES TOTAIS DOS FINANCIAMENTOS
            totalFinanciamentos += lista.calcularTotalPagamento();
        }

        //IMPRIME VALOR TOTAL DOS IMOVEIS E TOTAL DOS FINANCIAMENTOS
        System.out.println("\nValor total de todos os imóveis: " + currencyFormat.format(totalImoveis));
        System.out.println("Valor total de todos os financiamentos: " + currencyFormat.format(totalFinanciamentos));
    }
}

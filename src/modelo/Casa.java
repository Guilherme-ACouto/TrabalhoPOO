package modelo;

//IMPORTAÇÃO DE BIBLIOTECAS
import java.text.NumberFormat;
import java.util.Locale;

// CRIANDO A CLASSE CASA E EXTENDENDO PARA FINANCIAMENTO
public class Casa extends Financiamento {

    private static final double descontoMaximo = 100.0;
    private double descontoPorParcela;
    private int parcelaAtual = 0;
    private int areaConstruida;
    private int tamanhoTerreno;

    //MÉTODO CONSTRUTOR DA CLASSE CASA INVOCANDO O CONSTRUTOR DA CLASSE PAI
    public Casa(double valorDaCasa, int prazoFinanciamento, double taxaJurosAnual, int areaConstruida, int tamanhoTerreno) {
        super(valorDaCasa, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
        calcularDescontoPorParcela();
    }

    //GETTER PARA ATRIBUTO PRIVADO
    public int getAreaConstruida() {
        return this.areaConstruida;
    }

    //GETTER PARA ATRIBUTO PRIVADO
    public int getTamanhoTerreno() {
        return this.tamanhoTerreno;
    }

    //GETER PARA ATRIBUTO PRIVADO
    public double getDescontoPorParcela() {
        return descontoPorParcela;
    }

    // METODO PARA CALCULAR PAGAMENTO MENSAL
    public double calcularPagamentoMensal() {
        double taxaMensal = (getTaxaJurosAnual() / 12.0) / 100.0;
        int numeroPagamentos = getPrazoFinanciamento() * 12;
        double pagamentoMensal = getValorDaCasa() * (taxaMensal * Math.pow(1 + taxaMensal, numeroPagamentos)) /
                (Math.pow(1 + taxaMensal, numeroPagamentos) - 1);
        return pagamentoMensal;
    }

    // METODO PARA CALCULAR PAGAMENTO TOTAL
    public double calcularTotalPagamento(){
        return calcularPagamentoMensal() * getPrazoFinanciamento() * 12;
    }

    //MÉTODO PARA CALCULAR O DESCONTO POR PARCELA
    private void calcularDescontoPorParcela() {
        descontoPorParcela = Math.min(calcularPagamentoMensal(), descontoMaximo);
    }

    //MÉTODO PARA CALCULAR O VALOR DA PRÓXIMA PARCELA
    public double calcularProximaParcelaComDesconto() {
        parcelaAtual = parcelaAtual + 1;
        double proximaParcela = calcularPagamentoMensal() - descontoPorParcela;
        if (proximaParcela < 0) {
            return 0;
        }
        return proximaParcela;
    }

    //FORMATANDO PARA LINGUAGEM BR
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")); //FORMATANDO PARA BR

    //MÉTODO TOSTRING PARA IMPRESSÃO DAS INFORMAÇÕES
    public String toString() {
        return "\nCasa" +
                "\nº Valor da casa: " + currencyFormat.format(getValorDaCasa()) +
                "\nº Valor do financiamento: " + currencyFormat.format(calcularTotalPagamento()) +
                "\nº Valor da taxa de juros: " + (getTaxaJurosAnual()) + "%" +
                "\nº Valor da parcela: " + currencyFormat.format(calcularPagamentoMensal()) +
                "\nº Desconto por parcela: " + currencyFormat.format(getDescontoPorParcela()) +
                "\nº Próxima parcela com desconto: " + currencyFormat.format(calcularProximaParcelaComDesconto()) +
                "\nº Tamanho da casa: " + getAreaConstruida() + " Metros quadrados" +
                "\nº Tamanho do terreno: " + getTamanhoTerreno() + " Metros quadrados" +
                "\nº Prazo de financiamento: " + getPrazoFinanciamento() + " anos";
    }
}

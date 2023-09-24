package modelo;

//IMPORTAÇÃO DE BIBLIOTECAS
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import util.InterfaceUsuario;
import modelo.Financiamento;

// CRIANDO A CLASSE CASA E EXTENDENDO PARA FINANCIAMENTO
public class Casa extends Financiamento implements Serializable {


    private int areaConstruida;
    private int tamanhoTerreno;
    private double desconto = 100;
    private transient Scanner scanner;

    //MÉTODO CONSTRUTOR DA CLASSE CASA INVOCANDO O CONSTRUTOR DA CLASSE PAI
    public Casa(double valorDaCasa, int prazoFinanciamento, double taxaJurosAnual, int areaConstruida, int tamanhoTerreno) throws DescontoMaiorDoQueJurosException{
        super(valorDaCasa, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
        this.scanner = new Scanner(System.in);
        setDesc(desconto);

    }
    //MÉTODO PARA VALIDAR SE O VALOR DO DESCONTO É MAIOR QUE TAXA DE JUROS MENSAL
    public void setDesc(double desconto) {
        double parcelaMensal = calcularPagamentoMensal();

        while (desconto > calcularJurosMensais()) {
            try {
                throw new DescontoMaiorDoQueJurosException("O desconto é maior do que os juros da mensalidade.");
            } catch (DescontoMaiorDoQueJurosException e) {
                System.out.println("Erro: " + e.getMessage());
                double novaTaxaJurosAnual = InterfaceUsuario.pedirTaxaJuros();
                setTaxaJurosAnual(novaTaxaJurosAnual);
                this.desconto = desconto;
            }
        }
    }
    //GETTER PARA ATRIBUTO PRIVADO
    public int getAreaConstruida() {
        return areaConstruida;
    }
    //GETTER PARA ATRIBUTO PRIVADO
    public int getTamanhoTerreno() {
        return tamanhoTerreno;
    }
    //GETTER PARA ATRIBUTO PRIVADO
    public double getDesconto() {
        return desconto;
    }
    // METODO PARA CALCULAR PAGAMENTO MENSAL COM DESCONTO
    public double calcularPagamentoMensal() {
        double taxaMensal = (getTaxaJurosAnual() / 12.0) / 100.0;
        int numeroPagamentos = getPrazoFinanciamento() * 12;
        double pagamentoMensal = getValorDaCasa() * (taxaMensal * Math.pow(1 + taxaMensal, numeroPagamentos)) /
                (Math.pow(1 + taxaMensal, numeroPagamentos) - 1);
        if (pagamentoMensal > getDesconto()) {
            pagamentoMensal -= getDesconto();
        }
        return pagamentoMensal;
    }
    // METODO PARA CALCULAR PAGAMENTO TOTAL
    public double calcularTotalPagamento(){
        return calcularPagamentoMensal() * getPrazoFinanciamento() * 12;
    }
    //MÉTODO PARA CALCULAR O VALOR DO JUROS MENSAL
    public double calcularJurosMensais() {
        double taxaMensal = (getTaxaJurosAnual() / 12.0) / 100.0;
        int numeroPagamentos = getPrazoFinanciamento() * 12;
        double valorParcela = calcularPagamentoMensal(); // Usando seu método existente
        // CALCULANDO O VALOR TOTAL PAGO DURANTE O PRAZO DO FINANCIAMENTO
        double valorTotalPago = valorParcela * numeroPagamentos;
        // CALCULANDO O VALOR DOS JUROS PAGOS
        double jurosMensais = valorTotalPago - getValorDaCasa();
        // DIVIDINDO OS JUROS MENSAIS PELO NÚMERO DE MESES
        jurosMensais /= numeroPagamentos;
        return jurosMensais;
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
                "\nº Tamanho da casa: " + getAreaConstruida() + " Metros quadrados" +
                "\nº Tamanho do terreno: " + getTamanhoTerreno() + " Metros quadrados" +
                "\nº Prazo de financiamento: " + getPrazoFinanciamento() + " anos";
    }
}

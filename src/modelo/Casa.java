package modelo;

//IMPORTAÇÃO DE BIBLIOTECAS
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

// CRIANDO A CLASSE CASA E EXTENDENDO PARA FINANCIAMENTO
public class Casa extends Financiamento {
    Scanner scanner = new Scanner(System.in);

    private int areaConstruida;
    private int tamanhoTerreno;
    private double desconto = 100;

    //MÉTODO CONSTRUTOR DA CLASSE CASA INVOCANDO O CONSTRUTOR DA CLASSE PAI
    public Casa(double valorDaCasa, int prazoFinanciamento, double taxaJurosAnual, int areaConstruida, int tamanhoTerreno) throws DescontoMaiorDoQueJurosException{
        super(valorDaCasa, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
        setDesc(desconto);
    }
    public void setDesc(double desconto) {
        while (desconto > calcularJurosMensais()) {
            try {
                throw new DescontoMaiorDoQueJurosException("Erro: " + desconto);
            } catch (DescontoMaiorDoQueJurosException e) {
                // Trate a exceção aqui, por exemplo, exibindo uma mensagem de erro ou fazendo algo apropriado.
                System.out.println("Erro: O desconto é maior do que os juros da mensalidade.");
                // Peça novamente o valor do desconto
                Scanner sc = new Scanner(System.in);
                System.out.print("Digite um novo valor de desconto: ");
                desconto = sc.nextDouble();
            }
        }
        this.desconto = desconto;
    }
    //GETTER PARA ATRIBUTO PRIVADO
    public int getAreaConstruida() {
        return areaConstruida;
    }

    //GETTER PARA ATRIBUTO PRIVADO
    public int getTamanhoTerreno() {
        return tamanhoTerreno;
    }

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
    public double calcularJurosMensais() {
        double taxaMensal = (getTaxaJurosAnual() / 12.0) / 100.0;
        int numeroPagamentos = getPrazoFinanciamento() * 12;
        double valorParcela = calcularPagamentoMensal(); // Usando seu método existente

        // Calculando o valor total pago durante o prazo do financiamento
        double valorTotalPago = valorParcela * numeroPagamentos;

        // Calculando o valor dos juros pagos
        double jurosMensais = valorTotalPago - getValorDaCasa();

        // Dividindo os juros mensais pelo número de meses
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

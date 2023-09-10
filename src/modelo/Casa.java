package modelo;

// CRIANDO A CLASSE CASA E EXTENDENDO PARA FINANCIAMENTO
public class Casa extends Financiamento {

    private static final double descontoMaximo = 100.0;
    private double descontoPorParcela;
    private int parcelaAtual = 0;

    //MÉTODO CONSTRUTOR DA CLASSE CASA INVOCANDO O CONSTRUTOR DA CLASSE PAI
    public Casa(double valorDaCasa, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorDaCasa, prazoFinanciamento, taxaJurosAnual);
        calcularDescontoPorParcela();
    }

    //MÉTODO PARA CALCULAR O DESCONTO POR PARCELA
    private void calcularDescontoPorParcela() {
        descontoPorParcela = Math.min(super.calcularPagamentoMensal(), descontoMaximo);
    }

    //GETER PARA ATRIBUTO PRIVADO
    public double getDescontoPorParcela() {
        return descontoPorParcela;
    }

    //MÉTODO PARA CALCULAR O VALOR DA PRÓXIMA PARCELA COM DESCONTO
    public double calcularProximaParcelaComDesconto() {
        parcelaAtual = parcelaAtual + 1;
        double proximaParcela = calcularPagamentoMensal() - descontoPorParcela;
        if (proximaParcela < 0) {
            return 0;
        }
        return proximaParcela;
    }

    //OVERRIDE DE CÁLCULO DO TOTAL DE PAGAMENTO DA CLASSE PAI
    @Override
    public double calcularTotalPagamento() {
        double total = super.calcularTotalPagamento();

        // Aplicar o desconto a cada parcela
        total = total - descontoPorParcela * getPrazoFinanciamento();

        // Certificar-se de que o total não seja negativo
        if (total < 0) {
            return 0;
        }

        return total;
    }
}

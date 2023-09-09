package modelo;

public class Casa extends Financiamento {

    private static final double DESCONTO_MAXIMO = 100.0;
    private double descontoPorParcela;
    private int parcelaAtual = 0;

    public Casa(double valorDaCasa, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorDaCasa, prazoFinanciamento, taxaJurosAnual);
        calcularDescontoPorParcela();
    }

    private void calcularDescontoPorParcela() {
        descontoPorParcela = Math.min(super.calcularPagamentoMensal(), DESCONTO_MAXIMO);
    }

    public double getDescontoPorParcela() {
        return descontoPorParcela;
    }

    // Método para calcular o valor da próxima parcela com desconto
    public double calcularProximaParcelaComDesconto() {
        parcelaAtual++;
        double proximaParcela = calcularPagamentoMensal() - descontoPorParcela;
        if (proximaParcela < 0) {
            return 0;
        }
        return proximaParcela;
    }

    @Override
    public double calcularTotalPagamento() {
        double total = super.calcularTotalPagamento();

        // Aplicar o desconto a cada parcela
        total -= descontoPorParcela * getPrazoFinanciamento();

        // Certificar-se de que o total não seja negativo
        if (total < 0) {
            return 0;
        }

        return total;
    }
}

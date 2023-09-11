package modelo;

// CRIANDO A CLASSE APARTAMENTO E EXTENDENDO PARA FINANCIAMENTO
public class Apartamento extends Financiamento {
    protected int vagasGaragem;
    protected int numeroAndar;

    //MÉTODO CONSTRUTOR DA CLASSE APARTAMENTO INVOCANDO O CONSTRUTOR DA CLASSE PAI
    public Apartamento(double valorDoApartamento, int prazoFinanciamento, double taxaJurosAnual, int vagasGaragem, int numeroAndar) {
        super(valorDoApartamento, prazoFinanciamento, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
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

    //MÉTODO PARA CÁLCULO DAS PRÓXIMAS 3 PARCELAS
    public double calcularProximaParcelaComDesconto(int numeroParcela) {
        double taxaDesconto = 0.0;

        if (numeroParcela == 1) {
            taxaDesconto = 5.0;
        } else if (numeroParcela == 2) {
            taxaDesconto = 2.5;
        } else if (numeroParcela == 3) {
            taxaDesconto = 0.5;
        }

        double descontoPorParcela = calcularPagamentoMensal() * taxaDesconto / 100.0;
        double proximaParcela = calcularPagamentoMensal() - descontoPorParcela;

        return proximaParcela;
    }

    //MÉTODO PARA ATRIBUTO
    public int garagem(){
        return vagasGaragem;
    }

    //MÉTODO PARA ATRIBUTO
    public int andar(){
        return numeroAndar;
    }
}

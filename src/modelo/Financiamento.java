// IMPORTAÇÃO DE PACOTE
package modelo;
// CRIÇÃO DA CLASSE FINANCIAMENTO E SEUS ATRIBUTOS
public class Financiamento {
    private double valorDaCasa;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    //GETTER PARA ACESSAR O VALOR DO ATRIBUTO PRIVADO
    public double getValorDaCasa (){
        return valorDaCasa;
    }

    public int getPrazoFinanciamento (){
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual (){
        return taxaJurosAnual;
    }

    // METODO CONSTRUTOR DA CLASSE FINANCIAMENTO
    public Financiamento(double casa, int prazoFinanciamento, double taxaJurosAnual) {
        valorDaCasa = casa;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // METODO PARA CALCULAR PAGAMENTO MENSAL
    public double calcularPagamentoMensal() {
        double taxaMensal = (taxaJurosAnual / 12.0) / 100.0;
        int numeroPagamentos = prazoFinanciamento * 12;
        double pagamentoMensal = valorDaCasa * (taxaMensal * Math.pow(1 + taxaMensal, numeroPagamentos)) /
                (Math.pow(1 + taxaMensal, numeroPagamentos) - 1);
        return pagamentoMensal;
    }

    // METODO PARA CALCULAR PAGAMENTO TOTAL
    public double calcularTotalPagamento(){
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }

}
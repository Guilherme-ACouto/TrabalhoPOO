package modelo;

// CRIANDO A CLASSE TERRENO E EXTENDENDO PARA FINANCIAMENTO
public class Terreno extends Financiamento {

    protected String zona;

    //MÉTODO CONSTRUTOR DA CLASSE TERRENO, INVOCANDO MÉTODO CLASSE PAI
    public Terreno(double valorDoTerreno, int prazoFinanciamento, double taxaJurosAnual, String zona) {
        super(valorDoTerreno, prazoFinanciamento, taxaJurosAnual);
        this.zona = zona;
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

    //OVERRIDE DO MÉTODO PARA CÁLCULO DE TOTAL DE PAGAMENTO DA CLASSE PAI
    public double calcularAcrescimo() {

        //RECEBE O VALOR TOTAL DA CLASSE PAI
        double total = calcularTotalPagamento();

        //APLICA NO VALOR TOTAL UM ACRÉSCIMO DE 2%
        double acrescimo = total * 0.02;
        total = total + acrescimo;

        return total;
    }

    //MÉTODO PARA MOSTRAR O VALOR TOTAL SEM ACRÉSCIMO
    public double calcularTotalPagamentoSemAcrescimo() {
        return calcularTotalPagamento();
    }

    //MÉTODO PARA ATRIBUTO
    public String tipo(){
        return zona;
    }
}
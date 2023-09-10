package modelo;

// CRIANDO A CLASSE TERRENO E EXTENDENDO PARA FINANCIAMENTO
public class Terreno extends Financiamento {
    public Terreno(double valorDoTerreno, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorDoTerreno, prazoFinanciamento, taxaJurosAnual);
    }

    //OVERRIDE DO MÉTODO PARA CÁLCULO DE TOTAL DE PAGAMENTO DA CLASSE PAI
    @Override
    public double calcularTotalPagamento() {

        //RECEBE O VALOR TOTAL DA CLASSE PAI
        double total = super.calcularTotalPagamento();

        //APLICA NO VALOR TOTAL UM ACRÉSCIMO DE 2%
        double acrescimo = total * 0.02;
        total = total + acrescimo;

        return total;
    }

    //MÉTODO PARA MOSTRAR O VALOR TOTAL SEM ACRÉSCIMO
    public double calcularTotalPagamentoSemAcrescimo() {
        return super.calcularTotalPagamento();
    }
}
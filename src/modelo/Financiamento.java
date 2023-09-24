package modelo;

import java.io.Serializable;

// CRIÇÃO DA CLASSE FINANCIAMENTO E SEUS ATRIBUTOS
public abstract class Financiamento implements Serializable{
    private double valorDaCasa;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    // METODO CONSTRUTOR DA CLASSE FINANCIAMENTO
    public Financiamento(double casa, int prazoFinanciamento, double taxaJurosAnual) {
        valorDaCasa = casa;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }
    //GETTER PARA ATRIBUTO PRIVADO
    public double getValorDaCasa (){
        return valorDaCasa;
    }
    //GETTER PARA ATRIBUTO PRIVADO
    public int getPrazoFinanciamento (){
        return prazoFinanciamento;
    }
    //GETTER PARA ATRIBUTO PRIVADO
    public double getTaxaJurosAnual (){
        return taxaJurosAnual;
    }
    public void setTaxaJurosAnual(double taxaJurosAnual) {
        this.taxaJurosAnual = taxaJurosAnual;
    }
    // METODO ABSTRADO
    public abstract double calcularPagamentoMensal();

    // METODO ABSTRATO
    public abstract double calcularTotalPagamento();

    // Na classe Financiamento
    public abstract String toString();
}
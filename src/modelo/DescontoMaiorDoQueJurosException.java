package modelo;

//CRIAÇÃO DA CLASSE
public class DescontoMaiorDoQueJurosException extends Exception{

    //MÉTODO CONSTRUTOR
    public DescontoMaiorDoQueJurosException (String mensagem){
        super(mensagem); //INVOCANDO METODO DA CLASSE PAI (EXCEPTION)
    }
}

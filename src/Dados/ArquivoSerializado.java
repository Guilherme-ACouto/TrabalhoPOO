package Dados;

import modelo.Financiamento;
import java.io.*;
import java.util.ArrayList;

public class ArquivoSerializado {

    public static void salvarListaSerializada(ArrayList<Financiamento> financiamentos, String DadosArquivo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DadosArquivo))) {
            outputStream.writeObject(financiamentos);
            System.out.println("Lista serializada salva em " + DadosArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Financiamento> lerListaSerializada(String DadosArquivo) {
        ArrayList<Financiamento> lista = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DadosArquivo))) {
            lista = (ArrayList<Financiamento>) inputStream.readObject();
            System.out.println("Lista serializada lida de " + DadosArquivo);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return lista;
    }
}


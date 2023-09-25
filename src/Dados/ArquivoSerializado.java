package Dados;

import modelo.Financiamento;
import java.io.*;
import java.util.ArrayList;

public class ArquivoSerializado {

    public static void salvarListaSerializada(ArrayList<Financiamento> lista, String DadosArquivo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DadosArquivo))) {
            outputStream.writeObject(lista);
            System.out.println("Lista serializada salva com sucesso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Financiamento> lerListaSerializada(String DadosArquivo) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DadosArquivo))) {
            return (ArrayList<Financiamento>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

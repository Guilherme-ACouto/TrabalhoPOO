package Dados;

import modelo.Financiamento;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoTexto {
    public static void salvarDados(ArrayList<Financiamento> financiamentos) throws IOException {
        FileWriter out;
        try {
            out = new FileWriter("DadosFinanciamento.txt");
            for (Financiamento financiamento : financiamentos) {
                out.write(financiamento.toString() + "\n");
            }
            System.out.println("\nSua lista foi salva com sucesso");
            out.close();
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void lerDados(ArrayList<Financiamento> financiamentos) throws IOException {
        FileReader in;
        try {
            System.out.println("\n\nAbrindo leitura do arquivo:");
            in = new FileReader("DadosFinanciamento.txt");
            int c;
            while ((c = in.read()) != -1)
                System.out.print((char)c);
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
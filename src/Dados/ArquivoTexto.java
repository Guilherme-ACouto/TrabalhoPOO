package Dados;

import modelo.Financiamento;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;

public class ArquivoTexto {

    public static void salvarDadosEmArquivoTexto(ArrayList<Financiamento> financiamentos, String DadosArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DadosArquivo))) {
            for (Financiamento financiamento : financiamentos) {
                writer.write(financiamento.toString());
                writer.newLine(); // Pular para a próxima linha
            }
            System.out.println("\nDados de financiamentos salvos em " + DadosArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Financiamento> lerDadosDeArquivoTexto(String DadosArquivo) {
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(DadosArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
            }
            System.out.println("\nDados de financiamentos lidos em " + DadosArquivo);
        } catch (IOException e) {
            e.getMessage();
        }

        return financiamentos;
    }
}
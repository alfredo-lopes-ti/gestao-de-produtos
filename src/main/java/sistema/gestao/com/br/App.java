package sistema.gestao.com.br;

import java.util.Locale;
import java.util.Scanner;

import sistema.gestao.com.br.model.Produto;

/**
 * SISTEMA DE GESTÃO DE ESTOQUE E VENDAS
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   SISTEMA DE GESTÃO DE ESTOQUE E VENDAS ");
        System.out.println("=========================================");
        System.out.println(" Módulo: Controle de Produtos e Estoque  ");
        System.out.println(" Status: Em desenvolvimento (Fase POO)   ");
        System.out.println("-----------------------------------------\n");

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        Produto produto1 = new Produto(123, "Computador", "Informática", 6000.00, 25);
        Produto produto2 = new Produto(456, "Fone de ouvido", "Acessórios", 120.00);

        System.out.println("Produto: " + produto1);
        System.out.println("Produto: " + produto2);

        input.close();
    }
}

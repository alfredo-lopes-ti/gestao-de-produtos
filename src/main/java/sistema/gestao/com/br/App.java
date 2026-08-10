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
        Produto produto2 = new Produto(456, "Fone de ouvido", "Acessórios", 120.00, -10);

        Produto produto3 = new Produto(789, "Controle", "Acessórios", -134.00, -50);

        // produto1.setValor(-50.0);
        // produto2.setQuantidade(-10);

        /*
         * produto1.adicionarEstoque(5);
         * produto1.removerEstoque(10);
         * 
         * System.out.println("Produto: " + produto1);
         * System.out.println("Produto: " + produto2);
         * System.out.println("Produto: " + produto3);
         */

        int opcao;
        int id;

        do {
            // 1. Exibe o menu e lê a opção do usuário
            System.out.println("---MENU---");
            System.out.println("0. Verificar o estoque: ");
            System.out.println("1. Adicionar ao estoque: ");
            System.out.println("2. Remover do estoque: ");
            System.out.println("3. Sair");

            opcao = input.nextInt(); // Lendo o que o usuário digitou
            //id = input.nextInt(); // parâmetro para decidir sobre qual produto

            switch (opcao) {
                case 0:
                    System.out.println("\n--- ESTOQUE ATUAL ---");
                    System.out.println(produto1);
                    System.out.println(produto2);
                    System.out.println(produto3);
                    break; // interompe para não executar o próximo case

                case 1:
                    System.out.println("Enter ID of the product ");
                    id = input.nextInt();
                    if (id == 123) {
                        System.out.println("Enter the quantity to be add on the firts product: ");
                        int qtdAdd = input.nextInt();
                        produto1.adicionarEstoque(qtdAdd);
                    } else if (id == 456) {
                        System.out.println("Enter the quantity to be add on the second product: ");
                        int qtdAdd = input.nextInt();
                        produto2.adicionarEstoque(qtdAdd);
                    } else if (id == 789) {
                        System.out.println("Enter the quantity to be add on the tird product: ");
                        int qtdAdd = input.nextInt();
                        produto3.adicionarEstoque(qtdAdd);
                    } else {
                        System.out.println("Invalid number!");
                    }

                    break;

                case 2:
                    System.out.println("Enter ID of the product ");
                    id = input.nextInt();
                    if (id == 123) {
                        System.out.println("Enter the quantity to be removed on the firts product: ");
                        int qtdRem = input.nextInt();
                        produto1.removerEstoque(qtdRem);
                    } else if (id == 456) {
                        System.out.println("Enter the quantity to be removed on the second product: ");
                        int qtdRem = input.nextInt();
                        produto2.removerEstoque(qtdRem);
                    } else if (id == 789) {
                        System.out.println("Enter the quantity to be removed on the tird product: ");
                        int qtdRem = input.nextInt();
                        produto3.removerEstoque(qtdRem);
                    } else {
                        System.out.println("Invalid number!");
                    }

                    break;

                case 3:
                    System.out.println("Logging out... See you later!");
                    break;

                default:
                    System.out.println("Invalid option! try again!");
                    break;
            }

        } while (opcao != 3);

        input.close();
    }
}

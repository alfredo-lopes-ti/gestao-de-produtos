package sistema.gestao.com.br;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import sistema.gestao.com.br.model.Produto;

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

        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto(123, "Computador", "Informática", 6000.00, 25));
        produtos.add(new Produto(456, "Fone de ouvido", "Acessórios", 120.00, 10));
        produtos.add(new Produto(789, "Controle", "Acessórios", 134.00, 50));

        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("0. Verificar estoque");
            System.out.println("1. Adicionar ao estoque");
            System.out.println("2. Remover do estoque");
            System.out.println("3. Cadastrar um novo produto:");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = input.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("\n--- ESTOQUE ATUAL ---");
                    for (Produto p : produtos) {
                        System.out.println(p);
                    }
                    break;

                case 1:
                    System.out.print("Digite o ID do produto: ");
                    int idAdd = input.nextInt();

                    Produto pAdd = buscarPorId(produtos, idAdd);

                    if (pAdd != null) {
                        System.out.print("Digite a quantidade para adicionar: ");
                        pAdd.adicionarEstoque(input.nextInt());
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;

                case 2:
                    System.out.print("Digite o ID do produto: ");
                    int idRem = input.nextInt();

                    Produto pRem = buscarPorId(produtos, idRem);

                    if (pRem != null) {
                        System.out.print("Digite a quantidade para remover: ");
                        pRem.removerEstoque(input.nextInt());
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;
                case 3:
                    System.out.println("\n---Novo Produto---");
                    System.out.println("ID:");
                    int novoID = input.nextInt();
                    input.nextLine(); // Limpeza do buffer  

                    System.out.println("Nome:");
                    String novoNome = input.nextLine();

                    System.out.println("Categoria:");
                    String novaCat = input.nextLine();

                    System.out.println("Preço R$:");
                    double novoPreco = input.nextDouble();

                    System.out.println("Quantidade:");
                    int novaQtd = input.nextInt();

                    Produto novoProduto = new Produto(novoID, novoNome, novaCat, novaQtd);
                    produtos.add(novoProduto);

                case 4:
                    System.out.println("Encerrando o sistema... Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        } while (opcao != 4);

        input.close();
    }

    // Método auxiliar para buscar por ID na lista
    public static Produto buscarPorId(List<Produto> lista, int id) {
        for (Produto p : lista) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
package sistema.gestao.com.br;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.sql.Connection;

import sistema.gestao.com.br.database.ProdutoDAO;
import sistema.gestao.com.br.database.ConexaoBanco;
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

        // Conexão com o Banco de Dados
        try (Connection conn = ConexaoBanco.getConexao()) {
            if (conn != null) {
                System.out.println("Conexão com o PostgreSQL realizada com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }

        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = dao.listarTodos();

        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("0. Verificar estoque");
            System.out.println("1. Adicionar ao estoque");
            System.out.println("2. Remover do estoque");
            System.out.println("3. Cadastrar um novo produto:");
            System.out.println("4. Excluir produto:");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            try {

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

                        if (buscarPorId(produtos, novoID) != null) {
                            System.out.println("Errro: Já existe um produto cadastrado com esse ID!");
                            break;
                        }

                        input.nextLine(); // Limpeza do buffer

                        System.out.println("Nome:");
                        String novoNome = input.nextLine();

                        System.out.println("Categoria:");
                        String novaCat = input.nextLine();

                        System.out.println("Preço R$:");
                        double novoPreco = input.nextDouble();

                        System.out.println("Quantida de:");
                        int novaQtd = input.nextInt();

                        // Cria o objeto na memória
                        Produto novoProduto = new Produto(novoID, novoNome, novaCat, novoPreco, novaQtd);
                        produtos.add(novoProduto);

                        // Grava no banco de dados
                        dao.cadastrar(novoProduto);

                        System.out.println("Produto cadastrado com sucesso!");
                        break;

                    case 4:
                        System.out.println("\n---Excluir produto---");
                        System.out.println("Digite o ID do produto para ser removido:");
                        int idDel = input.nextInt();

                        Produto pDel = buscarPorId(produtos, idDel);

                        if (pDel != null) { // Remove o objeto da lista
                            produtos.remove(pDel);
                            System.out.println("Produto: '" + pDel.getNome() + "' removido com sucesso!");
                        } else {
                            System.out.println("Produto não encontrado!");
                        }
                        break;

                    case 5:
                        System.out.println("Encerrando o sistema... Até logo!");
                        break;

                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite apenas números inteiros para as opções");
                input.nextLine(); // Limpar o buffer
                opcao = -1; // Para que o laço continue rodando
            }

        } while (opcao != 5);

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
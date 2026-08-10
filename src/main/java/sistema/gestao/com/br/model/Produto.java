package sistema.gestao.com.br.model;

public class Produto {

    private int id;
    private String nome;
    private String categoria;
    private double valor;
    private int quantidade;

    public Produto(int id, String nome, String categoria, double valor, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        setValor(valor);
        setQuantidade(quantidade);
    }

    public Produto(int id, String nome, String categoria, double valor) {
        this(id, nome, categoria, valor, 0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor < 0) {
            System.out.println("Erro: O valor do produto não pode ser negativo!");
        } else {
            this.valor = valor;
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            System.out.println("Erro: A quantidade não pode ser negativa!");
        } else {
            this.quantidade = quantidade;
        }
    }

    public void adicionarEstoque(int qtd) {
        if (qtd <= 0) {
            System.out.println("Erro: Informe uma quantidade válida para adicionar!");
        } else {
            setQuantidade(this.quantidade + qtd);
        }
    }

    public void removerEstoque(int qtd) {
        if (qtd <= 0) {
            System.out.println("Erro: Informe uma quantidade válida para remover!");
        } else if (qtd > this.quantidade) {
            System.out.println("Erro: Estoque insuficiente para esta operação!");
        } else {
            setQuantidade(this.quantidade - qtd);
        }
    }

    @Override
    public String toString() {
        return "Produto [ID: " + id
                + " | Nome: " + nome
                + " | Categoria: " + categoria
                + " | Preço: R$ " + String.format("%.2f", valor)
                + " | Quantidade: " + quantidade + "]";
    }
}
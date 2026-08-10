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
        setValor(valor); // usando a validação do setValor
        setQuantidade(quantidade); // usando a validação do setQuantidade
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
            System.out.println("Error: The product value cannot be negative!");
        } else {
            this.valor = valor;
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            System.out.println("Error: The quantity value cannot be negative!");
        } else {
            this.quantidade = quantidade;
        }
    }

    public void adicionarEstoque(int qtd) {
        if (qtd <= 0) {
            System.out.println("Error: Enter a valid quantity to add!: ");
        } else {
            this.quantidade += qtd; // Soma ao estoque atual
        }
    }

    public void removerEstoque(int qtd) {
        if (qtd <= 0) {
            System.out.println("Error: Enter a valid quantity to remove!: ");
        } else if (qtd > this.quantidade){
            System.out.println("Error: Insufficient stock for this operation! ");
        } else {
            this.quantidade -= qtd; // Subtrai do estoque atual
        }
    }

    @Override
    public String toString() {
        return "Produto [ID: " + id
                + " | Nome: " + nome
                + " | Categoria: " + categoria
                + " | Preço: " + valor
                + " | Quantidade: " + quantidade + "]";
    }

}

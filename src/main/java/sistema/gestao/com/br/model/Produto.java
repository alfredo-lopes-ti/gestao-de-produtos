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
        this.valor = valor;
        this.quantidade = quantidade;
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
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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

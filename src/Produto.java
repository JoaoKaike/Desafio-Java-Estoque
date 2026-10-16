import java.text.NumberFormat;
import java.util.Locale;

public class Produto {

    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.preco = preco;
        this.nome = nome;
        this.quantidade = quantidade;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double calcularValorEmEstoque() {
        return preco * quantidade;
    }

    @Override
    public String toString() {
        NumberFormat moeda =
                NumberFormat.getCurrencyInstance(
                        new Locale("pt", "BR")
                );

        return "produto: " + nome
                + " | `Preço: " + moeda.format(preco)
                + " | Quantidade: " + quantidade
                + " | Valor em estoque: "
                + moeda.format(calcularValorEmEstoque());
    }

}


import java.util.ArrayList;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class CadastrarProduto {

    public static void main(String[] args) {

        Scanner adicionar = new Scanner(System.in);

        ArrayList<Produto> listaDeProdutos = new ArrayList<>();

        NumberFormat moeda =
                NumberFormat.getCurrencyInstance(
                        Locale.forLanguageTag("pt-BR")
                );

        System.out.println("--- SISTEMA DE CADASTRO DE PRODUTOS ---");

        while (true) {


            String nome;

            while (true) {

                System.out.print(
                        "\nDigite o nome do produto "
                                + "(ou 'sair' para encerrar): "
                );

                nome = adicionar.nextLine().trim();

                if (nome.equalsIgnoreCase("sair")) {
                    break;
                } else if (nome.isEmpty()) {
                    System.out.println(
                            "O nome não pode ficar vazio."
                    );
                    continue;
                } else if (!nome.matches(".*\\p{L}.*")) {
                    System.out.println(
                            "O nome deve conter pelo menos uma letra."
                    );
                    continue;
                } else {
                    break;
                }
            }

            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            double preco;

            while (true) {

                System.out.print("Digite o preço unitário: R$ ");

                try {
                    preco = Double.parseDouble(
                            adicionar.nextLine()
                                    .trim()
                                    .replace(",", ".")
                    );

                    if (preco > 0 && Double.isFinite(preco)) {
                        break;
                    }

                    System.out.println(
                            "O preço deve ser maior que zero."
                    );

                } catch (NumberFormatException e) {
                    System.out.println(
                            "Preço inválido. Digite um número válido."
                    );
                }
            }

            int quantidade;

            while (true) {

                System.out.print("Digite a quantidade em estoque: ");

                try {
                    quantidade = Integer.parseInt(
                            adicionar.nextLine().trim()
                    );

                    if (quantidade >= 0) {
                        break;
                    }

                    System.out.println(
                            "A quantidade não pode ser negativa."
                    );

                } catch (NumberFormatException e) {
                    System.out.println(
                            "Quantidade inválida. Digite um número inteiro."
                    );
                }
            }

            Produto novoProduto =
                    new Produto(nome, preco, quantidade);

            listaDeProdutos.add(novoProduto);

            System.out.println(
                    "Produto '" + nome
                            + "' cadastrado com sucesso!"
            );

            System.out.println("\n=== RESUMO DO ESTOQUE ===");

            if (listaDeProdutos.isEmpty()) {

                System.out.println("Nenhum produto foi cadastrado.");

            } else {

                double valorTotalEstoque = 0;

                for (Produto produto : listaDeProdutos) {

                    System.out.println(produto);

                    valorTotalEstoque +=
                            produto.calcularValorEmEstoque();
                }

                System.out.println("----------------------------------------");
                System.out.println(
                        "Quantidade de produtos cadastrados: "
                                + listaDeProdutos.size()
                );
                System.out.println(
                        "Valor total do estoque: "
                                + moeda.format(valorTotalEstoque)
                );
            }

            System.out.println("\nSistema encerrado. Obrigado!");
        }

    }
}





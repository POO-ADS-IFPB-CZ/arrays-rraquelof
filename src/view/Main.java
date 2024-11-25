package view;

import model.Categoria;
import model.Item;
import model.Produto;
import model.Venda;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto produto1 = new Produto(101, "Arroz Branco 1kg", 5.20, Categoria.ALIMENTICIO);
        Produto produto2 = new Produto(203, "Creme Dental", 4.70, Categoria.HIGIENE);
        Produto produto3 = new Produto(303, "Detergente", 2.50, Categoria.LIMPEZA);

        Item item = new Item(55, produto1, 50);
        Venda venda = new Venda();
        int opcao;
        do {
            System.out.println("\n=== Sistema de Vendas ===");
            System.out.println("1. Listar Produtos");
            System.out.println("2. Adicionar Item à Venda");
            System.out.println("3. Ver Itens da Venda");
            System.out.println("4. Ver Total da Venda");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\nProdutos Disponíveis:");
                    System.out.println("1. " + produto1.getDescricao() + " - R$" + produto1.preco);
                    System.out.println("2. " + produto2.getDescricao() + " - R$" + produto2.preco);
                    System.out.println("3. " + produto3.getDescricao() + " - R$" + produto3.preco);
                    break;
                case 2:
                    System.out.println("\nAdicionar Item à Venda");
                    System.out.println("1. " + produto1.getDescricao() + " - R$" + produto1.preco);
                    System.out.println("2. " + produto2.getDescricao() + " - R$" + produto2.preco);
                    System.out.println("3. " + produto3.getDescricao() + " - R$" + produto3.preco);

                    System.out.print("Escolha o produto (1, 2 ou 3): ");
                    int escolha = scanner.nextInt();
                    Produto produtoEscolhido = null;

                    if (escolha == 1) {
                        produtoEscolhido = produto1;
                    }else if (escolha == 2) {
                        produtoEscolhido = produto2;
                    }else if (escolha == 3){
                        produtoEscolhido = produto3;
                    }else {
                        System.out.println("Produto inválido!");
                        break;
                    }
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();

                    if (quantidade <= 0) {
                        System.out.println("Quantidade inválida!");
                        break;
                    }

                    Item novoItem = new Item(venda.getItens().length + 1, produtoEscolhido, quantidade);
                    venda.adicionarItem(novoItem);

                    System.out.println("Item adicionado à venda!");
                    break;
                case 3:
                    System.out.println("\nItens da Venda:");
                    Item[] itensVenda = venda.getItens();
                    if (itensVenda.length == 0) {
                        System.out.println("Nenhum item adicionado à venda.");
                    } else {
                        for (Item itemVenda : itensVenda) {
                            System.out.println(itemVenda);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Total da venda");
                    System.out.println("R$"+venda.getTotal());
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);

    }
}
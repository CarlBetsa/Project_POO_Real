package br.inatel.projeto;

import br.inatel.projeto.produto.AguaPLencois;
import br.inatel.projeto.produto.Produto;
import br.inatel.projeto.produto.Sabonetes;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Produto produto1 = new Sabonetes( "Bergamota", 20.00f);
        Produto produto2 = new AguaPLencois( "Confort home", 32.00f);
        Path caminho = Paths.get("Produtos.txt");
        Scanner sc = new Scanner(System.in);
        Arquivo arq = new Arquivo();

        arq.insertProduto(caminho, produto1);
        arq.insertProduto(caminho, produto2);

        Produto produto3 = new Sabonetes( "Limão", 17.00f);
        arq.insertProduto(caminho, produto3);

        ArrayList<Produto> produtos = arq.buscar();

        System.out.println("Entre com o id do produto que deseja atualizar");
        produto1.setId(sc.nextInt());
        sc.nextLine();
        System.out.println("Entre com o novo nome do produto");
        produto1.setNome(sc.nextLine());
        System.out.println("Entre com o novo preço do produto");
        produto1.setPreco(sc.nextFloat());
        produtos.set(produto1.getId()-1, produto1);
        arq.limpaArquivo(caminho);
        for (int i = 0; i < produtos.size(); i++) {
            arq.insertProduto(caminho, produtos.get(i));
        }

        System.out.println("Entre com o id do produto que deseja remover");
        int id = sc.nextInt();
        produtos.remove(id-1);
        arq.limpaArquivo(caminho);
        for (int i = 0; i < produtos.size(); i++) {
            produtos.get(i).setId(i+1);
            arq.insertProduto(caminho, produtos.get(i));
        }


    }

}

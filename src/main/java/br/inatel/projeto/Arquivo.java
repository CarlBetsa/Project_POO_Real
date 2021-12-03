package br.inatel.projeto;

import br.inatel.projeto.produto.AguaPLencois;
import br.inatel.projeto.produto.Produto;
import br.inatel.projeto.produto.Sabonetes;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {

    public void insertProduto(Path caminho, Produto produto){
        try {
            if (produto instanceof Sabonetes)
                Files.writeString(caminho,
                        "----------Sabonetes----------\n",
                        StandardOpenOption.APPEND);
            else if (produto instanceof AguaPLencois)
                Files.writeString(caminho,
                        "----------Agua p/ lencois----------\n",
                        StandardOpenOption.APPEND);
            Files.writeString(caminho,
                    produto.getId() + "\n" + produto.getNome() +"\n" + produto.getPreco() +"\n",
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Produto> buscar(){
        InputStream is;
        InputStreamReader isr;
        BufferedReader br = null;
        ArrayList<Produto> produtos = new ArrayList<>();

        try{
            is = new FileInputStream("Produtos.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            String linha = br.readLine();
            while(linha != null){
                if(linha.contains("-Sabonetes-")){
                    Sabonetes sAux = new Sabonetes();
                    sAux.setId(Integer.parseInt(br.readLine()));
                    sAux.setNome(br.readLine());
                    sAux.setPreco(Float.parseFloat(br.readLine()));
                    produtos.add(sAux);
                }else if(linha.contains("-Agua p/ lencois-")){
                    AguaPLencois aAux = new AguaPLencois();
                    aAux.setId(Integer.parseInt(br.readLine()));
                    aAux.setNome(br.readLine());
                    aAux.setPreco(Float.parseFloat(br.readLine()));
                    produtos.add(aAux);
                }
                linha = br.readLine();
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
        finally{
            try{
                br.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        System.out.println(" ");
        for (int i=0; i<produtos.size(); i++){
            if (produtos.get(i) instanceof Sabonetes)
                System.out.println("----------Sabonete----------");
            else System.out.println("----------Agua p/ lencois----------");

            System.out.println("Id: " + produtos.get(i).getId());
            System.out.println("Nome: " + produtos.get(i).getNome());
            System.out.println("Preço: " + produtos.get(i).getPreco());
        }
        return produtos;
    }

    public void limpaArquivo(Path caminho){
        OutputStream op;
        OutputStreamWriter osw;
        BufferedWriter bw;
        try {
            op = new FileOutputStream("Produtos.txt", false);
            osw = new OutputStreamWriter(op);
            bw = new BufferedWriter(osw);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

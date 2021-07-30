package programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import classe.Produto;
import classe.Venda;
public class App {
    public static void main(String[] args) throws Exception {
        int val, qi = 0;
        List<Produto> produtos = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        System.out.println("**************\nProdutos & Cia\n**************");
        System.out.println("1 – Adicionar Produto");
        System.out.println("2 – Consultar produto");
        System.out.println("3 – Listagem de produtos");
        System.out.println("4 – Vendas por período");
        System.out.println("5 – Realizar venda");
        System.out.println("0 - Sair");
        System.out.println("Escolha: ");
        val = in.nextInt();
        


    if (val == 1) {
        Produto p = new Produto();

        System.out.print("Nome: ");
        p.setNome(in.nextLine());

        System.out.print("Código: ");
        p.setCodigo(in.nextLine());

       
        System.out.print("Valor: ");
        p.setValor(in.nextDouble());
        
        produtos.add(p);
        qi++;

        System.out.println("\nProduto cadastrado com sucesso.");  
    }else if (val == 2) {
        if (qi == 0) {
            System.out.println("\nNão há produtos cadastrados para exibir.");
        }
        System.out.println("Informe o código do produto ");
        String c = in.nextLine();
        Produto cod = null;
        for (Produto produto : produtos) {
            if (c.equals(produtos.getcodigo())) {
            cod = produtos;
        }
    }
       
        
        
    }else if (val == 3) {
        System.out.println("Lista de Produtos\n*****************");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }else if (val == 4) {
        
    }else if (val == 5) {
       if (qi == 0) {
           System.out.println("não há produtos para venda");
       } 
       
       System.out.println("Me informe o código do produto: ");
    }
            
     in.close();   
    }
}

package programa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import classe.Produto;
import classe.Venda;
    public class App{
    public static void main(String[] args) throws InterruptedException, IOException {
        int opcao, qtdCadastrados = 0;
        int qtdVendidos = 0;
        int vava = 0;
        List<Produto> produtos = new ArrayList<>();
        List<Venda> vendas = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        do { 
            
            System.out.println("**************\nProdutos & Cia\n**************");
            System.out.println("1 – Adicionar Produto");
            System.out.println("2 – Consultar produto");
            System.out.println("3 – Listagem de produtos");
            System.out.println("4 – Vendas por período");
            System.out.println("5 – Realizar venda");
            System.out.println("0 - Sair");
            System.out.println("Escolha: ");
            opcao = in.nextInt();
            in.nextLine();

            if (opcao == 1) {
            

                Produto mot = new Produto();

                System.out.print("Insira o nome do produto: ");
                mot.setNome(in.nextLine());

                System.out.print("Insira o código do produto: ");
                mot.setCodigo(in.nextLine());

                
                System.out.print("Insira um valor para o produto: ");
                mot.setValor(in.nextDouble());

                produtos.add(mot);
                qtdCadastrados ++;
                System.out.println("\nMotorista cadastrado com sucesso.");
                voltarMenu(in);
            }else if (opcao == 2) {
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há produtos cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

                System.out.print("\nCódigo para buscar: ");
                String cod = in.nextLine();
                Produto proBusca = null;
                for (Produto produto : produtos) {
                    if (cod.equals(produto.getCodigo())) {
                        proBusca = produto;
                        break;
                    }
                }

                if (proBusca == null) {
                    System.out.println("Código não encontrado!");
                } else {
                    System.out.println("Produto localizado:");
                    exibirProduto(proBusca);
                }

                voltarMenu(in);
            }else if (opcao == 3) {
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há produtos cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

                System.out.println("\nPRODUTOS CADASTRADOS:");
                System.out.println("***********************");
                for (Produto produto : produtos) {
                    System.out.println(produto.getCodigo());
                    System.out.println(produto.getNome());
                    System.out.println(produto.getValor());
                }

                voltarMenu(in);
            }else if (opcao == 4) {
                if (qtdVendidos == 0) {
                    System.out.println("\nNão há vendas cadastradas para exibir.");
                    voltarMenu(in);
                    continue;
                }
                System.out.println("informe a data");
                String date = in.nextLine();
                System.out.println("\nVENDAS POR PERÍODO:");
                System.out.println("*********************");
                System.out.printf("Emitido em %s\n", date);
                for (Venda venda : vendas) {
                    System.out.printf(" %s",venda.getDatv());
                    System.out.printf(" %s",venda.getProdv());
                    System.out.printf(" %s",venda.getQtvendi());
                    System.out.printf(" %s", venda.getValu());
                    voltarMenu(in);
                }
                voltarMenu(in);
            }else if (opcao == 5){
                if (qtdCadastrados == 0) {
                    System.out.println("\nNÃO HÁ ITENS A VENDA:");
                    System.out.println("***********************");
                    voltarMenu(in);
                    continue;
                }

                System.out.println("Informe o codigo do produto: ");
                String cdo = in.nextLine();
                
                Produto produtoEncontrado = null;
                for (Produto produto : produtos) {
                    if (cdo.equals(produto.getCodigo())) {
                        produtoEncontrado = produto;
                    }if (produto.equals(null)) {
                    System.out.println("produto não encontrado!");
                    break;
                    }
                }    
                    System.out.printf("O resultado de sua compra deu: %s",produtoEncontrado.getValor());
                    System.out.print("\nDeseja efetuar a venda? ");
                    String r = in.nextLine();
                    
                    if (r.equals("s") || r.equals("S")){
                        Venda da = new Venda();
                        System.out.print("Me informe a data da venda: ");
                        da.setDatv(in.nextLine());
                        da.setProdv(produtoEncontrado.getNome());
                        da.setValu(produtoEncontrado.getValor());
                        vava ++;
                        da.setQtvendi(vava);
                        vendas.add(da);
                        produtos.remove(produtoEncontrado);
                        qtdCadastrados --;
                        qtdVendidos ++;
                        System.out.print("Compra efetuada com sucesso!");
                        voltarMenu(in);
                        }else if (r.equals("n") || r.equals("N")) {
                        System.out.println("Cancelamento efetuado com sucesso!");
                        voltarMenu(in);
                    }else {
                        System.out.println("Caractere errado!\n");
                        System.out.println("Cancelamento efetuado");
                        voltarMenu(in);
                    }
                    

                       
                
            }
                
            
        
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }
    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

       
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");

        System.out.flush();
    }    
    private static void exibirProduto(Produto produto) {
        System.out.printf("\nProduto: %s\n", produto.getNome());
        System.out.printf("Código: %s\n", produto.getCodigo());
        System.out.printf("Valor: %s\n", produto.getValor());
    }
}


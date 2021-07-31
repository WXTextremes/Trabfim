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
            System.out.print("Opção: ");
            

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
                    System.out.println(produto);
                }

                voltarMenu(in);
            }else if (opcao == 4) {
                if (qtdVendidos == 0) {
                    System.out.println("\nNão há vendas cadastradas para exibir.");
                    voltarMenu(in);
                    continue;
                }
                System.out.println("\nVENDAS POR PERÍODO:");
                System.out.println("*********************");
                for (Venda venda : vendas) {
                    System.out.println(venda);
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
                Produto provend = null;
                for (Produto produto : produtos) {
                    if (cdo.equals(produto.getCodigo())) {
                        provend = produto;
                        break;
                    }
                    System.out.println("Informe a quantidade de itens que queira comprar: ");
                        Double qt = in.nextDouble();
                        Double v = provend.getValor();
                        Double vt = qt * v;
                    System.out.printf("O resultado de sua compra deu: %d", vt);
                    System.out.print("Deseja efetuar a venda? ");
                    String r = in.nextLine();
                    if (r.equals("s")){
                        produtos.remove(produto);
                        System.out.print("Compra efetuada com sucesso!");

                    }else if (r.equals("n")) {
                        System.out.println("Cancelamento efetuado com sucesso!");

                    }


                       
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


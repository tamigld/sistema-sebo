import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Livro> listaLivros = new ArrayList<>();

        System.out.print("Bem vindo ao sistema de Sebo!");

        Scanner scanner = new Scanner(System.in);

        int opcao;

        do{
            System.out.println("Escolha uma opção: \n 1 - Cadastrar livro \n 2 - Listar livros \n 0 - Sair");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    Livro novoLivro = new Livro();
                    Autor novoAutor = new Autor();

                    System.out.print("Digite o nome do livro que deseja cadastrar: ");
                    novoLivro.titulo = scanner.next();

                    System.out.print("Digite o autor do livro que deseja cadastrar: ");
                    novoAutor.nome = scanner.next();

                    System.out.print("Digite o local de nascimento do autor: ");
                    novoAutor.localNasc = scanner.next();

                    System.out.print("Digite o preço do livro: ");
                    novoLivro.preco = scanner.nextFloat();

                    System.out.print("Digite a data de lançamento do livro: ");
                    LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyy"));
                    Period periodo = Period.between(date, LocalDate.now());

                    novoLivro.dataLancamento = date;

                    if(periodo.getYears() > 5){
                        System.out.println("O livro tem mais de cinco anos de lançamento.");
                    } else{
                        System.out.println("O livro tem menos de cinco anos de lançamento. \nVoltando ao menu anterior");
                        break;
                    }

                    listaLivros.add(novoLivro);

                    System.out.println("Livro cadastrado com sucesso!");
                    break;

                case 2:
                    if (listaLivros.isEmpty()) {
                        System.out.println("Lista vazia.\n Voltando ao menu anterior.");
                    } else {
                        for(Livro cadaLivro : listaLivros){
                            System.out.println();
                            System.out.print("Título do livro: " + cadaLivro.titulo);
                            System.out.print("Autor: " + cadaLivro.autor);
                            System.out.print("Preço: " + cadaLivro.preco);
                            System.out.print("Data de lançamento: " + cadaLivro.dataLancamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                            System.out.println();
                        }
                    }

                    System.out.print("Fim da lista.");
                    break;

                case 0:
                    System.out.print("Obrigado por usar o nosso sistema de Sebo!");
                    break;

                default:
                    System.out.print("A opção " + opcao + " não é válida! \n Digite uma opção válida.");
                    break;
            }
        } while (opcao != 0);
    }
}
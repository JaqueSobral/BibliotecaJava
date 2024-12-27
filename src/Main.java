import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                Biblioteca biblioteca = new Biblioteca();
                Scanner scanner = new Scanner(System.in);

                while (true) {
                        System.out.println("\n--- Biblioteca Js ---");
                        System.out.println("1. Cadastrar Livro");
                        System.out.println("2. Cadastrar Usuário");
                        System.out.println("3. Realizar Empréstimo");
                        System.out.println("4. Realizar Devolução");
                        System.out.println("5. Exibir Livros Disponíveis");
                        System.out.println("6. Sair");
                        System.out.println("\n--- Escolha alguma opção para começar ---");

                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao) {
                                case 1:
                                        System.out.print("Digite o título do livro: ");
                                        String titulo = scanner.nextLine();
                                        System.out.print("Digite o autor do livro: ");
                                        String autor = scanner.nextLine();
                                        System.out.print("Digite o ISBN do livro: ");
                                        String isbn = scanner.nextLine();
                                        biblioteca.cadastrarLivro(new Livro(titulo, autor, isbn));
                                        break;

                                case 2:
                                        System.out.print("Digite o nome do usuário: ");
                                        String nome = scanner.nextLine();
                                        System.out.print("Digite o ID do usuário: ");
                                        int id = scanner.nextInt();
                                        biblioteca.cadastrarUsuario(new Usuario(nome, id));
                                        break;

                                case 3:
                                        System.out.print("Digite as informações do livro que será emprestado: ");
                                        scanner.nextLine();
                                        System.out.print("Digite o ISBN do livro: ");
                                        String isbnEmprestimo = scanner.nextLine();
                                        System.out.print("Digite o ID do usuário: ");
                                        int idUsuarioEmprestimo = scanner.nextInt();
                                        biblioteca.realizarEmprestimo(isbnEmprestimo, idUsuarioEmprestimo);
                                        break;

                                case 4:
                                        System.out.print("Digite as informações do livro que será devolvido: ");
                                        System.out.print("Digite ISBN do livro: ");
                                        String isbnDevolucao = scanner.nextLine();
                                        System.out.print("Digite o ID do usuário: ");
                                        int idUsuarioDevolucao = scanner.nextInt();
                                        biblioteca.realizarDevolucao(isbnDevolucao, idUsuarioDevolucao);
                                        break;

                                case 5:
                                        biblioteca.exibirLivrosDisponiveis();
                                        break;

                                case 6:
                                        System.out.println("Saindo do sistema...");
                                        scanner.close();
                                        return;

                                default:
                                        System.out.println("Opção inválida. Tente novamente.");
                        }
                }
        }
}

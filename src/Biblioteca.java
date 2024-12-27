import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso.");
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso.");
    }

    public void realizarEmprestimo(String isbn, int idUsuario) {
        Livro livro = buscarLivroPorIsbn(isbn);
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        if (livro == null) {
            System.out.println("Livro com ISBN " + isbn + " não encontrado.");
            return;
        }
        if (usuario == null) {
            System.out.println("Usuário com ID " + idUsuario + " não encontrado.");
            return;
        }
        try {
            livro.emprestar();
            usuario.adicionarLivro(livro);
            System.out.println("Empréstimo realizado com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao realizar empréstimo: " + e.getMessage());
        }
    }

    public void realizarDevolucao(String isbn, int idUsuario) {
        Livro livro = buscarLivroPorIsbn(isbn);
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        if (livro == null) {
            System.out.println("Livro com ISBN " + isbn + " não encontrado.");
            return;
        }
        if (usuario == null) {
            System.out.println("Usuário com ID " + idUsuario + " não encontrado.");
            return;
        }
        try {
            usuario.removerLivro(livro);
            livro.devolver();
            System.out.println("Devolução realizada com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao realizar devolução: " + e.getMessage());
        }
    }

    public void exibirLivrosDisponiveis() {
        System.out.println("Livros disponíveis:");
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                livro.exibirDetalhes();
                System.out.println();
            }
        }
    }

    private Livro buscarLivroPorIsbn(String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        return null;
    }

    private Usuario buscarUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
}

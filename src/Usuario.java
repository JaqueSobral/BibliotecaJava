import java.util.ArrayList;

class Usuario implements Estoque {
    protected String nome;
    private int id;
    private ArrayList<Livro> livrosEmprestados;

    public Usuario(String nome, int id) {
        this.nome = nome;
        this.id = id;
        this.livrosEmprestados = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("ID: " + id);
        System.out.println("Livros emprestados: " + livrosEmprestados.size());
    }

    public void adicionarLivro(Livro livro) {
        if (livrosEmprestados.size() < 3) {
            livrosEmprestados.add(livro);
        } else {
            throw new IllegalStateException("Usuário já atingiu o limite de 3 livros emprestados.");
        }
    }

    public void removerLivro(Livro livro) {
        if (!livrosEmprestados.remove(livro)) {
            throw new IllegalArgumentException("Livro não encontrado na lista de empréstimos.");
        }
    }

    public ArrayList<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }
}
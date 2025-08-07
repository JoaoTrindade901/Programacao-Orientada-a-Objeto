class Livro {
    
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private double preco;
    private boolean disponivel;

    public Livro(String titulo, String autor, int anoPublicacao, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.preco = preco;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public double getPreco() {
        return preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setTitulo(String titulo) {
            this.titulo = titulo;
    }

    public void setPreco(double preco) {
            this.preco = preco;

    }

    public void emprestar() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Livro '" + titulo + "' emprestado com sucesso!");
        } else {
            System.out.println("Livro '" + titulo + "' não está disponível.");
        }
    }

    public void devolver() {
        disponivel = true;
        System.out.println("Livro '" + titulo + "' devolvido com sucesso!");
    }

    public int obterIdade(int anoAtual) {
        return anoAtual - anoPublicacao;
    }

    public void aplicarDesconto(double percentual) {
        if (percentual > 0 && percentual <= 100) {
            preco = preco * (1 - percentual / 100);
            System.out.println("Desconto aplicado! Novo preço: R$ " + preco);
        }
    }
}

class Biblioteca {

    private Livro[] livros;
    private int quantidadeLivros;
    private static final int CAPACIDADE_MAXIMA = 10;

    public Biblioteca() {
        livros = new Livro[CAPACIDADE_MAXIMA];
        quantidadeLivros = 0;
    }

    public boolean adicionarLivro(Livro livro) {
        if (quantidadeLivros < CAPACIDADE_MAXIMA && livro != null) {
            livros[quantidadeLivros] = livro;
            quantidadeLivros++;
            System.out.println("Livro '" + livro.getTitulo() + "' adicionado à biblioteca!");
            return true;
        } else {
            System.out.println("Não foi possível adicionar o livro. Biblioteca cheia ou livro inválido.");
            return false;
        }
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        for (int i = 0; i < quantidadeLivros; i++) {
            if (livros[i].getTitulo().equalsIgnoreCase(titulo)) {
                return livros[i];
            }
        }
        return null;
    }

    public void listarLivrosDisponiveis() {
        System.out.println("=== LIVROS DISPONÍVEIS ===");
        boolean encontrouDisponivel = false;
        for (int i = 0; i < quantidadeLivros; i++) {
            if (livros[i].isDisponivel()) {
                System.out.println("- " + livros[i].getTitulo() +
                        " por " + livros[i].getAutor() +
                        " (R$ " + livros[i].getPreco() + ")");
                encontrouDisponivel = true;
            }
        }

        if (!encontrouDisponivel) {
            System.out.println("Nenhum livro disponível no momento.");
        }
    }

    public double calcularValorTotal() {
        double valorTotal = 0.0;
        for (int i = 0; i < quantidadeLivros; i++) {
            valorTotal += livros[i].getPreco();
        }
        return valorTotal;
    }

    public int getQuantidadeLivros() {
        return quantidadeLivros;
    }
}

public class Main {
    public static void main(String[] args) {
        Livro l1 = new Livro("Dom Casmurro", "Machado de Assis", 1899, 39.90);
        Livro l2 = new Livro("1984", "George Orwell", 1949, 49.90);
        Livro l3 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954, 89.99);
        Livro l4 = new Livro("A Revolução dos Bichos", "George Orwell", 1945, 29.50);
        Livro l5 = new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943, 25.00);
        Livro l6 = new Livro("Capitães da Areia", "Jorge Amado", 1937, 34.90);
        Livro l7 = new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", 1997, 45.00);
        Livro l8 = new Livro("O Código Da Vinci", "Dan Brown", 2003, 54.90);
        Livro l9 = new Livro("It: A Coisa", "Stephen King", 1986, 67.80);
        Livro l10 = new Livro("O Alquimista", "Paulo Coelho", 1988, 29.90);

        System.out.println(l1.getAutor() +' ' + l1.getTitulo()+ ' ' + l1.getAnoPublicacao() + ' ' + l1.getPreco() + ' ' + l1.isDisponivel());
    }

}

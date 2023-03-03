
package LivrosExemplar;

import java.util.List;

public class Livro {
    private Long id;
    private String titulo;
    private String autor;
    private String editora;
    private int anoPublicacao;

    // getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    int getQuantidadeExemplares() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    void setExemplares(List<Exemplar> exemplares) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}

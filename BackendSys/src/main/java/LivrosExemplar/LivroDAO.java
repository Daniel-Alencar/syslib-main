
package LivrosExemplar;

import java.sql.PreparedStatement;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


public class LivroDAO {
    private final String INSERT = "INSERT INTO livros (titulo, autor, editora, ano_publicacao) VALUES (?, ?, ?, ?)";
    private final String UPDATE = "UPDATE livros SET titulo = ?, autor = ?, editora = ?, ano_publicacao = ? WHERE id = ?";
    private final String DELETE = "DELETE FROM livros WHERE id = ?";
    private final String SELECT_BY_ID = "SELECT * FROM livros WHERE id = ?";
    private final String SELECT_ALL = "SELECT * FROM livros";
    private final String SELECT_BY_TITULO = "SELECT * FROM livros WHERE titulo = ?";

    private JdbcTemplate jdbcTemplate;
    private ExemplarDAO exemplarDAO;

    public LivroDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.exemplarDAO = new ExemplarDAO(dataSource);
    }

    public void criar(Livro livro) {
        PreparedStatementCreator preparedStatementCreator = (var connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT, new String[]{"id"});
            preparedStatement.setString(1, livro.getTitulo());
            preparedStatement.setString(2, livro.getAutor());
            preparedStatement.setString(3, livro.getEditora());
            preparedStatement.setInt(4, livro.getAnoPublicacao());
            return preparedStatement;
        };

        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(preparedStatementCreator, keyHolder);
            Long id = keyHolder.getKey().longValue();
            livro.setId(id);

            // cria exemplares associados ao livro
            for (int i = 0; i < livro.getQuantidadeExemplares(); i++) {
                Exemplar exemplar = new Exemplar();
                exemplar.setLivro(livro);
                exemplar.setDisponivel(true);
                exemplarDAO.criar(exemplar);
            }

        } catch (DataAccessException exception) {
            System.out.println("Erro ao criar livro: " + exception.getMessage());
        }
    }

    public void atualizar(Livro livro) {
        jdbcTemplate.update(UPDATE, livro.getTitulo(), livro.getAutor(), livro.getEditora(),
                livro.getAnoPublicacao(), livro.getId());
    }

    public void deletar(Long id) {
        jdbcTemplate.update(DELETE, id);
    }

    public Livro buscarPorId(Long id) {
        try {
            Livro livro = jdbcTemplate.queryForObject(SELECT_BY_ID, new LivroRowMapper(), id);
            if (livro != null) {
                // carrega exemplares associados ao livro
                List<Exemplar> exemplares = exemplarDAO.buscarPorLivro(livro);
                livro.setExemplares(exemplares);
        }
        return livro;
    } catch (EmptyResultDataAccessException exception) {
        System.out.println("Livro não encontrado: " + exception.getMessage());
        return null;
    }
}

    public List<Livro> buscarTodos() {
        List<Livro> livros = jdbcTemplate.query(SELECT_ALL, new LivroRowMapper());
        for (Livro livro : livros) {
            List<Exemplar> exemplares = exemplarDAO.buscarPorLivro(livro);
            livro.setExemplares(exemplares);
        }
        return livros;
    }

    public List<Livro> buscarPorTitulo(String titulo) {
        List<Livro> livros = jdbcTemplate.query(SELECT_BY_TITULO, new LivroRowMapper(), titulo);
        for (Livro livro : livros) {
            List<Exemplar> exemplares = exemplarDAO.buscarPorLivro(livro);
            livro.setExemplares(exemplares);
        }
        return livros;
    }
}

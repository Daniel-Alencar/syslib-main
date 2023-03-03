
package LivrosExemplar;

import Usuarios.TipoUsuario;
import Usuarios.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class ExemplarDAO {
    private final String INSERT = "INSERT INTO exemplares (livro_id, edicao, numeroexemplar, disponivel) VALUES (?, ?, ?, ?, ?)";
    private final String UPDATE = "UPDATE exemplares SET livro_id = ?, edicao = ?, numero_exemplar = ?, disponivel = ? WHERE id = ?";
    private final String DELETE = "DELETE FROM exemplares WHERE id = ?";
    private final String SELECT_BY_ID = "SELECT * FROM exemplares WHERE id = ?";
    private final String SELECT_ALL = "SELECT * FROM exemplares";

    private JdbcTemplate jdbcTemplate;

    public ExemplarDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void criar(Livro livro, Usuario usuario) throws LivroJaCadastradoException, PermissaoNegadaException {
    if (usuario.getTipoUsuario() != TipoUsuario.BIBLIOTECARIO || !usuario.getPermissaoBibliotecario().isPodeAdicionarLivros()) {
        throw new PermissaoNegadaException("Usuário não tem permissão para adicionar livros.");
        PreparedStatementCreator preparedStatementCreator = (var connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT, new String[]{"id"});
            preparedStatement.setLong(1, exemplar.getLivro().getId());
            preparedStatement.setInt(2, exemplar.getEdicao());
            preparedStatement.setInt(3, exemplar.getNumeroExemplar());
            preparedStatement.setBoolean(1, exemplar.isDisponivel());
            return preparedStatement;
        };
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(preparedStatementCreator, keyHolder);
            Long id = keyHolder.getKey().longValue();
            exemplar.setId(id);
        } catch (DataAccessException exception) {
            System.out.println("Erro ao criar exemplar: " + exception.getMessage());
        }
    }
 
    public void atualizar(Exemplar exemplar) {
        jdbcTemplate.update(UPDATE, exemplar.getLivro().getId(), exemplar.isDisponivel(), exemplar.getId());
    }

    public void deletar(Long id) {
        jdbcTemplate.update(DELETE, id);
    }

    public Exemplar buscarPorId(Long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, new Object[]{id}, new ExemplarRowMapper());
    }

    public List<Exemplar> buscarTodos() {
        return jdbcTemplate.query(SELECT_ALL, new ExemplarRowMapper());
    }

    List<Exemplar> buscarPorLivro(Livro livro) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static class ExemplarRowMapper implements RowMapper<Exemplar> {

       @Override
       public Exemplar mapRow(ResultSet rs, int rowNum) throws SQLException {
           Livro livro = new Livro();
           livro.setId(rs.getLong("id_livro"));

           Exemplar exemplar = new Exemplar();
           exemplar.setId(rs.getLong("id"));
           exemplar.setLivro(livro);
           exemplar.setDisponivel(rs.getBoolean("disponivel"));

           return exemplar;
       }
   }
}
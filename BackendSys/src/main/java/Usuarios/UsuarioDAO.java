package Usuarios;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;



public class UsuarioDAO {
    private final String INSERT = "INSERT INTO usuarios (nome, cpf, email, genero, telefone, senha, instituicao) VALUES (?, ?, ?, ?, ?, ?)";
    private final String UPDATE = "UPDATE usuarios SET nome = ?, cpf = ?, email = ?, genero = ?, telefone = ?, senha = ?, instituicao, WHERE id = ?";
    private final String DELETE = "DELETE FROM usuarios WHERE id = ?";
    private final String SELECT_BY_ID = "SELECT * FROM usuarios WHERE id = ?";
    private final String SELECT_ALL = "SELECT * FROM usuarios";
    private final String SELECT_BY_EMAIL = "SELECT * FROM usuarios WHERE email = ?";

    private JdbcTemplate jdbcTemplate;

    public UsuarioDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

   public void criar(Usuario usuario) {
        PreparedStatementCreator preparedStatementCreator = (Connection connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT, new String[]{"id"});
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getCpf());
            preparedStatement.setString(3, usuario.getEmail());
            preparedStatement.setString(5, usuario.getGenero());
            preparedStatement.setString(4, usuario.getTelefone());
            preparedStatement.setString(5, usuario.getSenha());
            preparedStatement.setString(6, usuario.getInstituicao());
            return preparedStatement;
        };
        
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(preparedStatementCreator, keyHolder);
            Long id;
            id = keyHolder.getKey().longValue();
            usuario.setId(id);
        } catch (DataAccessException exception) {
            System.out.println("Erro ao criar usuário: " + exception.getMessage());
        }
    }


    public void atualizar(Usuario usuario) {
        jdbcTemplate.update(UPDATE, usuario.getNome(), usuario.getCpf(), usuario.getEmail(), usuario.getTelefone(), usuario.getSenha(), usuario.getId());
    }

    public void deletar(Long id) {
        jdbcTemplate.update(DELETE, id);
    }

    public Usuario buscarPorId(Long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, new BeanPropertyRowMapper<>(Usuario.class), id);
    }

    public List<Usuario> buscarTodos() {
        return jdbcTemplate.query(SELECT_ALL, new BeanPropertyRowMapper<>(Usuario.class));
    }

    public Usuario buscarPorEmail(String email) {
        try {
            return jdbcTemplate.queryForObject(SELECT_BY_EMAIL, new BeanPropertyRowMapper<>(Usuario.class), email);
        } catch (EmptyResultDataAccessException exception) {
            return null;
        }
    }
}


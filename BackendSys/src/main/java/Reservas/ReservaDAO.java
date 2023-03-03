package Reservas;

import Livrosexemplar.Exemplar;
import Livrosexemplar.ExemplarDAO;
import Usuarios.UsuarioDAO;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class ReservaDAO {
    private final JdbcTemplate jdbcTemplate;
    private final ExemplarDAO exemplarDAO;
    private final UsuarioDAO usuarioDAO;

    private static final String SELECT_ALL = "SELECT * FROM reservas";
    private static final String SELECT_BY_ID = "SELECT * FROM reservas WHERE id = ?";
    private static final String INSERT = "INSERT INTO reservas (id_usuario, id_exemplar, data_reserva, data_expiracao) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE reservas SET id_cliente = ?, id_exemplar = ?, data_reserva = ?, data_expiracao = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM reservas WHERE id = ?";

    public ReservaDAO(JdbcTemplate jdbcTemplate, ExemplarDAO exemplarDAO, UsuarioDAO usuarioDAO) {
        this.jdbcTemplate = jdbcTemplate;
        this.exemplarDAO = exemplarDAO;
        this.usuarioDAO = usuarioDAO;
    }

    public List<Reserva> buscarTodos() {
        List<Reserva> reservas = jdbcTemplate.query(SELECT_ALL, new ReservaRowMapper());
        for (Reserva reserva : reservas) {
            reserva.setUsuario(usuarioDAO.buscarPorId(reserva.getUsuario().getId()));
            reserva.setLivro(exemplarDAO.buscarPorId(reserva.getExemplar().getId()));
        }
        return reservas;
    }

    public Reserva buscarPorId(Long id) throws ReservaNaoEncontradaException {
        try {
            Reserva reserva = jdbcTemplate.queryForObject(SELECT_BY_ID, new ReservaRowMapper(), id);
            reserva.setUsuario(usuarioDAO.buscarPorId(reserva.getUsuario().getId()));
            reserva.setLivro(exemplarDAO.buscarPorId(reserva.getExemplar().getId()));
            return reserva;
        } catch (EmptyResultDataAccessException exception) {
            throw new ReservaNaoEncontradaException("Reserva não encontrada.");
        }
    }

    public void criar(Reserva reserva) throws LivroNaoEncontradoException, ReservaJaExistenteException, LivroIndisponivelException {
        // verifica se o livro está disponível para reserva
        Exemplar exemplar = reserva.getExemplar();
        if (exemplar.isDisponivel() == false) {
            throw new LivroIndisponivelException("Não há exemplares disponíveis para reserva.");
        }

        // verifica se já existe uma reserva para o exemplar
        List<Reserva> reservas = buscarTodos();
        for (Reserva r : reservas) {
            if (r.getExemplar().getId().equals(exemplar.getId())) {
                throw new ReservaJaExistenteException("Já existe uma reserva para este exemplar.");
            }
        }

        exemplar.setDisponivel(false);
        exemplarDAO.atualizar(exemplar);

        jdbcTemplate.update(INSERT, reserva.getUsuario().getId(), reserva.getExemplar().getId(),
                reserva.getDataReserva(), reserva.getDataExpiracao());
    }
    public void atualizar(Reserva reserva) throws LivroNaoEncontradoException {
        Exemplar exemplar = reserva.getExemplar();
        if (exemplar.isDisponivel() == false) {
            throw new LivroNaoEncontradoException("Não há exemplares disponíveis para reserva.");
        }
        exemplarDAO.atualizar(exemplar);

        jdbcTemplate.update(UPDATE, reserva.getUsuario().getId(), reserva.getExemplar().getId(),
                reserva.getDataReserva(), reserva.getDataExpiracao(), reserva.getId());
    }

    public void deletar(Long id) {
        jdbcTemplate.update(DELETE, id);
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reservas;

import Livrosexemplar.Exemplar;
import Livrosexemplar.ExemplarDAO;
import Usuarios.Usuario;
import Usuarios.UsuarioDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ariel
 */
public class ReservaRowMapper implements RowMapper<Reserva> {

    private final UsuarioDAO usuarioDAO = null;
    private final ExemplarDAO exemplarDAO = null;

    public ReservaRowMapper() {
    }


    @Override
    public Reserva mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        LocalDateTime dataReserva = rs.getTimestamp("data_reserva").toLocalDateTime();
        LocalDateTime dataExpiracao = rs.getTimestamp("data_expiracao").toLocalDateTime();
        Long usuarioId = rs.getLong("usuario_id");
        Long exemplarId = rs.getLong("exemplar_id");

        Usuario usuario = usuarioDAO.buscarPorId(usuarioId);
        Exemplar exemplar = exemplarDAO.buscarPorId(exemplarId);

        return new Reserva(id, usuario, exemplar, dataReserva, dataExpiracao);
    }
}
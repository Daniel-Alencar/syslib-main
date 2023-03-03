
package Reservas;

import Livrosexemplar.Exemplar;
import Usuarios.Usuario;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reserva {
    private Long id;
    private Exemplar exemplar;
    private Usuario usuario;
    private LocalDateTime dataReserva;
    private LocalDateTime dataExpiracao;
    private boolean ativa;

    public Reserva() {
    }
    
    public Reserva(Exemplar exemplar, Usuario usuario) {
        this.exemplar = exemplar;
        this.usuario = usuario;
        this.dataReserva = LocalDateTime.now();
        calcularDataExpiracao();
    }
    
    public Reserva(Long id, Usuario usuario, Exemplar exemplar, LocalDateTime dataReserva, LocalDateTime dataExpiracao) {
    this.id = id;
    this.usuario = usuario;
    this.exemplar = exemplar;
    this.dataReserva = dataReserva;
    this.dataExpiracao = dataExpiracao;
}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setLivro(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDateTime dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalDateTime getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDateTime dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    private void calcularDataExpiracao() {
        this.dataExpiracao = LocalDateTime.now().plusDays(30);
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
    
    
}

package Usuarios;



public class TipoUsuario {
    private final String tipo;

    public static final TipoUsuario USUARIO_COMUM = new TipoUsuario("USUARIO_COMUM");
    public static final TipoUsuario BIBLIOTECARIO = new TipoUsuario("BIBLIOTECARIO");

    private TipoUsuario(String tipo) {
        this.tipo = tipo;
    }

    public String get() {
        return tipo;
    }
}


package Usuarios;

/**
 *
 * @author ariel
 */
public class Credenciais {
    private Long id;
    private String email;
    private String hashSenha;
    private String salt;
    private TipoUsuario permissao;

    public Credenciais(String email, String hashSenha, String salt) {
        this.email = email;
        this.hashSenha = hashSenha;
        this.salt = salt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashSenha() {
        return hashSenha;
    }

    public void setHashSenha(String hashSenha) {
        this.hashSenha = hashSenha;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public TipoUsuario getPermissao() {
        return permissao;
    }

    public void setPermissao(TipoUsuario permissao) {
        this.permissao = permissao;
    }
    
    
}

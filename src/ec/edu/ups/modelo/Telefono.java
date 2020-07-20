package ec.edu.ups.modelo;

/**
 *
 * @author Paul Idrovo
 */
public class Telefono {

    private int codigo;
    private String numero;
    private String tipo;
    private String operadora;

    private Usuario usuario;

    public Telefono() {
    }

    public Telefono(int codigo, String numero, String tipo, String operadora) {
        this.setCodigo(codigo);
        this.setNumero(numero);
        this.setTipo(tipo);
        this.setOperadora(operadora);

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = validarEspacios(numero, 25);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = validarEspacios(tipo, 25);
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = validarEspacios(operadora, 25);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String validarEspacios(String cadena, int n) {
        if (cadena.length() == n) {
            return cadena;
        } else {
            if (cadena.length() < n) {
                return LlenarEspacios(cadena, n);
            } else {
                return cortarEspacios(cadena, n);
            }
        }

    }

    public String cortarEspacios(String cadena, int n) {
        return cadena.substring(0, n);

    }

    public String LlenarEspacios(String cadena, int n) {
        return String.format("%-" + n + "s", cadena);

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Telefono other = (Telefono) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DATOS TELEFONO ** " + "codigo: " + codigo + " numero: " + numero + " tipo: " + tipo + " operadora: " + operadora + " **";
    }
}

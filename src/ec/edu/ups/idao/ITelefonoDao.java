package ec.edu.ups.idao;

import ec.edu.ups.modelo.Telefono;
import java.util.List;

/**
 *
 * @author Paul Idrovo
 */
public interface ITelefonoDao {

    public void create(Telefono telefono);

    public Telefono read(int id);

    public void update(Telefono telefono);

    public void delete(Telefono telefono);

    public List<Telefono> listarTelefonos();

    public int obtenerUltimoCodigo();

    public List<Telefono> retornaTlfsUsuario(String cedula);

}

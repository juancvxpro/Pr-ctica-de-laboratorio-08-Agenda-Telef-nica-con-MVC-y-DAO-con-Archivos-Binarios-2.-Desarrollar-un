package ec.edu.ups.controlador;

import ec.edu.ups.dao.TelefonoDao;
import ec.edu.ups.idao.ITelefonoDao;
import ec.edu.ups.modelo.Telefono;
import java.util.List;

public class ControladorTelefono {

    private Telefono telefono;
    private ITelefonoDao telefonoDao;
    //constructor

    public ControladorTelefono(TelefonoDao telefonoD) {
        this.telefonoDao = telefonoD;
    }

    public void crearTelefono(Telefono telefono) {
        telefonoDao.create(telefono);
    }
    public void eliminarTelefono(int codigo){
        
    telefonoDao.delete(codigo);
    }
    public Telefono encontrarTelefono(int codigo) {

        telefono = telefonoDao.read(codigo);

        return telefono;
    }
    public List<Telefono> listarTelefonos(String cedula){
        return telefonoDao.retornaTlfsUsuario(cedula);
    
    }
    
      public List<Telefono> findAll(){
        return telefonoDao.listarTelefonos();
    
    }

    public int obtenerSiguienteCodigo() {
        int codigo = telefonoDao.obtenerUltimoCodigo();

        return codigo;
    }

}

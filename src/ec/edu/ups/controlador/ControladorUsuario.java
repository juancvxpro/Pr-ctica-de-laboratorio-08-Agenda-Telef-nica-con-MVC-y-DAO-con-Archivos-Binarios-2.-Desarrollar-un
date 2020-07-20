/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.TelefonoDao;
import ec.edu.ups.dao.UsuarioDao;
import ec.edu.ups.idao.ITelefonoDao;
import ec.edu.ups.idao.IUsuarioDao;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import java.util.List;

/**
 * Clase ControladorUsuario.
 *
 * Esta clase manejara toda la informacion del usuario y ademas tendra acceso a
 * la lista de usuarios registrados que le pertenece a UsuarioDao, esto se debe
 * a que el cosntructor recibe al usuarioDao. Ademas podra hacer uso de los
 * telefonos disponibles en Telefono Dao
 *
 * @author Paul Idrovo
 */
public class ControladorUsuario {

    private IUsuarioDao UsuarioDao;
    private ITelefonoDao TelefonoDao;
    private Usuario usuario;
    private Telefono telefono;

    public ControladorUsuario(UsuarioDao usuarioDAO, TelefonoDao telefonoDAO) {
        this.UsuarioDao = usuarioDAO;
        this.TelefonoDao = telefonoDAO;
    }

    public void registrarUsuario(String cedula, String nombre, String apellido, String correo, String pass) {
        usuario = new Usuario(cedula, nombre, apellido, correo, pass);
        UsuarioDao.create(usuario);

    }

    public void actualizarUsuario(String cedula, String nombre, String apellido, String correo, String pass) {
        usuario = new Usuario(cedula, nombre, apellido, correo, pass);
        UsuarioDao.update(usuario);
    }

    public void eliminarUsuario(String cedula) {
        usuario = UsuarioDao.read(cedula);
        UsuarioDao.delete(usuario);
    }

    public void buscarUsuario(String cedula) {
        UsuarioDao.read(cedula);
    }

    public Usuario iniciarSesion(String correo, String contrasena) {
        usuario = UsuarioDao.iniciarSesion(correo, contrasena);

        return usuario;
    }

    public void agregarTelefono(int codigo, String numero, String tipo, String operadora) {
        telefono = new Telefono(codigo, numero, tipo, operadora);
        telefono.setUsuario(usuario);
        TelefonoDao.create(telefono);
    }

    public void actualizarTelefono(int codigo, String numero, String tipo, String operadora) {
        telefono = new Telefono(codigo, numero, tipo, operadora);
        telefono.setUsuario(usuario);
        TelefonoDao.update(telefono);
    }

    public List<Telefono> ListarTelefonos() {

        return TelefonoDao.retornaTlfsUsuario(usuario.getCedula());

    }
    

    public boolean validarUsuario(String correo, String pass) {
        usuario = UsuarioDao.iniciarSesion(correo, pass);
        if (usuario != null) {
            return true;
        } else {
            return false;
        }

    }
}

package ec.edu.ups.dao;

import ec.edu.ups.modelo.Telefono;

import ec.edu.ups.idao.ITelefonoDao;
import ec.edu.ups.modelo.Usuario;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paul Idrovo
 */
public class TelefonoDao implements ITelefonoDao {

    /**
     * Estructura del archivo private int codigo 4 bytes private String
     * numero;25 bytes +2 extras private String tipo; 25 bytes +2 extras+
     * private String operadora; 25 bytes +2 extras private Usuario usuario;
     * (cedula) 10 bytes+2 extras
     *
     * total-> 97 bytes
     */
    private List<Telefono> listar;
    private int codigo;
    private UsuarioDao usuarioDao;
    private int tamanioRegistro;
    private RandomAccessFile archivo;

    public TelefonoDao() {

        try {
            usuarioDao = new UsuarioDao();
            codigo = 0;
            tamanioRegistro = 97;
            archivo = new RandomAccessFile("datos/telefonos.dat", "rw");
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura");

        }
    }

    @Override
    public void create(Telefono telefono) {
        try {
            archivo.seek(archivo.length());
            archivo.writeInt(telefono.getCodigo());
            archivo.writeUTF(telefono.getNumero());
            archivo.writeUTF(telefono.getTipo());
            archivo.writeUTF(telefono.getOperadora());
            archivo.writeUTF(telefono.getUsuario().getCedula());
         
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura create: Telefono");
        }
    }

    @Override
    public Telefono read(int id) {
        try {
            int salto = 0;

            while (salto < archivo.length()) {
                archivo.seek(salto);
                int idArchivo = archivo.readInt();
                if (idArchivo == id) {
                    // retornar el telefono
                    Telefono tel = new Telefono(id, archivo.readUTF().trim(), archivo.readUTF().trim(),
                            archivo.readUTF().trim());
                    Usuario usuario = usuarioDao.read(archivo.readUTF().trim());
                    tel.setUsuario(usuario);

                    return tel;
                  
                }
                salto += tamanioRegistro;
            }

        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura read:TelefonoDao");
        }
        return null;
    }

    //para actualizar un telefono
    @Override
    public void update(Telefono telefono) {
      int salto = 0;
        int codigo = telefono.getCodigo();
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoArchivo = archivo.readInt();
                if (codigo == codigoArchivo) {
                     archivo.writeUTF(telefono.getTipo());
                    archivo.writeUTF(telefono.getOperadora());

                    break;
                }
                salto += tamanioRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura o escritura(upDate Telefono)");
        }
    }
    

    //para eliminar un telefono
    @Override
    public void delete(int codigo) {
        System.out.println(""+codigo);
        try {
            int salto = 0;

            while (salto < archivo.length()) {
                archivo.seek(salto);
                int idArchivo = archivo.readInt();
                if (codigo==idArchivo) {
                 archivo.seek(salto);
                archivo.writeInt(0);
                archivo.writeUTF(llenarEspacios(25));
                archivo.writeUTF(llenarEspacios(25));
               archivo.writeUTF(llenarEspacios(25));
               archivo.writeUTF(llenarEspacios(10));
               break;
                }
                salto += tamanioRegistro;
            }
           archivo.close();
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura Delete:TelefonoDao");
        }
    }

    @Override
    public int obtenerUltimoCodigo() {
        try {
            if (archivo.length() >= tamanioRegistro) {
                archivo.seek(archivo.length() - tamanioRegistro);
                codigo = archivo.readInt();
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura");
        }

        return codigo;
    }

    @Override
    public List<Telefono> listarTelefonos() {
        listar = new ArrayList<>();
        try {
            int salto = 0;

            while (salto < archivo.length()) {
                archivo.seek(salto);
                   int c = archivo.readInt();
                   if(c>0){
                   Telefono tel = new Telefono(archivo.readInt(), archivo.readUTF().trim(), archivo.readUTF().trim(),
                        archivo.readUTF().trim());
                Usuario usuario = usuarioDao.read(archivo.readUTF().trim());
                
                tel.setUsuario(usuario);
                
                listar.add(tel);
                   }
                
                
                 salto += tamanioRegistro;
            }
             

        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura listarTelefonos:TelefonoDao");
        }
        return listar;

    }

    @Override
    public List<Telefono> retornaTlfsUsuario(String cedula) {
        listar = new ArrayList<>();
         int salto = 85;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String cedulaArchivo = archivo.readUTF();
                if (cedula.trim().equals(cedulaArchivo.trim())) {
                    archivo.seek(salto);
                    archivo.seek(salto - 85);
                    int c =archivo.readInt();
                    if(c>0){
                     Telefono tel = new Telefono(codigo, archivo.readUTF().trim(), archivo.readUTF().trim(),
                            archivo.readUTF().trim());
                    Usuario usuario = usuarioDao.read(archivo.readUTF().trim());
                    tel.setUsuario(usuario);
                    listar.add(tel);
                    }
                }

                salto += tamanioRegistro;
            }
            return listar;
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura retornaTlfsUsuario:TelefonoDao");
        }
        return listar;
    }
    public String llenarEspacios(int espacios) {
        String formato = "";
        return String.format("%-" + espacios + "s", formato);
    }
}

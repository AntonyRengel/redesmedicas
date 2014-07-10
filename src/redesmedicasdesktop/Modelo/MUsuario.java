/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redesmedicasdesktop.Modelo;

/**
 *
 * @author antony
 */
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MUsuario extends MConexionBD {

    private String usuario;
    private String clave;

    public String getUsuario() {
        return usuario;
    }//git@bitbucket.org:arengel/redesmedicasdesktop.git

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public MUsuario() {
    }

    public boolean validarUsuario(String Usuario, String Clave) {
        boolean valido = false;
        String sql = "SELECT  a.id FROM usuarios  a,clientes b  WHERE  (a.cliente=b.id) and (a.usuario= '" + Usuario + "') and (a.clave= ('" + this.getMD5(Clave) + "')) and (b.estatus='1')  ORDER BY b.cedula   ASC";
        if (!this.getRegistro(sql).isEmpty()) {
            valido = true;
        }
        return valido;
    }

    public Object[][] getModulosPorUsuario(String IdUsuario) {

        Object[][] cadena = new Object[0][0];
        String sql = "SELECT A.id  CODIGO ,A.descripcion DESCRIPCION  \n"
                + "					           FROM modulos_sistema  A\n"
                + "								WHERE   EXISTS (SELECT 1 \n"
                + "												  FROM paginas_usuarios B,paginas_sistema  C\n"
                + "												  WHERE B.usuario = '" + IdUsuario + "' AND\n"
                + "												        B.pagina = C.id AND\n"
                + "														C.modulo = A.id )  and (A.id<>'4')\n"
                + "								 \n"
                + "								ORDER BY A.descripcion ASC";
        cadena = this.getConsulta(sql);
        return cadena;
    }

    public String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}

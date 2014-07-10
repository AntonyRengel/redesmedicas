/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redesmedicasdesktop.Controlador;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import redesmedicasdesktop.Modelo.MUsuario;
import redesmedicasdesktop.Vista.VLogin;
import redesmedicasdesktop.Vista.VPrincipal;

/**
 *
 * @author antony
 */
public class CLogin {

    //Objetos tipo Vista
    private VPrincipal vp;
    private VLogin vl;
    private MUsuario mu;

    //Componentes del meni
    private JMenuBar barra1;
    private JMenuBar menu1;
    private JMenuItem item1, item2, item3, item4;

    public CLogin(VLogin vl, VPrincipal vp) {
        this.vl = vl;
        this.vp = vp;
        mu = new MUsuario();
    }

    private String usuario;
    private String clave;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    //Valida el login y clave del usuario para su acceso
    public void validarUsuario(String Usuario, String Clave) {
        if (mu.validarUsuario(Usuario, Clave)) {

            this.vp.setEnabled(true);
            
            this.setUsuario(Usuario);
            this.setClave(Clave);
            this.vp.cargarCalendario(usuario, clave);
            this.vp.pack();
            vl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vl.dispose();

        } else {
            JOptionPane.showMessageDialog(vl, "Usuario y clave invalidas");
        }
    }

    //Carga el menu de acuerdo a los permisos del usuario
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redesmedicasdesktop.Controlador;

import redesmedicasdesktop.Vista.VPrincipal;

/**
 *
 * @author antony
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.*;
import com.toedter.calendar.JCalendar;

public class CPrincipal {

    private VPrincipal vprincipal;
    JCalendar calendario;
    JTextField fecha;

    public CPrincipal(VPrincipal vp) {
        this.vprincipal = vp;
    }

    public void cargarMenuDoctor() {

    }

    public void cargarCalendario(JInternalFrame pCalendario) {
        calendario = new JCalendar();

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        JPanel pfecha = new JPanel();
        pfecha.add(new JLabel("Fecha Seleccionada"));

        fecha = new JTextField(30);
        JButton b = new JButton("Aceptar");
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String año = Integer.toString(calendario.getCalendar().get(java.util.Calendar.YEAR));
                String mes = Integer.toString(calendario.getCalendar().get(java.util.Calendar.MONTH) + 1);
                String dia = Integer.toString(calendario.getCalendar().get(java.util.Calendar.DATE));
                fecha.setText(dia + " de " + mes + " del " + año);
            }

        });

        pfecha.add(fecha);
        pfecha.add(b);
        p.add(pfecha);
        p.add(calendario);
        pCalendario.add(p);
        pCalendario.pack();
        this.vprincipal.pack();
    }

}

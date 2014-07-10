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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Calendar;

/**
 *
 * @author antony
 */
public class MLogs {

    String nombreArchivo;

    public MLogs(String nombrearchivo) {
        this.nombreArchivo = nombrearchivo;
    }

    public void escribirLog(String mensaje) {

        // File f;
        //f = new File(this.nombreArchivo);
//Escritura
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            File file = new File(this.nombreArchivo);

            if (!file.exists()) {

                file.createNewFile();
                //System.out.println("El fichero se ha creado correctamente");

            }


            /*la clave de activar o no la sobreescritura esta en FileOutputStream(file, true) si le ponemos en true entonces agregas al final de la linea */
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF8"));

            out.write(this.getFechaActual() + ":  \n" + mensaje + "\n\n");
            out.write("\n");
            out.close();

        } catch (IOException e) {
        }

    }

    public String getFechaActual() {
        String anio = "", mes = "", dia = "", fechaActual = "", usuario = "";

        Calendar d = Calendar.getInstance();

        anio += d.get(Calendar.YEAR);
        if (d.get(Calendar.MONTH) < 10) {
            mes += "0" + (d.get(Calendar.MONTH) + 1);
        } else {
            mes += (d.get(Calendar.MONTH) + 1);
        }
        dia += d.get(Calendar.DAY_OF_MONTH);

        fechaActual += anio + "-" + mes + "-" + dia + " " + String.valueOf(d.get(Calendar.HOUR_OF_DAY)) + ":" + String.valueOf(d.get(Calendar.MINUTE)) + ":" + String.valueOf(d.get(Calendar.SECOND));

        return fechaActual;
    }

}

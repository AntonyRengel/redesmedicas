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
import java.sql.*;
import java.util.Calendar;

public class MConexionBD {

    private Connection conexion;

    private String driver;

    public MConexionBD() {
        this.driver = "jdbc:sqlite:redmedicas.db";

        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection(this.driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public MConexionBD(String driver) {
        this.driver = driver;
        try {

            conexion = DriverManager.getConnection(this.driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Funcion para ejecutar una modificacion en una tabla de la base de datos (MODIFICAR/INSERTAR/ELIMINAR)
    public boolean setConsulta(String sql) {
        boolean exito = false;

        try {
            Statement s = conexion.createStatement();
            if (s.execute(sql)) {
                exito = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            this.escribirLogBD("ERROR: " + e.getMessage());
        }

        return exito;

    }

    //Obtiene una matriz con el resultado de una consulta SQL 
    public Object[][] getConsulta(String sql) {

        Object[][] cadena = new Object[0][0];
        int size = 0, j = 0;
        try {
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery(sql);

            rs.last();
            if (rs.getRow() > 0) {
                size = rs.getMetaData().getColumnCount();
                cadena = new Object[(rs.getRow() + 1)][size];
                rs.beforeFirst();
                while (rs.next()) {
                    for (int i = 0; i < size; i++) {
                        cadena[j][i] = rs.getObject(i + 1);

                    }

                    j++;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            this.escribirLogBD("ERROR: " + e.getMessage());
        }

        return cadena;

    }

    //Obtiene un (1) registro puntual de una consulta SQL 
    public String getRegistro(String sql) {
        String cadena = "";
        try {
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                cadena += rs.getString(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cadena;

    }

    //Verifica si la tabla a consultar existe
    public boolean existeTabla(String tabla) {

        String cadena = "";
        boolean existe = false;

        String sql = "CHECK TABLE " + tabla;
        try {
            Statement s = conexion.createStatement();

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                cadena += String.valueOf(rs.getObject(4));
                break;
            }

            if (cadena.contains("OK")) {
                existe = true;
            }
            ;
        } catch (Exception e) {
            this.escribirLogBD("ERROR: " + e.getMessage());
            e.printStackTrace();
            existe = false;
        }

        return existe;

    }

    //Escribir en el log de errores SQL para depuracion posterior
    public void escribirLogBD(String mensaje) {
        MLogs log = new MLogs("log_bd" + this.getFechaActual() + ".txt");
        log.escribirLog(mensaje);
    }

    //Obriene la fecha actual del sistema
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

        fechaActual += anio + "-" + mes + "-" + dia;

        return fechaActual;
    }

}//fin de la Clase Modelo


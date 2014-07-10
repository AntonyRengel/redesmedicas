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
public class MCitasCalendario extends MConexionBD {

    
    public Object[][] getModulosPorUsuario(String IdUsuario, String mes, String dia, String ano) {

        Object[][] cadena = new Object[0][0];
        String sql = " SELECT a.id id, a.fecha fecha, a.cliente cliente, a.turno turno, a.citas citas, a.horario horario, a.cupos cupos,a.cupos_medico cupos_medico, a.observacion observacion,a.estatus_citas estatus_citas,b.id id_t, b.descripcion descripcion_t,c.id id_c, c.descripcion descripcion_c "
                + "FROM plani_citas  a,turno b,citas c  where (a.turno=b.id) and "
                + "(a.citas=c.id) and  "
                + "(a.cliente= '" + IdUsuario + "')	and "
                + "EXTRACT('MONT' from a.fecha)= '" + mes + "' and "
                + "EXTRACT('YEAR' from a.fecha)= '" + ano + "'  "
                
                 + "EXTRACT('DAY' from a.fecha)= '" + dia + "'  "
                + "ORDER BY a.fecha  ASC";
        cadena = this.getConsulta(sql);
        return cadena;
    }

}

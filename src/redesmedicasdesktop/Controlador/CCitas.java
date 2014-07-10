/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redesmedicasdesktop.Controlador;

/**
 *
 * @author antony
 */
public class CCitas {

    String id;
    String fecha;
    String cliente;
    String turno;
    String horario;
    String cupos;
    String cupos_medico;
    String observacion;
    String estatus_citas;
    String id_t;
    String descripcion_t;
    String id_c  ;
    String descripcion_c;

    public CCitas(String id, String fecha, String cliente, String turno, String horario, String cupos, String cupos_medico, String observacion, String estatus_citas, String id_t, String descripcion_t, String id_c, String descripcion_c) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.turno = turno;
        this.horario = horario;
        this.cupos = cupos;
        this.cupos_medico = cupos_medico;
        this.observacion = observacion;
        this.estatus_citas = estatus_citas;
        this.id_t = id_t;
        this.descripcion_t = descripcion_t;
        this.id_c = id_c;
        this.descripcion_c = descripcion_c;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCupos() {
        return cupos;
    }

    public void setCupos(String cupos) {
        this.cupos = cupos;
    }

    public String getCupos_medico() {
        return cupos_medico;
    }

    public void setCupos_medico(String cupos_medico) {
        this.cupos_medico = cupos_medico;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstatus_citas() {
        return estatus_citas;
    }

    public void setEstatus_citas(String estatus_citas) {
        this.estatus_citas = estatus_citas;
    }

    public String getId_t() {
        return id_t;
    }

    public void setId_t(String id_t) {
        this.id_t = id_t;
    }

    public String getDescripcion_t() {
        return descripcion_t;
    }

    public void setDescripcion_t(String descripcion_t) {
        this.descripcion_t = descripcion_t;
    }

    public String getId_c() {
        return id_c;
    }

    public void setId_c(String id_c) {
        this.id_c = id_c;
    }

    public String getDescripcion_c() {
        return descripcion_c;
    }

    public void setDescripcion_c(String descripcion_c) {
        this.descripcion_c = descripcion_c;
    }
    
    
}

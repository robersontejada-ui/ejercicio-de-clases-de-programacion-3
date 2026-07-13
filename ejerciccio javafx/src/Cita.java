public class Cita {

    private String codigo;
    private String paciente;
    private String cedula;
    private String telefono;
    private String medico;
    private String especialidad;
    private String fecha;
    private String hora;
    private String motivo;
    private String estado;

    public Cita(String codigo, String paciente, String cedula,
            String telefono, String medico, String especialidad,
            String fecha, String hora, String motivo, String estado) {

        this.codigo = codigo;
        this.paciente = paciente;
        this.cedula = cedula;
        this.telefono = telefono;
        this.medico = medico;
        this.especialidad = especialidad;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return codigo + ";" +
                paciente + ";" +
                cedula + ";" +
                telefono + ";" +
                medico + ";" +
                especialidad + ";" +
                fecha + ";" +
                hora + ";" +
                motivo + ";" +
                estado;
    }
}

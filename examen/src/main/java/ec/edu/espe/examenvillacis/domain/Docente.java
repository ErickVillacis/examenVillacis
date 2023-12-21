package ec.edu.espe.examenvillacis.domain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "DOCENTE")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_DOCENTE", nullable = false)
    private Long codigo;

    @Column(name = "COD_ESPECIALIDAD", length = 10)
    private String codigoEspecialidad;

    @Column(name = "CEDULA", length = 10)
    private String cedula;

    @Column(name = "NOMBRE", length = 100)
    private String nombre;

    @Column(name = "FECHA_INGRESO")
    private Date fechaIngreso;

    @Column(name = "TITULO", length = 100)
    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_ESPECIALIDAD", referencedColumnName = "COD_ESPECIALIDAD", insertable = false, updatable = false)
    private Especialidad especialidad;

    @OneToMany(mappedBy = "docente")
    private List<DocenteMateria> docenteMaterias; // Asegúrate de que este campo esté definido

    public Docente() {
    }

    public Docente(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getCodigoEspecialidad() {
        return codigoEspecialidad;
    }

    public void setCodigoEspecialidad(String codigoEspecialidad) {
        this.codigoEspecialidad = codigoEspecialidad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public List<DocenteMateria> getDocenteMaterias() {
        return docenteMaterias;
    }

    public void setDocenteMaterias(List<DocenteMateria> docenteMaterias) {
        this.docenteMaterias = docenteMaterias;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Docente other = (Docente) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Docente [codigo=" + codigo + ", codigoEspecialidad=" + codigoEspecialidad + ", cedula=" + cedula
                + ", nombre=" + nombre + ", fechaIngreso=" + fechaIngreso + ", titulo=" + titulo + ", especialidad="
                + especialidad + ", docenteMaterias=" + docenteMaterias + "]";
    }

}
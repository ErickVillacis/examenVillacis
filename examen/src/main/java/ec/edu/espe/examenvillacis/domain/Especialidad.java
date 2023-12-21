package ec.edu.espe.examenvillacis.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ESPECIALIDAD")
public class Especialidad {

    @Id
    @Column(name = "COD_ESPECIALIDAD", nullable = false, length = 10)
    private String codigo;

    @Column(name = "NOMBRE", length = 100)
    private String nombre;

    @OneToMany(mappedBy = "especialidad")
    private List<Docente> docentes;

    public Especialidad(String codigo) {
        this.codigo = codigo;
    }

    public Especialidad() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
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
        Especialidad other = (Especialidad) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Especialidad [codigo=" + codigo + ", nombre=" + nombre + ", docentes=" + docentes + "]";
    }

}
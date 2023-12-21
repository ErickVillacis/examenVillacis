package ec.edu.espe.examenvillacis.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "MATERIA")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_MATERIA", nullable = false)
    private Long codigo;

    @Column(name = "NOMBRE", length = 60)
    private String nombre;

    @Column(name = "HORAS_CLASE", precision = 1)
    private int horasClase;

    @OneToMany(mappedBy = "materia")
    private List<DocenteMateria> docenteMaterias;

    public Materia(Long codigo) {
        this.codigo = codigo;
    }

    public Materia() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(int horasClase) {
        this.horasClase = horasClase;
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
        Materia other = (Materia) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Materia [codigo=" + codigo + ", nombre=" + nombre + ", horasClase=" + horasClase + ", docenteMaterias="
                + docenteMaterias + "]";
    }

}
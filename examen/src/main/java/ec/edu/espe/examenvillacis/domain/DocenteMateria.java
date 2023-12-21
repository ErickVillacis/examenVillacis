package ec.edu.espe.examenvillacis.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DOCENTE_MATERIA")
public class DocenteMateria {

    @EmbeddedId
    private DocenteMateriaId id;

    @Column(name = "PERIODO", length = 10)
    private String periodo;

    @Column(name = "ALUMNOS_MATRICULADOS")
    private BigDecimal alumnosMatriculados;

    @Column(name = "ESTADO", length = 3)
    private String estado;

    @Column(name = "PROMEDIO_CURSO", precision = 4, scale = 2)
    private BigDecimal promedioCurso;

    @Column(name = "FECHA_ULTIMO_CAMBIO")
    private Timestamp fechaUltimoCambio;

    @ManyToOne
    @JoinColumn(name = "COD_DOCENTE", insertable = false, updatable = false)
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "COD_MATERIA", insertable = false, updatable = false)
    private Materia materia;

    public DocenteMateria() {
    }

    public DocenteMateriaId getId() {
        return id;
    }

    public void setId(DocenteMateriaId id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public BigDecimal getAlumnosMatriculados() {
        return alumnosMatriculados;
    }

    public void setAlumnosMatriculados(BigDecimal alumnosMatriculados) {
        this.alumnosMatriculados = alumnosMatriculados;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getPromedioCurso() {
        return promedioCurso;
    }

    public void setPromedioCurso(BigDecimal promedioCurso) {
        this.promedioCurso = promedioCurso;
    }

    public Timestamp getFechaUltimoCambio() {
        return fechaUltimoCambio;
    }

    public void setFechaUltimoCambio(Timestamp fechaUltimoCambio) {
        this.fechaUltimoCambio = fechaUltimoCambio;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        DocenteMateria other = (DocenteMateria) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DocenteMateria [id=" + id + ", periodo=" + periodo + ", alumnosMatriculados=" + alumnosMatriculados
                + ", estado=" + estado + ", promedioCurso=" + promedioCurso + ", fechaUltimoCambio=" + fechaUltimoCambio
                + ", docente=" + docente + ", materia=" + materia + "]";
    }

}

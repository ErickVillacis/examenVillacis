package ec.edu.espe.examenvillacis.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DocenteMateriaId implements Serializable {

    @Column(name = "COD_DOCENTE")
    private Long codigoDocente;

    @Column(name = "COD_MATERIA")
    private Long codigoMateria;

    public DocenteMateriaId() {
    }

    public DocenteMateriaId(Long codigoDocente, Long codigoMateria) {
        this.codigoDocente = codigoDocente;
        this.codigoMateria = codigoMateria;
    }

    public Long getCodigoDocente() {
        return codigoDocente;
    }

    public void setCodigoDocente(Long codigoDocente) {
        this.codigoDocente = codigoDocente;
    }

    public Long getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(Long codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigoDocente == null) ? 0 : codigoDocente.hashCode());
        result = prime * result + ((codigoMateria == null) ? 0 : codigoMateria.hashCode());
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
        DocenteMateriaId other = (DocenteMateriaId) obj;
        if (codigoDocente == null) {
            if (other.codigoDocente != null)
                return false;
        } else if (!codigoDocente.equals(other.codigoDocente))
            return false;
        if (codigoMateria == null) {
            if (other.codigoMateria != null)
                return false;
        } else if (!codigoMateria.equals(other.codigoMateria))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DocenteMateriaId [codigoDocente=" + codigoDocente + ", codigoMateria=" + codigoMateria + "]";
    }

}
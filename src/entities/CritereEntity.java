package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "critere", schema = "tamaquoin", catalog = "")
public class CritereEntity {
    private Integer idCritere;
    private String label;
    private String typeFront;
    private String unite;
    private String typeColonne;

    @Id
    @Column(name = "id_critere")
    public Integer getIdCritere() {
        return idCritere;
    }

    public void setIdCritere(Integer idCritere) {
        this.idCritere = idCritere;
    }

    @Basic
    @Column(name = "label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Basic
    @Column(name = "type_front")
    public String getTypeFront() {
        return typeFront;
    }

    public void setTypeFront(String typeFront) {
        this.typeFront = typeFront;
    }

    @Basic
    @Column(name = "unite")
    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    @Basic
    @Column(name = "type_colonne")
    public String getTypeColonne() {
        return typeColonne;
    }

    public void setTypeColonne(String typeColonne) {
        this.typeColonne = typeColonne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CritereEntity that = (CritereEntity) o;
        return Objects.equals(idCritere, that.idCritere) &&
                Objects.equals(label, that.label) &&
                Objects.equals(typeFront, that.typeFront) &&
                Objects.equals(unite, that.unite) &&
                Objects.equals(typeColonne, that.typeColonne);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCritere, label, typeFront, unite, typeColonne);
    }
}

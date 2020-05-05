package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sous_categorie", schema = "tamaquoin", catalog = "")
public class SousCategorieEntity {
    private Integer idSousCategorie;
    private String label;

    @Id
    @Column(name = "id_sous_categorie")
    public Integer getIdSousCategorie() {
        return idSousCategorie;
    }

    public void setIdSousCategorie(Integer idSousCategorie) {
        this.idSousCategorie = idSousCategorie;
    }

    @Basic
    @Column(name = "label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SousCategorieEntity that = (SousCategorieEntity) o;
        return Objects.equals(idSousCategorie, that.idSousCategorie) &&
                Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSousCategorie, label);
    }
}

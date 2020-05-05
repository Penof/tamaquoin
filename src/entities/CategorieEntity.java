package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "categorie", schema = "tamaquoin", catalog = "")
public class CategorieEntity {
    private Integer idCategorie;
    private String label;

    @Id
    @Column(name = "id_categorie")
    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
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
        CategorieEntity that = (CategorieEntity) o;
        return Objects.equals(idCategorie, that.idCategorie) &&
                Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategorie, label);
    }
}

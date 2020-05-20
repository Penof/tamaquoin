package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "assoc_souscategorie_critere", schema = "tamaquoin", catalog = "")
public class AssocSouscategorieCritereEntity {
    private Integer idAssocSousCategorieCritere;
    private Integer idSousCategorie;
    private Integer idCritere;

    public void setIdAssocSousCategorieCritere(int idAssocSousCategorieCritere) {
        this.idAssocSousCategorieCritere = idAssocSousCategorieCritere;
    }

    public void setIdSousCategorie(int idSousCategorie) {
        this.idSousCategorie = idSousCategorie;
    }

    public void setIdCritere(int idCritere) {
        this.idCritere = idCritere;
    }

    @Id
    @Column(name = "id_assoc_sousCategorie_critere")
    public Integer getIdAssocSousCategorieCritere() {
        return idAssocSousCategorieCritere;
    }

    public void setIdAssocSousCategorieCritere(Integer idAssocSousCategorieCritere) {
        this.idAssocSousCategorieCritere = idAssocSousCategorieCritere;
    }

    @Basic
    @Column(name = "id_sous_categorie")
    public Integer getIdSousCategorie() {
        return idSousCategorie;
    }

    public void setIdSousCategorie(Integer idSousCategorie) {
        this.idSousCategorie = idSousCategorie;
    }

    @Basic
    @Column(name = "id_critere")
    public Integer getIdCritere() {
        return idCritere;
    }

    public void setIdCritere(Integer idCritere) {
        this.idCritere = idCritere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssocSouscategorieCritereEntity that = (AssocSouscategorieCritereEntity) o;
        return Objects.equals(idAssocSousCategorieCritere, that.idAssocSousCategorieCritere) &&
                Objects.equals(idSousCategorie, that.idSousCategorie) &&
                Objects.equals(idCritere, that.idCritere);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAssocSousCategorieCritere, idSousCategorie, idCritere);
    }
}

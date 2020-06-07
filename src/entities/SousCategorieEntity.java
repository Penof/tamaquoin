package entities;

import dao.AnnonceDao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sous_categorie", schema = "tamaquoin", catalog = "")
public class SousCategorieEntity {
    private Integer idSousCategorie;
    private String label;
    private List<AnnonceEntity> annonces;

    public void setIdSousCategorie(int idSousCategorie) {
        this.idSousCategorie = idSousCategorie;
    }

    @OneToMany(cascade=CascadeType.ALL, mappedBy="sousCategorie")
    public List<AnnonceEntity> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<AnnonceEntity> annonces) {
        this.annonces = annonces;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public boolean addAnnonce(AnnonceEntity a) {
        if(a != null){
            this.annonces.add(a);
            a.setSousCategorie(this);
            return true;
        } else {
            return false;
        }

    }

    public SousCategorieEntity(String label) {
        this.label = label;
        this.annonces = new ArrayList<AnnonceEntity>();
    }

    public SousCategorieEntity() {
    }




}

package entities;

import dao.AnnonceDao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sous_categorie", schema = "2i_poo_tamacoin", catalog = "")
public class SousCategorieEntity {
    private Integer idSousCategorie;
    private String label;
    private List<AnnonceEntity> annonces;
    private List<CritereEntity> criteres;

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

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "assoc_souscategorie_critere",
            joinColumns = { @JoinColumn(name = "id_sous_categorie") },
            inverseJoinColumns = { @JoinColumn(name = "id_critere") })
    public List<CritereEntity> getCriteres() {
        return criteres;
    }

    public void setCriteres(List<CritereEntity> criteres) {
        this.criteres = criteres;
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

    public void addCritere(CritereEntity critere) {
        this.criteres.add(critere);
        critere.getSousCategories().add(this);
    }



    public SousCategorieEntity(String label) {
        this.label = label;
        this.annonces = new ArrayList<>();
        this.criteres = new ArrayList<>();
        this.annonces = new ArrayList<>();

    }

    public SousCategorieEntity() {
    }




}

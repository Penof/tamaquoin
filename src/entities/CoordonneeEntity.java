package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "coordonnee", schema = "2i_poo_tamacoin", catalog = "")
public class CoordonneeEntity {
    private Integer idCoordonnee;
    private String pays;
    private String ville;
    private List<AnnonceEntity> annonces;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="coordonnee")
    public List<AnnonceEntity> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<AnnonceEntity> annonces) {
        this.annonces = annonces;
    }



    public void setIdCoordonnee(int idCoordonnee) {
        this.idCoordonnee = idCoordonnee;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_coordonnee")
    public Integer getIdCoordonnee() {
        return idCoordonnee;
    }

    public void setIdCoordonnee(Integer idCoordonnee) {
        this.idCoordonnee = idCoordonnee;
    }

    @Basic
    @Column(name = "pays")
    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Basic
    @Column(name = "ville")
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordonneeEntity that = (CoordonneeEntity) o;
        return Objects.equals(idCoordonnee, that.idCoordonnee) &&
                Objects.equals(pays, that.pays) &&
                Objects.equals(ville, that.ville);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCoordonnee, pays, ville);
    }

    public boolean addAnnonce(AnnonceEntity a) {
        if(a != null){
            this.annonces.add(a);
            a.setCoordonnee(this);
            return true;
        } else {
            return false;
        }

    }

    public CoordonneeEntity() {
    }

    public CoordonneeEntity(String pays, String ville) {
        this.pays = pays;
        this.ville = ville;
        this.annonces = new ArrayList<AnnonceEntity>();
    }
}

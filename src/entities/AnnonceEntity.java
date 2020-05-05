package entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "annonce", schema = "tamaquoin", catalog = "")
public class AnnonceEntity {
    private Integer idAnnonce;
    private String nom;
    private Timestamp dateCreation;
    private String description;
    private Integer nombreVu;
    private Double prix;
    private String photo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_annonce")
    public Integer getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(Integer idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "date_creation")
    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "nombre_vu")
    public Integer getNombreVu() {
        return nombreVu;
    }

    public void setNombreVu(Integer nombreVu) {
        this.nombreVu = nombreVu;
    }

    @Basic
    @Column(name = "prix")
    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    @Basic
    @Column(name = "photo")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnonceEntity that = (AnnonceEntity) o;
        return Objects.equals(idAnnonce, that.idAnnonce) &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(dateCreation, that.dateCreation) &&
                Objects.equals(description, that.description) &&
                Objects.equals(nombreVu, that.nombreVu) &&
                Objects.equals(prix, that.prix) &&
                Objects.equals(photo, that.photo);
    }

    public AnnonceEntity(String nom, Timestamp dateCreation, Integer nombreVu, Double prix) {
        this.nom = nom;
        this.dateCreation = dateCreation;
        this.nombreVu = nombreVu;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "AnnonceEntity{" +
                "idAnnonce=" + idAnnonce +
                ", nom='" + nom + '\'' +
                ", dateCreation=" + dateCreation +
                ", description='" + description + '\'' +
                ", nombreVu=" + nombreVu +
                ", prix=" + prix +
                ", photo='" + photo + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnnonce, nom, dateCreation, description, nombreVu, prix, photo);
    }
}

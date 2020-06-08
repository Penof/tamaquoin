package entities;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "annonce", schema = "2i_poo_tamacoin", catalog = "")
public class AnnonceEntity {
    private Integer idAnnonce;
    private String nom;
    private Timestamp dateCreation;
    private String description;
    private Integer nombreVu;
    private Double prix;
    private String photo;
    private SousCategorieEntity sousCategorie;
    private CoordonneeEntity coordonnee;
    private UtilisateurEntity utilisateur;
    private List<AssocAnnonceCritereEntity> criteresAnnonce;

    public AnnonceEntity() {
    }

    public AnnonceEntity(String nom, Timestamp dateCreation, String description, Double prix, Integer nombreVu) {
        this.nom = nom;
        this.dateCreation = dateCreation;
        this.description = description;
        this.prix = prix;
        this.nombreVu = nombreVu;
        this.criteresAnnonce = new ArrayList<>();

    }

    public void setIdAnnonce(int idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public void setNombreVu(int nombreVu) {
        this.nombreVu = nombreVu;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }


    @ManyToOne
    @JoinColumn(name="id_coordonnee", referencedColumnName = "id_coordonnee")
    public CoordonneeEntity getCoordonnee() {
        return coordonnee;
    }

    public void setCoordonnee(CoordonneeEntity coordonnee) {
        this.coordonnee = coordonnee;
    }

    @ManyToOne
    @JoinColumn(name="id_sous_categorie", referencedColumnName = "id_sous_categorie")
    public SousCategorieEntity getSousCategorie() {
        return sousCategorie;
    }

    public void setSousCategorie(SousCategorieEntity sousCategorie) {
        this.sousCategorie = sousCategorie;
    }

    @ManyToOne
    @JoinColumn(name="id_utilisateur", referencedColumnName = "id_utilisateur")
    public UtilisateurEntity getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurEntity utilisateur) {
        this.utilisateur = utilisateur;
    }

    @OneToMany(cascade=CascadeType.ALL, mappedBy="annonce")
    public List<AssocAnnonceCritereEntity> getCriteresAnnonce() {
        return criteresAnnonce;
    }

    public void setCriteresAnnonce(List<AssocAnnonceCritereEntity> criteresAnnonce) {
        this.criteresAnnonce = criteresAnnonce;
    }

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

    public void addCriteresAnnonce(AssocAnnonceCritereEntity criteresAnnonce) {
        this.criteresAnnonce.add(criteresAnnonce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnnonce, nom, dateCreation, description, nombreVu, prix, photo);
    }


}

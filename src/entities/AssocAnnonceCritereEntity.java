package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "assoc_annonce_critere", schema = "2i_poo_tamacoin", catalog = "")
public class AssocAnnonceCritereEntity {
    private Integer idAssocAnnonceCritere;
    private Integer valeurInt;
    private String valeurString;
    private Double valeurDouble;
    private Byte valeurBooleen;
    private AnnonceEntity annonce;
    private CritereEntity critere;

    public void setIdAssocAnnonceCritere(int idAssocAnnonceCritere) {
        this.idAssocAnnonceCritere = idAssocAnnonceCritere;
    }



    @ManyToOne
    @JoinColumn(name="id_annonce", referencedColumnName = "id_annonce")
    public AnnonceEntity getAnnonce() {
        return annonce;
    }

    public void setAnnonce(AnnonceEntity annonce) {
        this.annonce = annonce;
    }

    @ManyToOne
    @JoinColumn(name="id_critere", referencedColumnName = "id_critere")
    public CritereEntity getCritere() {
        return critere;
    }

    public void setCritere(CritereEntity critere) {
        this.critere = critere;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_assoc_annonce_critere")
    public Integer getIdAssocAnnonceCritere() {
        return idAssocAnnonceCritere;
    }

    public void setIdAssocAnnonceCritere(Integer idAssocAnnonceCritere) {
        this.idAssocAnnonceCritere = idAssocAnnonceCritere;
    }

    @Basic
    @Column(name = "valeur_int")
    public Integer getValeurInt() {
        return valeurInt;
    }

    public void setValeurInt(Integer valeurInt) {
        this.valeurInt = valeurInt;
    }

    @Basic
    @Column(name = "valeur_string")
    public String getValeurString() {
        return valeurString;
    }

    public void setValeurString(String valeurString) {
        this.valeurString = valeurString;
    }

    @Basic
    @Column(name = "valeur_double")
    public Double getValeurDouble() {
        return valeurDouble;
    }

    public void setValeurDouble(Double valeurDouble) {
        this.valeurDouble = valeurDouble;
    }

    @Basic
    @Column(name = "valeur_booleen")
    public Byte getValeurBooleen() {
        return valeurBooleen;
    }

    public void setValeurBooleen(Byte valeurBooleen) {
        this.valeurBooleen = valeurBooleen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssocAnnonceCritereEntity that = (AssocAnnonceCritereEntity) o;
        return Objects.equals(idAssocAnnonceCritere, that.idAssocAnnonceCritere) &&

                Objects.equals(valeurInt, that.valeurInt) &&
                Objects.equals(valeurString, that.valeurString) &&
                Objects.equals(valeurDouble, that.valeurDouble) &&
                Objects.equals(valeurBooleen, that.valeurBooleen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAssocAnnonceCritere, valeurInt, valeurString, valeurDouble, valeurBooleen);
    }

    public AssocAnnonceCritereEntity() {
    }
}

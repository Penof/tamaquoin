package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "assoc_annonce_critere", schema = "tamaquoin", catalog = "")
public class AssocAnnonceCritereEntity {
    private Integer idAssocAnnonceCritere;
    private Integer idAnnonce;
    private Integer idCritere;
    private Integer valeurInt;
    private String valeurString;
    private Double valeurDouble;
    private Byte valeurBooleen;

    public void setIdAssocAnnonceCritere(int idAssocAnnonceCritere) {
        this.idAssocAnnonceCritere = idAssocAnnonceCritere;
    }

    public void setIdAnnonce(int idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public void setIdCritere(int idCritere) {
        this.idCritere = idCritere;
    }

    @Id
    @Column(name = "id_assoc_annonce_critere")
    public Integer getIdAssocAnnonceCritere() {
        return idAssocAnnonceCritere;
    }

    public void setIdAssocAnnonceCritere(Integer idAssocAnnonceCritere) {
        this.idAssocAnnonceCritere = idAssocAnnonceCritere;
    }

    @Basic
    @Column(name = "id_annonce")
    public Integer getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(Integer idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    @Basic
    @Column(name = "id_critere")
    public Integer getIdCritere() {
        return idCritere;
    }

    public void setIdCritere(Integer idCritere) {
        this.idCritere = idCritere;
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
                Objects.equals(idAnnonce, that.idAnnonce) &&
                Objects.equals(idCritere, that.idCritere) &&
                Objects.equals(valeurInt, that.valeurInt) &&
                Objects.equals(valeurString, that.valeurString) &&
                Objects.equals(valeurDouble, that.valeurDouble) &&
                Objects.equals(valeurBooleen, that.valeurBooleen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAssocAnnonceCritere, idAnnonce, idCritere, valeurInt, valeurString, valeurDouble, valeurBooleen);
    }
}

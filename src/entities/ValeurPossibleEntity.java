package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "valeur_possible", schema = "2i_poo_tamacoin", catalog = "")
public class ValeurPossibleEntity {
    private Integer idValeur;
    private Integer valeurInt;
    private String valeurString;
    private Byte valeurBooleen;
    private Double valeurDouble;
    private CritereEntity critere;

    public void setIdValeur(int idValeur) {
        this.idValeur = idValeur;
    }


    @ManyToOne
    @JoinColumn(name="id_critere", referencedColumnName = "id_critere")
    public CritereEntity getCritere() {
        return critere;
    }

    public void setCritere(CritereEntity coordonnee) {
        this.critere = critere;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_valeur")
    public Integer getIdValeur() {
        return idValeur;
    }

    public void setIdValeur(Integer idValeur) {
        this.idValeur = idValeur;
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
    @Column(name = "valeur_booleen")
    public Byte getValeurBooleen() {
        return valeurBooleen;
    }

    public void setValeurBooleen(Byte valeurBooleen) {
        this.valeurBooleen = valeurBooleen;
    }

    @Basic
    @Column(name = "valeur_double")
    public Double getValeurDouble() {
        return valeurDouble;
    }

    public void setValeurDouble(Double valeurDouble) {
        this.valeurDouble = valeurDouble;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValeurPossibleEntity that = (ValeurPossibleEntity) o;
        return Objects.equals(idValeur, that.idValeur) &&
                Objects.equals(valeurInt, that.valeurInt) &&
                Objects.equals(valeurString, that.valeurString) &&
                Objects.equals(valeurBooleen, that.valeurBooleen) &&
                Objects.equals(valeurDouble, that.valeurDouble);
    }

    public ValeurPossibleEntity() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(idValeur, valeurInt, valeurString, valeurBooleen, valeurDouble);
    }
}

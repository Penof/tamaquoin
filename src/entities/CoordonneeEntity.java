package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "coordonnee", schema = "tamaquoin", catalog = "")
public class CoordonneeEntity {
    private Integer idCoordonnee;
    private String pays;
    private String ville;

    public void setIdCoordonnee(int idCoordonnee) {
        this.idCoordonnee = idCoordonnee;
    }

    @Id
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
}

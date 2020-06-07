package dao.jpa;

import dao.AnnonceDao;
import entities.AnnonceEntity;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JpaAnnonceDao extends JpaDao<AnnonceEntity> implements AnnonceDao {


    public Collection<AnnonceEntity> getAnnoncesByCriteres(Integer sousCategorie, Integer ville, String keyword, Double priceMin, Double priceMax){
        Query query = session.createSQLQuery("SELECT * " +
                "FROM annonce, sous_categorie, coordonnee " +
                "WHERE annonce.id_sous_categorie = sous_categorie.id_sous_categorie " +
                "AND annonce.id_coordonnee = coordonnee.id_coordonnee " +
                "AND sous_categorie.id_sous_categorie = IFNULL(:sousCategorie,sous_categorie.id_sous_categorie) " +
                "AND coordonnee.id_coordonnee = IFNULL(:ville, coordonnee.id_coordonnee) " +
                "AND annonce.nom LIKE IFNULL(CONCAT('%', CONCAT(:keyword, '%')), annonce.nom) " +
                "AND annonce.prix > IFNULL(:priceMin, 0) " +
                "AND annonce.prix < IFNULL(:priceMax, 999999999999)").addEntity(AnnonceEntity.class)
                .setParameter("sousCategorie", sousCategorie)
        .setParameter("ville", ville)
        .setParameter("keyword", keyword)
        .setParameter("priceMin", priceMin)
        .setParameter("priceMax", priceMax);

        final List<AnnonceEntity> results = ((NativeQuery) query).list();
        return results;
    }

    @Override
    public boolean create(AnnonceEntity obj) {
        return super.create(obj);
    }

    @Override
    public AnnonceEntity find(Class c, Integer id) {
        return super.find(AnnonceEntity.class, id);
    }

    @Override
    public Collection<AnnonceEntity> findAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("SELECT a FROM AnnonceEntity a");
        tx.commit();
        return (Collection<AnnonceEntity>) query.getResultList();

    }

    @Override
    public boolean update(AnnonceEntity obj) {
        return super.update(obj);
    }

    @Override
    public boolean delete(AnnonceEntity obj) {
        return super.delete(obj);
    }

    @Override
    public boolean deleteAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM AnnonceEntity");
        query.executeUpdate();
        tx.commit();
        return true;
    }

    @Override
    public void close() {
        super.close();
    }
}

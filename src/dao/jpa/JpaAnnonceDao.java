package dao.jpa;

import dao.AnnonceDao;
import entities.AnnonceEntity;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.Collection;

public class JpaAnnonceDao extends JpaDao<AnnonceEntity> implements AnnonceDao {


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

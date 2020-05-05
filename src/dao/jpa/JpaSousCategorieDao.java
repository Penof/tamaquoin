package dao.jpa;

import dao.CritereDao;
import dao.SousCategorieDao;
import entities.CritereEntity;
import entities.SousCategorieEntity;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.Collection;

public class JpaSousCategorieDao extends JpaDao<SousCategorieEntity> implements SousCategorieDao {


    @Override
    public boolean create(SousCategorieEntity obj) {
        return super.create(obj);
    }

    @Override
    public SousCategorieEntity find(Class c, Integer id) {
        return super.find(SousCategorieEntity.class, id);
    }

    @Override
    public Collection<SousCategorieEntity> findAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("SELECT a FROM SousCategorieEntity a");
        tx.commit();
        return (Collection<SousCategorieEntity>) query.getResultList();

    }

    @Override
    public boolean update(SousCategorieEntity obj) {
        return super.update(obj);
    }

    @Override
    public boolean delete(SousCategorieEntity obj) {
        return super.delete(obj);
    }

    @Override
    public boolean deleteAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM SousCategorieEntity");
        query.executeUpdate();
        tx.commit();
        return true;
    }

    @Override
    public void close() {
        super.close();
    }
}

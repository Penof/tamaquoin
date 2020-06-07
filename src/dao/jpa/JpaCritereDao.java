package dao.jpa;

import dao.CoordonneeDao;
import dao.CritereDao;
import entities.CoordonneeEntity;
import entities.CritereEntity;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

public class JpaCritereDao extends JpaDao<CritereEntity> implements CritereDao {

    public Collection<CritereEntity> getByCategoryId(int id_category){
        Query query = session.createQuery("SELECT c FROM CritereEntity c JOIN c.sousCategories sc WHERE sc.idSousCategorie = :id_category")
                .setParameter("id_category", id_category);
        return (Collection<CritereEntity>) query.getResultList();
    }

    @Override
    public boolean create(CritereEntity obj) {
        return super.create(obj);
    }

    @Override
    public CritereEntity find(Class c, Integer id) {
        return super.find(CritereEntity.class, id);
    }

    @Override
    public Collection<CritereEntity> findAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("SELECT a FROM CritereEntity a");
        tx.commit();
        return (Collection<CritereEntity>) query.getResultList();

    }

    @Override
    public boolean update(CritereEntity obj) {
        return super.update(obj);
    }

    @Override
    public boolean delete(CritereEntity obj) {
        return super.delete(obj);
    }

    @Override
    public boolean deleteAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM CritereEntity");
        query.executeUpdate();
        tx.commit();
        return true;
    }

    @Override
    public void close() {
        super.close();
    }
}

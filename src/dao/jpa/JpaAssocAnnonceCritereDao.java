package dao.jpa;

import dao.AssocAnnonceCritereDao;
import entities.AssocAnnonceCritereEntity;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.Collection;

public class JpaAssocAnnonceCritereDao extends JpaDao<AssocAnnonceCritereEntity> implements AssocAnnonceCritereDao {


    @Override
    public boolean create(AssocAnnonceCritereEntity obj) {
        return super.create(obj);
    }

    @Override
    public AssocAnnonceCritereEntity find(Class c, Integer id) {
        return super.find(AssocAnnonceCritereEntity.class, id);
    }

    @Override
    public Collection<AssocAnnonceCritereEntity> findAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("SELECT a FROM AssocAnnonceCritereEntity a");
        tx.commit();
        return (Collection<AssocAnnonceCritereEntity>) query.getResultList();

    }

    @Override
    public boolean update(AssocAnnonceCritereEntity obj) {
        return super.update(obj);
    }

    @Override
    public boolean delete(AssocAnnonceCritereEntity obj) {
        return super.delete(obj);
    }

    @Override
    public boolean deleteAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM AssocAnnonceCritereEntity");
        query.executeUpdate();
        tx.commit();
        return true;
    }

    @Override
    public void close() {
        super.close();
    }
}

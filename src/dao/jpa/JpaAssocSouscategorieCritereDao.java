package dao.jpa;

import dao.AssocSouscategorieCritereDao;
import entities.AssocSouscategorieCritereEntity;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.Collection;

public class JpaAssocSouscategorieCritereDao extends JpaDao<AssocSouscategorieCritereEntity> implements AssocSouscategorieCritereDao {


    @Override
    public boolean create(AssocSouscategorieCritereEntity obj) {
        return super.create(obj);
    }

    @Override
    public AssocSouscategorieCritereEntity find(Class c, Integer id) {
        return super.find(AssocSouscategorieCritereEntity.class, id);
    }

    @Override
    public Collection<AssocSouscategorieCritereEntity> findAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("SELECT a FROM AssocSouscategorieCritereEntity a");
        tx.commit();
        return (Collection<AssocSouscategorieCritereEntity>) query.getResultList();

    }

    @Override
    public boolean update(AssocSouscategorieCritereEntity obj) {
        return super.update(obj);
    }

    @Override
    public boolean delete(AssocSouscategorieCritereEntity obj) {
        return super.delete(obj);
    }

    @Override
    public boolean deleteAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM AssocSouscategorieCritereEntity");
        query.executeUpdate();
        tx.commit();
        return true;
    }

    @Override
    public void close() {
        super.close();
    }
}

package dao.jpa;

import dao.CoordonneeDao;
import entities.CoordonneeEntity;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.Collection;

public class JpaCoordonneeDao extends JpaDao<CoordonneeEntity> implements CoordonneeDao {


    @Override
    public boolean create(CoordonneeEntity obj) {
        return super.create(obj);
    }

    @Override
    public CoordonneeEntity find(Class c, Integer id) {
        return super.find(CoordonneeEntity.class, id);
    }

    @Override
    public Collection<CoordonneeEntity> findAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("SELECT a FROM CoordonneeEntity a");
        tx.commit();
        return (Collection<CoordonneeEntity>) query.getResultList();

    }

    @Override
    public boolean update(CoordonneeEntity obj) {
        return super.update(obj);
    }

    @Override
    public boolean delete(CoordonneeEntity obj) {
        return super.delete(obj);
    }

    @Override
    public boolean deleteAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM CoordonneeEntity");
        query.executeUpdate();
        tx.commit();
        return true;
    }

    @Override
    public void close() {
        super.close();
    }
}

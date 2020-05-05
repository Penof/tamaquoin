package dao.jpa;

import dao.CritereDao;
import dao.ValeurPossibleDao;
import entities.CritereEntity;
import entities.ValeurPossibleEntity;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.Collection;

public class JpaValeurPossibleDao extends JpaDao<ValeurPossibleEntity> implements ValeurPossibleDao {


    @Override
    public boolean create(ValeurPossibleEntity obj) {
        return super.create(obj);
    }

    @Override
    public ValeurPossibleEntity find(Class c, Integer id) {
        return super.find(ValeurPossibleEntity.class, id);
    }

    @Override
    public Collection<ValeurPossibleEntity> findAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("SELECT a FROM ValeurPossibleEntity a");
        tx.commit();
        return (Collection<ValeurPossibleEntity>) query.getResultList();

    }

    @Override
    public boolean update(ValeurPossibleEntity obj) {
        return super.update(obj);
    }

    @Override
    public boolean delete(ValeurPossibleEntity obj) {
        return super.delete(obj);
    }

    @Override
    public boolean deleteAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM ValeurPossibleEntity");
        query.executeUpdate();
        tx.commit();
        return true;
    }

    @Override
    public void close() {
        super.close();
    }
}

package dao.jpa;

import dao.AssocSouscategorieCritereDao;
import dao.CategorieDao;
import entities.AssocSouscategorieCritereEntity;
import entities.CategorieEntity;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.Collection;

public class JpaCategorieDao extends JpaDao<CategorieEntity> implements CategorieDao {


    @Override
    public boolean create(CategorieEntity obj) {
        return super.create(obj);
    }

    @Override
    public CategorieEntity find(Class c, Integer id) {
        return super.find(CategorieEntity.class, id);
    }

    @Override
    public Collection<CategorieEntity> findAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("SELECT a FROM AnnonceEntity a");
        tx.commit();
        return (Collection<CategorieEntity>) query.getResultList();

    }

    @Override
    public boolean update(CategorieEntity obj) {
        return super.update(obj);
    }

    @Override
    public boolean delete(CategorieEntity obj) {
        return super.delete(obj);
    }

    @Override
    public boolean deleteAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM CategorieEntity");
        query.executeUpdate();
        tx.commit();
        return true;
    }

    @Override
    public void close() {
        super.close();
    }
}

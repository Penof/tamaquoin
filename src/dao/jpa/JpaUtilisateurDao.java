package dao.jpa;

import dao.CritereDao;
import dao.UtilisateurDao;
import entities.CritereEntity;
import entities.UtilisateurEntity;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.Collection;

public class JpaUtilisateurDao extends JpaDao<UtilisateurEntity> implements UtilisateurDao {

    @Override
    public boolean create(UtilisateurEntity obj) {
        return super.create(obj);
    }

    @Override
    public UtilisateurEntity find(Class c, Integer id) {
        return super.find(UtilisateurEntity.class, id);
    }

    @Override
    public Collection<UtilisateurEntity> findAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("SELECT a FROM UtilisateurEntity a");
        tx.commit();
        return (Collection<UtilisateurEntity>) query.getResultList();

    }

    @Override
    public boolean update(UtilisateurEntity obj) {
        return super.update(obj);
    }

    @Override
    public boolean delete(UtilisateurEntity obj) {
        return super.delete(obj);
    }

    @Override
    public boolean deleteAll() {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM UtilisateurEntity");
        query.executeUpdate();
        tx.commit();
        return true;
    }

    @Override
    public void close() {
        super.close();
    }

    public UtilisateurEntity signin(String email, String password) {
        Query query = session.createQuery("SELECT u FROM UtilisateurEntity u WHERE u.mail = :email AND u.mdp = :password").setParameter("password", password).setParameter("email", email);
        return (UtilisateurEntity) query.getResultList().get(0);
    }
}

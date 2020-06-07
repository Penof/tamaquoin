import dao.AnnonceDao;
import dao.CoordonneeDao;
import dao.CritereDao;
import dao.SousCategorieDao;
import dao.jpa.JpaAnnonceDao;
import dao.jpa.JpaCoordonneeDao;
import dao.jpa.JpaCritereDao;
import dao.jpa.JpaSousCategorieDao;
import entities.AnnonceEntity;
import entities.CoordonneeEntity;
import entities.CritereEntity;
import entities.SousCategorieEntity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {


        SousCategorieDao sousCategorieManager = new JpaSousCategorieDao();
        CoordonneeDao coordonneeManager = new JpaCoordonneeDao();
        AnnonceDao annonceManager = new JpaAnnonceDao();
        CritereDao critereManager  = new JpaCritereDao();

        SousCategorieEntity sc = new SousCategorieEntity("moto");
        CritereEntity c = new CritereEntity("test", "test","test", "test");

        sc.addCritere(c);

        sousCategorieManager.create(sc);



        //List<AnnonceEntity> annonces = (List<AnnonceEntity>) ((JpaAnnonceDao) annonceManager).getAnnoncesByCriteres(null,null, null, 60.0, null);
        //System.out.println(annonces);


// Afficher l’atelier avec ses machines et les taches sur les machines
// Verifier dates de début des taches
// Verifier dates de disponibilité des machines
// Verifier pénalité total
    }
}

import dao.AnnonceDao;
import dao.CoordonneeDao;
import dao.CritereDao;
import dao.SousCategorieDao;
import dao.jpa.JpaAnnonceDao;
import dao.jpa.JpaCoordonneeDao;
import dao.jpa.JpaCritereDao;
import dao.jpa.JpaSousCategorieDao;
import entities.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {


        SousCategorieDao sousCategorieManager = new JpaSousCategorieDao();
        CoordonneeDao coordonneeManager = new JpaCoordonneeDao();
        AnnonceDao annonceManager = new JpaAnnonceDao();
        CritereDao critereManager  = new JpaCritereDao();

        List<CritereEntity> criteres = (List<CritereEntity>) ((JpaCritereDao) critereManager).getByCategoryId(6);
        System.out.println(criteres);
        List<ValeurPossibleEntity> valeursPossibles = criteres.get(0).getValeursPossibles();
        System.out.println(valeursPossibles);

        //List<AnnonceEntity> annonces = (List<AnnonceEntity>) ((JpaAnnonceDao) annonceManager).getAnnoncesByCriteres(null,null, null, 60.0, null);
        //System.out.println(annonces);


// Afficher l’atelier avec ses machines et les taches sur les machines
// Verifier dates de début des taches
// Verifier dates de disponibilité des machines
// Verifier pénalité total
    }
}

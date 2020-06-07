import dao.AnnonceDao;
import dao.CoordonneeDao;
import dao.SousCategorieDao;
import dao.jpa.JpaAnnonceDao;
import dao.jpa.JpaCoordonneeDao;
import dao.jpa.JpaSousCategorieDao;
import entities.AnnonceEntity;
import entities.CoordonneeEntity;
import entities.SousCategorieEntity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {


        SousCategorieDao sousCategorieManager = new JpaSousCategorieDao();
        CoordonneeDao coordonneeManager = new JpaCoordonneeDao();
        AnnonceDao annonceManager = new JpaAnnonceDao();
        CoordonneeEntity coordonnee = new CoordonneeEntity("France", "Lens");
        coordonneeManager.create(coordonnee);

        SousCategorieEntity sc = sousCategorieManager.find(SousCategorieEntity.class, 1);
        CoordonneeEntity coordonneeGet = coordonneeManager.find(CoordonneeEntity.class, 1);



        AnnonceEntity annonce = new AnnonceEntity("nom",new Timestamp(System.currentTimeMillis()),"description",50.45,0);

        coordonneeGet.addAnnonce(annonce);
        coordonneeManager.update(coordonneeGet);
        /*sc.addAnnonce(a);
        sousCategorieManager.update(sc);
        System.out.println(a.toString());


        //get liste categorie
        List<SousCategorieEntity> listeSousCat = new ArrayList<SousCategorieEntity>();
        listeSousCat = (List<SousCategorieEntity>) sousCategorieManager.findAll();


        //creation annonce
        */
// Afficher l’atelier avec ses machines et les taches sur les machines
// Verifier dates de début des taches
// Verifier dates de disponibilité des machines
// Verifier pénalité total
    }
}

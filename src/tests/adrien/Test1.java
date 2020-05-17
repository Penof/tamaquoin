import dao.AnnonceDao;
import dao.jpa.JpaAnnonceDao;
import entities.AnnonceEntity;

import java.sql.Timestamp;

public class Test1 {

    public static void main(String[] args) {
        AnnonceEntity a = new AnnonceEntity("test",new Timestamp(System.currentTimeMillis()),10,50.45);
        AnnonceDao annonceManager = new JpaAnnonceDao();
        annonceManager.create(a);
        System.out.println(a.toString());
// Afficher l’atelier avec ses machines et les taches sur les machines
// Verifier dates de début des taches
// Verifier dates de disponibilité des machines
// Verifier pénalité total
    }
}

package mockDBB;

import entities.AnnonceEntity;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DDB {

    public AnnonceEntity getAnnonceById(int id){
        return getAnnonces().get(0);
    }

    public List<AnnonceEntity> getAnnonces(String category, String keyWord, String city, String prixMin, String prixMax) throws ParseException {
        return getAnnonces();
    }

    private List<AnnonceEntity> getAnnonces() {
        List<AnnonceEntity> list = new ArrayList<>();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try{
            Date date = dateFormat.parse("23/09/2007");
            long time = date.getTime();
            AnnonceEntity annonce = new AnnonceEntity("POLO TDI - volkswagen",new Timestamp(time),0,135000.0);
            annonce.setIdAnnonce(1);
            annonce.setDescription("Une petite vnljbnnlknxvcmcskqmlckmqs, :knvfdoi jwdl");
            annonce.setPhoto("poloTdi.jpg");
            list.add(annonce);
        }catch (java.text.ParseException j){
            System.out.println("Error parsing date");
        };

        return list;
    }
}


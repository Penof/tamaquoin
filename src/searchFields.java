import javax.swing.*;
import java.util.Map;

public class searchFields {

    private String category;
    private int cityId;
    private String keyword;
    private String priceMin;
    private String search_priceMax;

    public searchFields(String category, int cityId, String keyword, String priceMin, String search_priceMax) {
        this.category = category;
        this.cityId = cityId;
        this.keyword = keyword;
        this.priceMin = priceMin;
        this.search_priceMax = search_priceMax;
    }
}

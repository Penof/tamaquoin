import javax.swing.*;
import java.util.Map;

public class searchFields {

    private String category;
    private String city;
    private String keyword;
    private String priceMin;
    private String priceMax;

    public searchFields(String category, String city, String keyword, String priceMin, String search_priceMax) {
        this.category = category;
        this.city = city;
        this.keyword = keyword;
        this.priceMin = priceMin;
        this.priceMax = search_priceMax;
    }

    @Override
    public String toString() {
        return "searchFields{" +
                "category='" + category + '\'' +
                ", city='" + city + '\'' +
                ", keyword='" + keyword + '\'' +
                ", priceMin='" + priceMin + '\'' +
                ", priceMax='" + priceMax + '\'' +
                '}';
    }
}
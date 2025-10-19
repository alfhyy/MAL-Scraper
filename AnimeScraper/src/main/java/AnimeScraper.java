import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AnimeScraper {
    public static void main(String[] args) {
        try {
            String url = "https://myanimelist.net/topanime.php";
            Document doc = Jsoup.connect(url).get();

            Elements titles = doc.select(".ranking-list .detail h3 a");

            System.out.println("Top Anime List:");
            for (Element title : titles) {
                System.out.println("- " + title.text());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
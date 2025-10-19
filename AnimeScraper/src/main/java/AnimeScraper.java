import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnimeScraper {
    public static void main(String[] args) {
        // Genre ID mapping
        Map<String, Integer> genreMap = new HashMap<>();
        genreMap.put("action", 1);
        genreMap.put("adventure", 2);
        genreMap.put("comedy", 4);
        genreMap.put("drama", 8);
        genreMap.put("romance", 22);
        genreMap.put("sci-fi", 24);
        genreMap.put("fantasy", 10);
        genreMap.put("sports", 30);
        genreMap.put("horror", 14);

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a genre (e.g., action, romance, comedy): ");
        String userGenre = input.nextLine().trim().toLowerCase();

        if (!genreMap.containsKey(userGenre)) {
            System.out.println("Genre not recognized. Please try again with a valid genre.");
            return;
        }

        int genreId = genreMap.get(userGenre);
        String url = "https://myanimelist.net/anime/genre/" + genreId;

        try {
            System.out.println("\nFetching Top 30 " + userGenre + " anime from MyAnimeList...");
            Document doc = Jsoup.connect(url).get();

            Elements animeTitles = doc.select(".anime-title"); // fallback selector
            if (animeTitles.isEmpty()) {
                animeTitles = doc.select(".seasonal-anime .link-title, .hoverinfo_trigger"); // alternate selector
            }

            int count = 0;
            for (Element title : animeTitles) {
                System.out.println((++count) + ". " + title.text());
                if (count == 30) break; // Limit to top 30
            }

            if (count == 0) {
                System.out.println("No anime found or website structure changed.");
            }

        } catch (Exception e) {
            System.out.println("Error fetching data: " + e.getMessage());
        }
    }
}

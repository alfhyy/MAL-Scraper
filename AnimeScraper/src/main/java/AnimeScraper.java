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

        String[] genres = userGenre.split(",");

        for (String g : genres) {
            String trimmed = g.trim();
            if (!genreMap.containsKey(trimmed)) {
                System.out.println("Genre not recognized: " + trimmed);
                continue;
            }

            int genreId = genreMap.get(trimmed);
            String url = "https://myanimelist.net/anime/genre/" + genreId;

            Thread thread = new Thread(() -> {
                try {
                    System.out.println("\nFetching Top 30 " + trimmed + " anime from MyAnimeList...");
                    Document doc = Jsoup.connect(url).get();

                    Elements animeTitles = doc.select("a.hoverinfo_trigger.fw-b.fl-l");
                    if (animeTitles.isEmpty()) {
                        animeTitles = doc.select(".seasonal-anime .link-title, .hoverinfo_trigger");
                    }

                    int count = 0;
                    for (Element title : animeTitles) {
                        System.out.println((++count) + ". " + title.text());
                        if (count == 30) break;
                    }

                    if (count == 0) {
                        System.out.println("No anime found for " + trimmed + " or website structure changed.");
                    }
                } catch (Exception e) {
                    System.out.println("Error fetching " + trimmed + ": " + e.getMessage());
                }
            });

            thread.start();
        }
    }
}

Anime Scraper
A simple Java-based web scraper that fetches the top 30 anime titles from MyAnimeList based on user-selected genres.
Features

🎭 Scrapes anime titles by genre from MyAnimeList
🔄 Supports multiple genres in a single search
⚡ Uses multithreading for concurrent genre fetching
📝 Simple command-line interface

Supported Genres
GenreIDAction1Adventure2Comedy4Drama8Romance22Sci-Fi24Fantasy10Sports30Horror14
Prerequisites

Java Development Kit (JDK) 8 or higher
JSoup library for HTML parsing

Installation

Clone or download the project
Download JSoup library

Download the JSoup JAR file from jsoup.org
Or add via Maven:



xml   <dependency>
       <groupId>org.jsoup</groupId>
       <artifactId>jsoup</artifactId>
       <version>1.17.2</version>
   </dependency>

Compile the program

bash   javac -cp .:jsoup-1.17.2.jar AnimeScraper.java
On Windows, use semicolon (;) instead of colon (:)
bash   javac -cp .;jsoup-1.17.2.jar AnimeScraper.java
Usage

Run the program

bash   java -cp .:jsoup-1.17.2.jar AnimeScraper
On Windows:
bash   java -cp .;jsoup-1.17.2.jar AnimeScraper

Enter a genre when prompted

   Enter a genre (e.g., action, romance, comedy): action

For multiple genres, separate with commas

   Enter a genre (e.g., action, romance, comedy): action, romance, fantasy
Example Output
Enter a genre (e.g., action, romance, comedy): action

Fetching Top 30 action anime from MyAnimeList...
1. One Piece
2. Demon Slayer: Kimetsu no Yaiba
3. Attack on Titan
4. Jujutsu Kaisen
...
30. Fullmetal Alchemist: Brotherhood
How It Works

User inputs desired genre(s)
Program maps genre names to MyAnimeList genre IDs
Creates separate threads for each genre to fetch data concurrently
Uses JSoup to parse HTML from MyAnimeList genre pages
Extracts and displays the top 30 anime titles

Technical Details

Language: Java
Libraries: JSoup (HTML parsing)
Threading: Uses Java's Thread class for concurrent scraping
Web Scraping Target: MyAnimeList (https://myanimelist.net)

Limitations

Depends on MyAnimeList's HTML structure (may break if website changes)
Only fetches top 30 titles per genre
Requires internet connection
No advanced filtering or sorting options

Troubleshooting
"No anime found" error

The website structure may have changed
Check your internet connection
Verify the URL is accessible

"Genre not recognized" error

Make sure the genre is spelled correctly
Use lowercase genre names
Check the supported genres list above

Compilation errors

Ensure JSoup JAR is in the correct path
Verify JDK is properly installed
Check classpath syntax for your OS

Future Improvements

 Add more genres
 Implement pagination for more than 30 results
 Add rating and score filtering
 Export results to CSV or JSON
 Create GUI interface
 Add caching to reduce API calls

Disclaimer
This project is for educational purposes only. Please respect MyAnimeList's Terms of Service and robots.txt file. Avoid excessive scraping that could burden their servers.
License
This project is open source and available for educational use.
Author
Created as a learning project for web scraping with Java and JSoup.

Note: Web scraping may violate websites' terms of service. Always check the website's robots.txt and terms before scraping.

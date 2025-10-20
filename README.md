# Anime Scraper

A simple **Java-based web scraper** that fetches the **top 30 anime titles** from [MyAnimeList](https://myanimelist.net) based on user-selected genres.

---

## Features

- 🎭 Scrapes anime titles by genre from MyAnimeList  
- 🔄 Supports multiple genres in a single search  
- ⚡ Uses multithreading for concurrent genre fetching  
- 📝 Simple command-line interface  

---

## Supported Genres

| Genre | ID |
|--------|----|
| Action | 1 |
| Adventure | 2 |
| Comedy | 4 |
| Drama | 8 |
| Romance | 22 |
| Sci-Fi | 24 |
| Fantasy | 10 |
| Sports | 30 |
| Horror | 14 |

---

## Prerequisites

- **Java Development Kit (JDK)** 8 or higher  
- **Jsoup** library for HTML parsing  

---

## Installation

### 1. Clone or download the project
```bash
git clone https://github.com/yourusername/anime-scraper.git
cd anime-scraper
```

## How’s the Program Work?

1. 🖥️ The user runs the program from the terminal or command prompt.  
2. 💬 The program prompts the user to enter one or more anime genres  
   (for example: `action, romance, comedy`).  
3. 🔍 Each entered genre is matched with its corresponding **MyAnimeList genre ID**.  
4. 🧵 For every valid genre, a **separate thread** is created using Java’s multithreading feature.  
5. 🌐 Each thread connects to [MyAnimeList](https://myanimelist.net) using **Jsoup**,  
   retrieves the HTML of the selected genre page, and extracts the **anime titles**.  
6. 🎯 The program limits the output to the **top 30 anime titles** per genre.  
7. 📜 The results are displayed in the console, while invalid or misspelled genres are skipped.  
8. ✅ Once all threads finish execution, the program terminates automatically.  

## Future Improvements

- ➕ Add more supported genres beyond the current list.
- 👥 Add mutiple user inputs.  
- 📊 Include anime scores, ranks, and number of episodes.  
- 📁 Export results to CSV or JSON files for easier data use.  
- 🖥️ Create a simple GUI interface using JavaFX or Swing.  
- 🔁 Implement pagination to fetch more than 30 results per genre. 
- 🧠 Improve error handling and automatic retry for failed requests.  
- 🕵️ Detect and adapt to changes in MyAnimeList’s HTML structure.  




package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();

    public Book(String title) {
        super(title);
    }
    
    public Book(String title, String category) {
        super(title, category);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public List<String> getAuthors() {
        return authors;
    }
    
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author: " + authorName + " is added to the book.");
        }
        else System.out.println("Author: " + authorName + " is already associated with the book.");
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author: " + authorName + " is removed from the book");
        }
        else System.out.println("Author: " + authorName + " is not associated with the book."); 
    }
    
}

package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media {
    private String director;
    private int length;

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, cost);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public void displayDetails() {

        if (this.getTitle() != null) {
            System.out.println("Title: " + this.getTitle());
        }
        if (this.getCategory() != null) {
            System.out.println("Category: " + this.getCategory());
        }
        if (this.getDirector() != null) {
            System.out.println("Director: " + this.getDirector());
        }
        if (this.getLength() > 0) {
            System.out.println("Length: " + this.getLength());
        }
        if (this.getCost() > 0) {
            System.out.println("Cost: " + this.getCost());
        }
    }


    public boolean isMatch(String title) {
        String[] keywords = title.toLowerCase().split(" ");
        String discTitle = this.getTitle().toLowerCase();
        for (String keyword : keywords) {
            if (!discTitle.contains(keyword)) {
                return false;
            }
        }
        return true;
    }
    
    public String toString() {
        return " DVD - " + getTitle() + " - " + getCategory() + " - " + director + " - " + length + ": " + getCost() + " $";
    }
}
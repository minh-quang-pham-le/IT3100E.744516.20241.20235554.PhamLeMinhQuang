package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
    
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private int id;
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this(title);
        this.category = category;
        this.cost = cost;

        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this(title);
        this.category = category;
        this.director = director;
        this.cost = cost;

        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this(title);
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;

        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
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

    public void setTitle(String title) {
        this.title = title;
    }
}
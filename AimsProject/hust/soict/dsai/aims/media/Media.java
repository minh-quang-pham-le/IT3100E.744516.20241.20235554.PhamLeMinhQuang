package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    private static int nbMedias = 0;
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(String title) {
        this.title = title;
        nbMedias++;
        this.id = nbMedias;
    }

    public Media(String title, String category) {
        this.title = title;
        this.category = category;
        nbMedias++;
        this.id = nbMedias;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbMedias++;
        this.id = nbMedias;
    }

    public int getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Media media = (Media) obj;
        return title.equals(media.title);
    }

    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Category: " + category + ", Cost: " + cost;
    }
}

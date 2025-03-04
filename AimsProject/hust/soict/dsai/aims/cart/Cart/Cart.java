package hust.soict.dsai.aims.cart.Cart;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Collections;

public class Cart {
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public boolean addMedia(Media media) {
        itemsOrdered.add(media);
        System.out.println("Added " + media.getTitle() + " to the cart.");
        return true;
    }

    public boolean removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed " + media.getTitle() + " from the cart.");
            return true;
        }
        else {
            System.out.println("Item not found in the cart.");
            return false;
        }
    }
    
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) { 
            System.out.println((i+1) + "." + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void searchByID(int id) {
        boolean match = false;
        for (Media media : itemsOrdered) {
            if (media.getID() == id) {
                System.out.println("Found a match: " + media.toString());
                match = true;
                break;
            }
        }
        if (!match) System.out.println("No match found.");
    }

    public void searchByTitle(String title) {
        boolean match = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains((title.toLowerCase()))) {
                System.out.println("Found a match: " + media.toString());
                match = true;
                break;
            }
        }
        if (!match) System.out.println("No match found.");
    }

    public int getSize() {
        return this.itemsOrdered.size();
    }

    public void sortByTitle() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCost() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public Media searchMedia(String title) {
		for (Media media: this.itemsOrdered) {
			if (media.getTitle().toLowerCase().equals(title.toLowerCase())) {
				return media;
			}
		}
		return null;
	}

    public ObservableList<Media> getItemsOrdered() {
        return this.itemsOrdered;
    }

    public void empty() {
		this.itemsOrdered.clear();
	}
}

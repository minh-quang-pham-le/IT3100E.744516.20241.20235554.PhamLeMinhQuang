public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    
    public boolean addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc " + disc.getTitle() + " has been added.");
            return true;
        }
        else {
            System.out.println("The cart is almost full.");
            return false;
        }
    }

    public boolean removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle().equals(disc.getTitle())) {
                for (int j = i + 1; j < qtyOrdered; j++) {
                    itemsOrdered[j-1] = itemsOrdered[j];
                }
                itemsOrdered[qtyOrdered-1] = null; 
                qtyOrdered--;
                System.out.println("The disc " + disc.getTitle() + " has been removed.");
                return true;
            }
        }
        System.out.println("The disc " + disc.getTitle() + " is not in the cart.");
        return false;
    }
    
    public float totalCost() {
        float total = 0;
        for (DigitalVideoDisc item : itemsOrdered) {
            if (item == null) return total;
            else total += item.getCost();
        }
        return total;
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }
}

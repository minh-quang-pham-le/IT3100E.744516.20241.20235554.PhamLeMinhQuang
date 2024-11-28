package hust.soict.dsai.aims.media;

public class CompactDisc extends Disc {
    public CompactDisc(String title) {
        super(title);
    }
    
    public CompactDisc(String title, String category) {
        super(title, category);
    }

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
}

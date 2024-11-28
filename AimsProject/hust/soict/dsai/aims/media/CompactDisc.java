package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(String title) {
        super(title);
    }
    
    public CompactDisc(String title, String category) {
        super(title, category);
    }

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, String artist, String director, float cost) {
        super(title, category, director, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, String artist, String director, int length, float cost) {
        super(title, category, director, length, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public boolean addTrack(Track track) {
        if (tracks == null) tracks = new ArrayList<>();
        if (this.tracks.contains(track)) {
            System.out.println("The track " + track.getTitle() + " is already in the tracklist of " + this.getTitle());
            return false;
        }
        else {
            this.tracks.add(track);
            System.out.println("The track " + track.getTitle() + " is added to the tracklist of " + this.getTitle());
            return true;
        }
    }

    public boolean removeTrack(Track track) {
        if (this.tracks.remove(track)) {
            System.out.println("The track " + track.getTitle() + " is removed from the tracklist of " + this.getTitle());
            return true;
        }
        else {
            System.out.println("The track " + track.getTitle() + " is not in the tracklist of " + this.getTitle());
            return false;
        }
    }

    public int getLength() {
        if (tracks == null) {
            tracks = new ArrayList<>();
        }
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("Artist: " + this.getArtist());
        System.out.println("CD Length: " + this.getLength());

        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        return "ID: " + getID() +", Title: " + getTitle() + ", Category: " + getCategory() + ", Cost: " + getCost() + ", Artist: " + artist + ", Length: " + getLength();
    }
}

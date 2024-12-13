package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import hust.soict.dsai.aims.exception.PlayerException;

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

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
			throw new PlayerException("ERROR: CD length is non-positive!");
		} else {
			System.out.println("Playing CD: " + this.getTitle());
			
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			JPanel p = new JPanel();
			JDialog d = new JDialog();
			JLabel l1 = new JLabel("Now playing: " + this.getTitle());
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
			l1.setAlignmentX(Component.CENTER_ALIGNMENT);
			d.setTitle("Media Player");
			p.add(Box.createVerticalGlue());
			p.add(l1);
			p.add(Box.createVerticalGlue());
			d.add(p);
			d.setSize(250,100);
			int w = d.getSize().width;
	        int h = d.getSize().height;
	        int x = (dim.width - w) / 2;
	        int y = (dim.height - h) / 2;
			d.setLocation(x, y);
			d.setVisible(true);
			
			for (Track track: this.tracks) {
				try {
					track.play();
                    throw new PlayerException();
				} catch (PlayerException e) {
					throw e;
				}
			}
		}
    }

    @Override
    public String toString() {
        return "ID: " + getID() +", Title: " + getTitle() + ", Category: " + getCategory() + ", Cost: " + getCost() + ", Artist: " + artist + ", Length: " + getLength();
    }
}

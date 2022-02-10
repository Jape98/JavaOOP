package hw5;

import java.util.Comparator;

public class SongComparator implements Comparator<Song> {

	
	public int compare(Song s1, Song s2) {
		
		return (int) (s2.rating - s1.rating);
	}
}

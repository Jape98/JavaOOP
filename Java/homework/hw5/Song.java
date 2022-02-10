package hw5;

public class Song implements Comparable<Song> {
	
	String song, artist, duration;
	double rating;

	public Song(String artist, String song, String duration, double rating ) {
	
		this.song = song;
		this.artist = artist;
		this.duration = duration;
		this.rating = rating;
	}
	
	public String getSong() {
		return song;
	}

	public String getArtist() {
		return artist;
	}

	public String getLength() {
		return duration;
	}

	public double getRating() {
		return rating;
	}
	
	public String toString() {
		return "Name: " + this.song+ ", Artist: " + this.artist + ", Duration: " + this.duration + ", Rating: " + this.rating;
	}

	public int compareTo(Song a) {
		
		return song.compareTo(a.song);
	}

}

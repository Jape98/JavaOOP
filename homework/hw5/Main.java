package hw5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Song> songs = new ArrayList<Song>();
		
		songs.add(new Song("The Cure", "A forest", "05:55", 2));
		songs.add(new Song("Dead Can Dance", "Opium", "05:45", 2));
		songs.add(new Song("Fred Astairey", "Puttin On the Ritz","04:32", 3));
		songs.add(new Song("Judas Priest", "Nostradamus", "06:45", 4));
		songs.add(new Song("Judas Priest", "Future of mankind",	"08:30", 4));
		songs.add(new Song("Tom Waits",	"I'll be gone",	"03:13", 5));
		songs.add(new Song("Tom Waits",	"Misery is the river of the world",	"04:25", 5));
		
				
		int loop=1;
		Scanner input=new Scanner(System.in);
        while (loop==1){
        	
        	System.out.println("Valitse: 1: Suodata kappaleen mukaan, 2: Suodata arvion mukaan, 3: Suodata Esittäjän mukaan, 4: Etsi artistia(kovakoodattu artisti)");
        	int valinta = input.nextInt();
			switch(valinta) {
        	
        	case 1:
        		Collections.sort(songs);
        		for(Song s:songs){  
        			
        			System.out.println(s.toString());   
        			}
        		
        		break;
        		
        	case 2:
        		Collections.sort(songs, new SongComparator());
        		
        		for(Song s:songs){
        			
        			System.out.println(s.toString()); 
        			}
        		
        		break;
        		
        	case 3:
        		songs.sort((s1,s2) -> s1.getArtist().compareTo(s2.getArtist()));
        		
        		for(Song s:songs){
        			
        			System.out.println(s.toString()); 
        			}
        		
        		break;
        		
        	case 4:
        		songs.stream().filter((song)->song.getArtist().startsWith("Tom")).sorted((s1,s2) -> s1.getLength().compareTo(s2.getLength())).forEach(System.out::println);
        		
        		break;

        	default:
        		System.out.println("Komentoa ei ole olemassa");
        		
        		break;

        	}
			System.out.println("\n");
	    }
        input.close();
	}
}

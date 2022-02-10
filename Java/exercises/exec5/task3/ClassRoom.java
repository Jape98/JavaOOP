package exec5.task3;
import java.util.Scanner;

public class ClassRoom extends Room{
    private int seats, computers;
    boolean videotykki;
    
    Scanner input=new Scanner(System.in);
    
    public String toString(){
        return super.toString()+", Amount of seats: "+this.seats+", Amount of computers: "+this.computers+", projector: "+this.videotykki;
    }
    

    public void askRoom() {
    	
        super.askRoom();
        
        System.out.println("Amount of seats: ");
        this.seats=input.nextInt();
        
        System.out.println("Amount of computers: ");
        this.computers=input.nextInt();
        
        System.out.println("Is there a projector?: true/false");
        this.videotykki=input.nextBoolean();
    }

    public String getDescription() {
        return super.getDescription();
    }
    
    public String getID() {
        return super.getID();
    }
    
    
}
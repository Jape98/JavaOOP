package exec5.task3;
import java.util.Scanner;


public class Room {
		
    private String description, ID;
    Scanner input=new Scanner(System.in);
    
	    public String getID(){    	
	        return this.ID;
	    }
	    
	    public String getDescription(){
	        return this.description;
	    }

	    public void askRoom(){
	    		        
	        System.out.println("Enter room number/ID: ");
	        this.ID=input.nextLine();
	        
	        System.out.println("Dercription of the room: ");
	        this.description=input.nextLine();
	        

	    }

	    public String toString(){
	    	
	        return"Room ID: " + this.ID + ", Desc: " + this.description;
	    }
}
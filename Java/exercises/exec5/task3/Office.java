package exec5.task3;
import java.util.Scanner;


public class Office extends Room {
	
    private String workerName;
    Scanner input=new Scanner(System.in);
    
    public String toString(){
        return super.toString()+", "+this.workerName;
    }

    public void askRoom() {
        super.askRoom();
        
        
        System.out.println("Tyäntekijät: ");
        this.workerName = input.nextLine();
    }
    
    public String getDescription() {
        return super.getDescription();
    }
    
    public String getID() {
        return super.getID();
    }
    
    public boolean emplpoyeeCheck(String name){
        
        if(this.workerName.contains(name)){
            return true; 
        }else{
           return false; 
        }
    }
    
}
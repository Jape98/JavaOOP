package exec5.task3;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
    	
        ArrayList<Room> rooms=new ArrayList<Room>();
        Scanner input=new Scanner(System.in);
 
        int loop=1;
        while (loop==1){
        	
        	System.out.println("Valitse 1:Add classroom, 2:Add Office, 3:Add other room, 4:Print All rooms, 5:Print classrooms, 6:Print offices, 7:Print other rooms, 8: Search by id, 9:Find office Id by name, 0:exit");
        	int valinta = input.nextInt();
			switch(valinta) {
        	
        	case 1:
        		ClassRoom cr = new ClassRoom();
        		cr.askRoom();
                rooms.add(cr);
        		
        		break;
        		
        	case 2:
        		Office ofic=new Office();
                ofic.askRoom();
                rooms.add(ofic);
        		break;
        		
        	case 3:
        		Room rm=new Room();
                rm.askRoom();
                rooms.add(rm);
        		break;
        		
        	case 4:
        		for(int i=0;i<rooms.size();i++){
                    System.out.println(rooms.get(i).toString());
                }
;
        		
        		
        		break;
        		
        	case 5:
        		//lambda
				rooms.stream().filter(room -> room instanceof ClassRoom).forEach(value -> System.out.print(value + "\n"));

        		break;
        		
        	case 6:
        		//lambda
				rooms.stream().filter(room -> room instanceof Office).forEach(value -> System.out.print(value + "\n"));

        		break;
        		
        	case 7:
        		//lambda
				rooms.stream().filter(room -> room instanceof Room).forEach(value -> System.out.print(value + "\n"));
				
        		break;
        		
        	case 8:
        		System.out.println("Enter room ID: ");
        		input.nextLine();
                String ID=input.nextLine();
                
                rooms.stream().filter(room -> room.getID().startsWith(ID)).forEach(value -> System.out.print(value + "\n"));
                
        		break;
        		
        	case 9:
        		System.out.println("Enter employee name:");
                String name=input.next();

                for(int i=0;i<rooms.size();i++){
                        
                	if(rooms.get(i) instanceof Office){
                            
                		if(((Office)rooms.get(i)).emplpoyeeCheck(name)){
                               System.out.println(rooms.get(i).toString());

                           }
                        }
                    }
                    break;
             
        	case 0:
        		loop=0;
        		break;

        	}
        }
    input.close();
   	} 
}

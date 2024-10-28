
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Login {
    String sUserName; //Holds username when user logs in
    String sPassword; //Holds password when user logs in
     String sFirst ; //Holds firstname when user registers
     String sLast ; //Holds lastname when user registers
   String password1 ; //Holds the password entered when user registers
     String userName1 ; //Holds username entered when user registers
     
     /*Following method checks if username is correctly formatted*/
    public boolean checkUsername(){
        
    
   boolean check=false;
    for(int i=0; i<userName1.length(); i++){
   if(userName1.length() <=5){
       
   if((int)userName1.charAt(i) ==95)
       check=true;
   }
    }
    return check;
   } 
    /*Following method checks if password meets the required complexity 
      it will only retun true if the complexity standard/condition is met*/
     public boolean checkPasswordComplexity(){

         boolean CapitalLetter=false;  
  boolean Number =false;
  boolean Special=false;
 for(int i=0; i<password1.length(); i++){
   if(password1.length() >= 8){ 
   if((int)password1.charAt(i) >65 &&(int)password1.charAt(i) <=90) {
       CapitalLetter=true;
   }  
  if((int)password1.charAt(i) >=48 &&(int)password1.charAt(i) <=57){
       Number=true;
               }          
   if((int)password1.charAt(i) >=33 &&(int)password1.charAt(i) <=47 || 
           (int)password1.charAt(i) >=58 &&(int)password1.charAt(i) <=64 || 
           (int)password1.charAt(i) >=91 &&(int)password1.charAt(i) <=96 || 
           (int)password1.charAt(i) >=123 &&(int)password1.charAt(i) <=126)   
          Special=true;
   }

       
   }
return CapitalLetter && Number && Special;
}

                
  /*the method below gives full feedback on both true/false conditions and whether or not you have to re-enter*/  
  public String registerUser(){
 
  if(checkUsername()==true){
           System.out.println("Username succefully captured.");
       }else{
           System.out.println("Username is not correctly formatted,please ensure that your Username contains an underscore and is no more than 5 characters in length.");
       }   
       if(checkPasswordComplexity()==true){
           System.out.println("Password succefully captured.");
       }else{
           System.out.println("Password is not correctly formatted please ensure that the password contains atleast 8characters, a capital letter , a number and a special character.");
       }
           if(checkUsername()==true && (checkPasswordComplexity()==true)){
         System.out.println("The two above conditions have been met and the user has been registered succefully.");  
         
           }
         if(checkPasswordComplexity()==false){
               System.out.println("The Password does not meet the complexity requirements.");      
         }
     if(checkUsername()==false){
         System.out.println("The username is incorrectly formatted.");
         
     }
      

       return("") ;
}
 //Following module checks if your username and password matches the registration ones provided
  public boolean loginUser(){
      
 boolean Compare=false;
   
 if(userName1.equals(sUserName) && (password1.equals(sPassword))){
     
     Compare=true;
 }
    return Compare;
}
 //Folloing method returns your login status be it successfully loggedin or failed
 public String returnLoginStatus(){
         
     
if(loginUser()==true) {
    
    
    System.out.println("Successful login");
    
        System.out.println("welcome " +" "+ sFirst+" " +" "+ " "+sLast+" " + " it is great to see you again " );

}
else{

     System.out.println("A failed login"); 
     System.out.println("Username or Password incorrect please try again");
            
}  
     

    return"";
} 
         
       
    





public static void main(String[] args) {
        Login login = new Login();
        Task info = new Task();
                 Scanner input = new Scanner(System.in);

                 
         System.out.println("Enter Firstname :");
           login.sFirst=input.next();
System.out.println("Enter Lastname :");
           login.sLast=input.next();
            System.out.println("Enter Username :");
                    login.userName1=input.next();
           System.out.println("Enter Password :");
                    login.password1=input.next();

             System.out.println(login.registerUser());   
          if(login.checkUsername()==true & (login.checkPasswordComplexity())==true){

              System.out.println("Enter Username :");
     login.sUserName=input.next();
    System.out.println("Enter Password :");
       login.sPassword=input.next();
       
      System.out.println(login.returnLoginStatus()); 
          }
        if (login.loginUser()==true) {
            JOptionPane.showMessageDialog(null, "Welcome, it is great to see you.");
            int choice;
            do {
                
                info.input = JOptionPane.showInputDialog("Choose an option:\n1. Add tasks\n2. Show report\n3. Quit");
                choice = Integer.parseInt(info.input);

                switch (choice) {
                    case 1:
                        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks:"));
                        Task task = new Task();
                        int totalHours = 0;
                           //folowing For loop promps a user to enter task details based on the number of tasks selected
                        for (int i = 0; i < numTasks; i++) {
                            String taskName = JOptionPane.showInputDialog("Enter task name:");
                            info.taskDescription = JOptionPane.showInputDialog("Enter task description:");
                            /*Following While loop will keep prompting the user to re-enter the 
                              task defination if it exceeds 50 characters*/ 
                            while(info.checkTaskDescription()==false){
                                JOptionPane.showMessageDialog(null, "Task defination incorrectly formatted, please try again");
                                info.taskDescription = JOptionPane.showInputDialog("Enter task description: ");
                        }
                            String developerFirstName = JOptionPane.showInputDialog("Enter developer's first name:");
                            String developerLastName = JOptionPane.showInputDialog("Enter developer's last name:");
                            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration:"));

                            String taskID = task.createTaskID(taskName, i, developerLastName);//generates  task ID using task name anddeveloper's lastname
                            String taskStatus = "";

        int option = Integer.parseInt(JOptionPane.showInputDialog("Please choose the Status of this task from the three options.\n"
                + "1.To Do\n"
                + "2.Doing\n"
                + "3.Done"));
        switch(option){
            case 1:
                taskStatus = "To Do";
                break;
            case 2:
                taskStatus = "Doing";
                break;
            case 3:
                taskStatus = "Done";
                break;
        }     String taskDetails = task.printTaskDetails(taskStatus, developerFirstName, developerLastName,
                                    i, taskName, info.taskDescription, taskID, taskDuration);
                            JOptionPane.showMessageDialog(null, taskDetails);//Presents full task details on a JOptionPane

                            totalHours += taskDuration;
                        }

                        JOptionPane.showMessageDialog(null, "Total hours: " + totalHours);
                        break;

                    case 2:
                        JOptionPane.showMessageDialog(null, "Coming Soon");
                        break;

                    case 3:
                        JOptionPane.showMessageDialog(null, "Exiting the application.");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                        break;
                }
            } while (choice != 3);
        } else {
            JOptionPane.showMessageDialog(null, "Username or password incorrect. Please try again.");
        }
    }}
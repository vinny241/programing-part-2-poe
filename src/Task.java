public class Task {
    String input="";
    String taskDescription;
    
    //Boolean method below only returns true if description is less than 51 characters long
    public boolean checkTaskDescription() {
       Boolean Verify=false;
       for (int i=0; i<taskDescription.length(); i++){
           if (taskDescription.length() <= 50){
               Verify = true;
           }
       }
    return Verify;
    }
    /*The below method will auto generates an ID for each task using task details provided by the user*/
    public String createTaskID(String taskName, int taskNumber, String developerLastName) {
        String taskID = taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" +
                developerLastName.substring(developerLastName.length() - 3).toUpperCase();
        return taskID;
    }
     //Method below returns full details about a single task
    public String printTaskDetails(String taskStatus, String developerFirstName, String developerLastName, int taskNumber,
                                   String taskName, String taskDescription, String taskID, int taskDuration) {
        String details = "Task Status: " + taskStatus + "\nDeveloper: " + developerFirstName + " " + developerLastName +
                "\nTask Number: " + taskNumber + "\nTask Name: " + taskName + "\nTask Description: " +
                taskDescription + "\nTask ID: " + taskID + "\nTask Duration: " + taskDuration + " hours";
        return details;
    }
   
    public int returnTotalHours(int... durations) {
        int total = 0;
        for (int duration : durations) {
            total += duration;
        }
        //Method below returns the otal number of hours needed to complete all the tasks
        return total;
    }
}

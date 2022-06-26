package activities;

//Exception activity

class CustomException extends Exception{
    String message;

    CustomException(String message){
        this.message = message;
    }
    @Override
    public String getMessage(){
        return message;
    }
}
public class Activity8 {
    static void exceptionTest(String message) throws CustomException{
        if(message == null)
            throw new CustomException("String is null");
        else
            System.out.println(message);
    }
    public static void main(String[] args){
        try{
            Activity8.exceptionTest("Will print to console");
            Activity8.exceptionTest(null);
            Activity8.exceptionTest("Won't Execute");
        }catch(CustomException ce){
            System.out.println("Inside catch block " + ce.getMessage());
        }

    }
}

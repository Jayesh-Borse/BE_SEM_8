import java.rmi.*;

public class SearchClient {

    public static void main(String []args) {

        try {

            String answer, value = "Hello";

            Search access = (Search) Naming.lookup("rmi://localhost:1900/myServer");

            answer = access.query(value);

            System.out.println("Article named " + value + " " + answer + " at myServer");

        }
        catch(Exception e) {
            e.printStackTrace();
        }

        
    }

}
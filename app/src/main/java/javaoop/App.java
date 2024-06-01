/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package javaoop;
import java.util.Scanner;

public class App  extends CharPattern{
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        //System.out.println(new App().getGreeting());
        String username = "John";
        User John = new User();
        John.setName(username);
        System.out.println(John.getName());
//        System.out.println("\n");
        System.out.println("Phone no: " + John.getPhoneNo());

        Scanner sc = new Scanner(System.in);
/*         CharPattern check = new CharPattern();

        System.out.println("Compare word pattern");
        System.out.println("Enter first word");
        String firstwd = sc.nextLine();
        System.out.println("Enter second word");
        String lastwd = sc.nextLine();

        if(check.patternCheck(firstwd, lastwd)){
            System.out.println("Pattern match");
        }else{
            System.out.println("Pattern mismatch");
        }
*/
        System.out.println("Check substring");
        Substr Subcheck = new Substr();
        String sub1 = sc.nextLine();
        String sub2 = sc.nextLine();

        Subcheck.setString(sub1);
        if (Subcheck.isSubstr(sub2)){
            System.out.println("" + sub2 + " is a sub string of " + sub1);
        }else{
            System.out.println("" + sub2 + " is not a sub string of " + sub1);
        }

        sc.close();
        GetTools gett = new GetTools();
        System.out.println("Get status Api");
        gett.getStatusApi();
        System.out.println("Get Tools Api");
        gett.getToolsApi();
        System.out.println("Get tool by Id");
        WrapperService.getToolsById(1225);

//        System.out.println("\nRegistering client.......");
//        gett.registerApi("Aaron", "deaaronsamuel@gmail.com");

    }
}
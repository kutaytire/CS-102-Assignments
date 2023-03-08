
    import java.util.Scanner;
    public class EquationTester {
    public static void main(String[] args)
    {  

        Scanner scan = new Scanner(System.in);
        Equation eq,eq2;
        int a,b,c;

        // Main  

        System.out.println("Enter the value of a, b and c for first equation: ");

        a = scan.nextInt();
        b = scan.nextInt();
        c = scan.nextInt();

        eq = new Equation(a,b,c );   

        System.out.println("Enter the value of a, b and c for second equation: ");

        a = scan.nextInt();
        b = scan.nextInt();
        c = scan.nextInt();

        eq2 = new Equation(a,b,c); 
        
        System.out.println("Sum of the equations are " + eq.add(eq2));
        System.out.println("Substraction of the equations are " + eq.substract(eq2));

        if (eq.equals(eq2)) {

            System.out.println("Equations are equal");
        }

        else {

            System.out.println("Equations aren't equal");
        }
    }
    
}

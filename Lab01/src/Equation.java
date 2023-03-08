public class Equation {
   
    // Properties

    private int a;
    private int b;
    private int c;

    // Constructor

    public Equation(int theA, int theB, int theC) {

        if ( b >= 0) {
            a = (theA);
            b = (theB);
            c = (theC);
        }
        else {

            a = -(theA);
            b = -(theB);
            c = -(theC);

        }
    }

    // Methods

    /*
        This method reduces the equation into its simplest form by finding the gcd and dividing
        the coefficients by gcd.
    */

    public void reduceEquation() {

        if ( b < 0) {

            a = -a;
            b = -b;
            c = -c;
        }
        
        int gcd = gcd3(a, b, c);
        a = a / gcd;
        b = b / gcd;
        c = c / gcd;

    }

    /*
        This method finds the gcd of 2 numbers using the Eucladian method.
        @param int num1, int num2
        @return int gcd
    */
    private int gcdFinder(int num1, int num2) {

        if (num1 == 0 && num2 != 0) {

            return num2;
        }

        else if ( num2 == 0 && num1 != 0) {

            return num1;
        }

        else if ( num2 == 0 && num1 == 0) {

            return 1;
        }

        else {

            if (num2 > num1) {

                int temp = num1;
                num1 = num2;
                num2 = temp;
            }

            int gcd = 1;
            int rem = num1 % num2;
            int preRem = num2;

            if (rem == 0) {

                gcd = num2;
            }

            else {

                while (rem != 0) {

                    int tmp = rem;
                    rem = preRem % rem;
                    preRem = tmp;
                    

                }

                gcd = preRem;
            }

            System.out.println("gcd " + gcd);
            return gcd;
        }
    }

    public int gcd3(int num1, int num2, int num3) {

        int gcd1 = gcdFinder(num1, num2);
        int finalgcd = gcdFinder(gcd1, num3);

        return finalgcd;
    }

    public int geta() {
        return a;
    }

    public int getb() {
        return b;
    }

    public int getc() {
        return c;
    }

    public Equation add(Equation eq2) {

        Equation newEq = new Equation(0,0,0);
        newEq.a = a + eq2.a;
        newEq.b = b + eq2.b;
        newEq.c = c + eq2.c;

        // For testing purposes
        /*
        System.out.println(newEq.a);
        System.out.println(newEq.b);
        System.out.println(newEq.c);
        */

        newEq.reduceEquation();

        // For testing purposes
        /*
        System.out.println(newEq.a);
        System.out.println(newEq.b);
        System.out.println(newEq.c);
        */

        return newEq;
    }

    public Equation substract(Equation eq2) {

        Equation newEq = new Equation(0,0,0);
        newEq.a = a - eq2.a;
        newEq.b = b - eq2.b;
        newEq.c = c - eq2.c;

        newEq.reduceEquation();

        return newEq;
    }

    public String toString ()
    {
        if ( b == 0) {

            return a + " = " + c;
        } 

        else if ( b == 1) {

            if ( c == 0) {

                return a + " = "  + "x";
            }
    
            else {
    
                return a + " = " + "x + " + c; 
            }
            
        }

        else {

             if ( c == 0) {

                return a + " = " + b + " x";
            }

            else {

                return a + " = " + b + "x + " + c; 
            }
        }
    }

    
    public boolean equals (Object obj) {

        boolean equal = false;
        if (obj instanceof Equation) {

            int gcd1 = this.gcd3(a, b, c);
            Equation eq = (Equation) obj;
            int gcd2 = eq.gcd3(eq.a, eq.b, eq.c);

            equal = a / gcd1 == eq.a / gcd2 && b / gcd1 == eq.b / gcd2 && c / gcd1 == eq.c / gcd2;
        }

        return equal;
    }
}

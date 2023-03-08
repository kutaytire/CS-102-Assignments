import java.util.ArrayList;

public class IntegerArray implements Comparable{

    // Properties

    public int [] digits;

    // Constructor
    
    public IntegerArray (String integer) {


        if (!integer.equals("")) {

            int length; 
            int i = 0;
            if (integer.charAt(0) != '-') {

                length = integer.length();
            }

            else {

                length = integer.length() - 1;
            }

            System.out.println("integer: " + integer);
            while ( i < integer.length() && integer.charAt(i) == '0' ) {

                i++;
            }

            System.out.println("parse " + Integer.parseInt(integer));
            if (Integer.parseInt(integer) == 0) {

                digits[0] = 0;
            }

            else {

                int newLength = length - i;
                digits = new int[newLength];

                for (int a = i; a < length; a++) {

                    if (integer.charAt(0) == '-') {

                            
                        digits[(newLength - 1) - (a - i)] = - Character.getNumericValue(integer.charAt(a + 1));
                    }

                    else {

                        digits[(newLength - 1) - (a - i)] =  Character.getNumericValue(integer.charAt(a));
                    }
                }
            }
        }
    }

    // Methods

    public int numberOfDigits() {

        return digits.length;
    }

    public int MID() {

        return digits[digits.length - 1];
    }

    public int LID() {

        return digits[0];
    }

    public int getDigit(int index) {

        if (index < digits.length -1 && index >= 0) {

            return digits[index];
        }

        return -1;
    }

    public IntegerArray add( IntegerArray other) {


        int minSize;
        int maxSize;
        int carry = 0;
        String integer = "";
        ArrayList<Integer> list = new ArrayList<Integer>();

        if ( digits.length > other.digits.length) {

            minSize = other.digits.length;
            maxSize = digits.length;
        }

        else {

            minSize = digits.length;
            maxSize = other.digits.length;

        }

        for ( int i = 0; i < minSize; i++) {

            int result = carry + digits[i] + other.digits[i];

            //System.out.println( "result: " + result);

            if (result > 9) {

                result = result % 10;
                carry = 1;
            }

            else if ( result < 0) {

                result = result + 10;
                carry = -1;

                // This part is added in case the summation of two negative numbers is needed. 
                if (result < 0) {

                    result =  result + 10;
                    carry = -2;
                }
            }

            else {

                carry = 0;
            }

            list.add(result);

        }

        if ( digits.length > other.digits.length) {

            for ( int k = minSize; k < digits.length; k++ ) {

                int result = carry + digits[k];

                if (result > 9) {

                    result = result % 10;
                    carry = 1;
                }

                else if ( result < 0) {

                    result = result + 10;
                    carry = -1;
                }

                else {

                    carry = 0;
                }

                list.add(result);
            }

        }

        else {

            for ( int k = minSize; k < other.digits.length; k++ ) {

                int result = carry + other.digits[k];

                if (result > 9) {

                    result = result % 10;
                    carry = 1;
                }

                else if ( result < 0) {

                    result = result + 10;
                    carry = -1;

                }

                else {

                    carry = 0;
                }

                list.add(result);
            }

        }
        
        if ( carry == -1) {

            for (int k = 0; k < list.size(); k++) {

                integer = integer + list.get( (list.size() - 1) - k);
            }

            double res = Integer.parseInt(integer);

            res = res - Math.pow(10, maxSize );

            int resInt = (int) res;

            integer = "" + resInt;

        }

        else {

            integer =  String.valueOf(carry);

            for (int k = 0; k < list.size(); k++) {

                integer = integer + list.get( (list.size() - 1) - k);
            }
        }

        System.out.println("a" + integer);
        IntegerArray sum = new IntegerArray(integer);
        return sum;
        

    }

    public IntegerArray substract ( IntegerArray other) {

        for ( int k = 0; k < other.digits.length; k++) {

            other.digits[k] =  - other.digits[k];

        }

        IntegerArray sub = this.add(other);

        for ( int k = 0; k < other.digits.length; k++) {

            other.digits[k] =  - other.digits[k];

        }

        return sub;
    }

    public int compareTo( Object obj) {

        IntegerArray ot = (IntegerArray) obj;

        if (this.numberOfDigits() == ot.numberOfDigits() ) {

            for (int k = 0; k < this.numberOfDigits(); k++) {

                if ( this.digits[k] > ot.digits[0] ) {

                    return 1;
                }

                else if (this.digits[k] < ot.digits[k]) {

                    return -1;
                }

                else {

                    continue;
                }
            }

            return 0;
        }

        else if (this.numberOfDigits() > ot.numberOfDigits()) {

            if ( this.MID() < 0) {

                return -1;
            }

            return 1;

        }

        else {

            
            if ( ot.MID() < 0) {

                return 1;
            }

            return -1;
        }



    }

    @Override 
    public boolean equals(Object obj) {

        boolean equal = false;
        int count = 0;
        if (obj instanceof IntegerArray) {

            IntegerArray arr = (IntegerArray) obj;
            if (this.numberOfDigits() == arr.numberOfDigits()) {

                for ( int k = 0; k <  arr.numberOfDigits(); k++ ) {

                    if (arr.digits[k] == digits[k]) {

                        count++;
                    }
                }

                if( count == arr.numberOfDigits()) {

                    equal = true;
                }
            }
            
        }

        return equal;
    }

    @Override
    public String toString() {

        String result = "" ;

        
        if (this.MID() > 0) {

            for (int i = this.numberOfDigits() - 1; i >= 0; i--) {

                result = result + (digits[i]) ;
            }
        }

        else {

            result = "" + (this.MID());

            for (int i = this.numberOfDigits() - 2; i >= 0; i--) {

                result = result + (-digits[i]) ;
            }

        }
        


        return result;
    }

    


}
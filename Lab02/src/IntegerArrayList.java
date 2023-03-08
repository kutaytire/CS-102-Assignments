import java.util.ArrayList;

public class IntegerArrayList {

    // Properties

    ArrayList<IntegerArray> numbers; 

    // Constructor

    public IntegerArrayList(ArrayList<String> list) {

        numbers = new ArrayList<IntegerArray>();

        for (int i = 0; i < list.size(); i ++) {
 
           IntegerArray arr = new IntegerArray (list.get(i));
           numbers.add(arr);
        }


    }

    // Methods

    public int getSize() {

        return numbers.size();
    }

    public IntegerArray getIntegerArrayAt(int index) {

        return numbers.get(index);
    }

    public void setIntegerArrayAt(int index, IntegerArray intArr) {

        numbers.set(index, intArr);
    }

    public void addIntegerArray(String number) {

        IntegerArray newElement = new IntegerArray(number);
        numbers.add(newElement);
    }

   public void removeIntegerArray(int index) {

        numbers.remove(index);
   } 

   public void removeIntegerArray(IntegerArray intArr) {

        int index = numbers.indexOf(intArr);
        numbers.remove(index);
   }

   public IntegerArray min(int start, int end) {

        IntegerArray min = numbers.get(start);

        for ( int i =  start; i <= end; i++ ) {

            int res = numbers.get(i).compareTo(min);

            if (res < 0) {

                min = numbers.get(i);

                /*
                System.out.println("min: " + min);
                System.out.println("index: " + numbers.indexOf(min));

                for (int n = 0; n < (min.digits).length; n++) {

                    System.out.println(min.digits[n]);

                }
                */
                
            }
        }

        return min;


   }
    
}

import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class IntegerArrayTest {
    public static void main(String[] args)

    // For the test of the first part
    
    {  

        IntegerArray a1 = new IntegerArray("300");
        System.out.println();
        IntegerArray a2 = new IntegerArray("300");

        IntegerArray a4 = new IntegerArray("234");

        System.out.println();
        System.out.println("The result of addition of a1 and a2 is: " + a1.add(a2));
        System.out.print("The result of substraction of a1 and a2 is: ");
        IntegerArray a3 = a1.substract(a2);

        System.out.println(a3);
        System.out.println("The result of addition of a3 and a3 is: " + a3.add(a3));

        System.out.println("Is a4 and a2 are equal? : " + a4.equals(a2));
       
        System.out.println("Done");
    
    
    // For the test of the second part
        
    
        // Variables

        Scanner scan;
        String input;

        // Main

        scan = new Scanner(System.in);

        System.out.println("Please enter the file name: ");
        input = scan.next();

        IntegerArrayList list1 = readIntegerArraysFromFile(input);

        int startIndex = 0;
        int middleIndex = list1.getSize() / 2;
        int endIndex = (list1.getSize() - 1);

        if (endIndex % 2 == 1) {

            middleIndex--;
        }
        
        if (endIndex != -1) {

            System.out.println("Start index = " + startIndex);
            System.out.println("Middle index = " + middleIndex);
            System.out.println("End index = " + endIndex);

            System.out.println();

            System.out.println("Minimum of all numbers");
            System.out.println(list1.min(startIndex, endIndex));

            System.out.println("Minimum of first half");
            System.out.println(list1.min(startIndex, middleIndex));

            System.out.println("Minimum of second half");
            System.out.println(list1.min(middleIndex + 1, endIndex));

        }

        scan.close();
        

    }

    

    public static IntegerArrayList readIntegerArraysFromFile(String fileName) {

        IntegerArrayList list;
        ArrayList<String> arrList = new ArrayList<String>();

        try {
            File myFile = new File(fileName);
            Scanner scanFile = new Scanner(myFile);
            while (scanFile.hasNext()) {

              String data = scanFile.nextLine();

              if(!data.equals("")) {

                arrList.add(data);
              }
              
            }
            scanFile.close();
        } catch (FileNotFoundException e) {

            System.out.println("File not found");
           
        }

        list = new IntegerArrayList(arrList);

        return list;
    }
    
    
}

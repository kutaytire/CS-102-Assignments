
public class Part3 {
    
    public static void main(String[] args) throws Exception {

        String input = "plane";
        String target = "plane";
        int max = Integer.MAX_VALUE;

        System.out.println(findMin(input, target, 0, 0, max));

    }

    public static int findMin(String input, String target, int count, int index, int min) {

        if (target.equals(input) && count < min) {

            min = count;
        }
        

        if (index == target.length() + 1) {

            return min;
        }
        if (target.length() > input.length()) {

            String newInput;
            char c = ' ';

            if (target.length() > index) {

                c = target.charAt(index);
            }

            if (index < input.length()) {

                newInput = input.substring(0, index) + c + input.substring(index);
            }

            else {

                newInput = input + c;

            }

            //System.out.println(newInput + " count: " + count);

            min = findMin(newInput, target, count + 1, index + 1, min);
            min = findMin(input, target, count, index + 1, min);  

        }

        else if (target.length() == input.length()) {

            if (index > 0) {

                for (int i = 0; i < index; i++) {

                    if (target.charAt(i) != input.charAt(i)) {

                        char c = target.charAt(i);
                        input = input.substring(0, i) + c + input.substring(i + 1);

                        count++;
                    }
                }
            }

            String newInput = "";

            if (target.length() > index) {

                char c = target.charAt(index);
                newInput = input.substring(0, index) + c + input.substring(index + 1);
            }

            //System.out.println(newInput + " count: " + count);

            min = findMin(newInput, target, count + 1, index + 1, min);
            min = findMin(input, target, count, index + 1, min);
        }

        else {

            String newInput;

            newInput = input.substring(0, index) + input.substring(index + 1);

            //System.out.println(newInput + " count: " + count);

            min = findMin(newInput, target, count + 1, index, min);
            min = findMin(input, target, count , index + 1, min);

        }

        return min;


    }
}

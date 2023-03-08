public class Part1 {
    public static void main(String[] args) throws Exception {

        int initialDay = 0;

        System.out.println(findPossible(29, 5, 10, initialDay));
        System.out.println(findPossible(75, 25, 7, initialDay));
        System.out.println(findPossible(74, 30, 16, initialDay));
        System.out.println(findPossible(75, 25, 0, initialDay));
        System.out.println(findPossible(75, 75, 0, initialDay));


       // N = 29, k = 5, a = 10 => true
       // N = 75, k = 25, a = 7 => false
       // N = 74, k = 30, a = 16 => true
       // N = 75, k = 25, a = 0 => false
       // N = 75, k = 75, a = 0 => true

        
       
    }

    public static boolean findPossible(int input, int numberOfApples, int day, int count) {

        if (input == numberOfApples && count == day) {

            return true;
        }

        if (input < 0 || count > day) {

            return false;
        }

        return findPossible(input - 2, numberOfApples, day, count + 1) || findPossible(input - 3, numberOfApples, day ,count + 1);

    }
}

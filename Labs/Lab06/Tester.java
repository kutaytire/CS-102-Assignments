

public class Tester {

    public static void main(String [] args) {
    
        int [] arr1;
        int [] arr2;
        int [] arr3;
        int [] arr4;
        int [] arr5;
        int [] arr6;
        int [] arr7;
        int [] arr8;
        int [] arr9;


        DecreasingArrayGenerator d1 = new DecreasingArrayGenerator();
        IncreasingArrayGenerator i1 = new IncreasingArrayGenerator();
        RandomArrayGenerator r1 = new RandomArrayGenerator();

        arr1 = r1.generate(8);
        arr2 = r1.generate(50);
        arr3 = r1.generate(100);
        arr4 = i1.generate(8);
        arr5 = i1.generate(50);
        arr6 = i1.generate(100);
        arr7 = d1.generate(8);
        arr8 = d1.generate(50);
        arr9 = d1.generate(100);

        /*
        for (int a = 0; a < arr3.length; a++) {

            System.out.println(arr3[a]);
        }
        */
        

        System.out.println();

        Comparable[] c1;
        Comparable[] c2;
        Comparable[] c3;
        Comparable[] c4;
        Comparable[] c5;
        Comparable[] c6;
        Comparable[] c7;
        Comparable[] c8;
        Comparable[] c9;

        Comparable[] n1;
        Comparable[] n2;
        Comparable[] n3;
        Comparable[] n4;
        Comparable[] n5;
        Comparable[] n6;
        Comparable[] n7;
        Comparable[] n8;
        Comparable[] n9;

        Comparable[] e1;
        Comparable[] e2;
        Comparable[] e3;
        Comparable[] e4;
        Comparable[] e5;
        Comparable[] e6;
        Comparable[] e7;
        Comparable[] e8;
        Comparable[] e9;

        Comparable[] f1;
        Comparable[] f2;
        Comparable[] f3;
        Comparable[] f4;
        Comparable[] f5;
        Comparable[] f6;
        Comparable[] f7;
        Comparable[] f8;
        Comparable[] f9;


        for (int a = 0; a < arr1.length; a++) {

            System.out.println(arr1[a]);
        }

        System.out.println();
        System.out.println();
        System.out.println();
    
        SortAnalyzer sa0 = new MergeSortAnalyzer();
        SortAnalyzer sa1 = new MergeSortAnalyzer();
        SortAnalyzer sa2 = new MergeSortAnalyzer();
        SortAnalyzer sa3 = new MergeSortAnalyzer();
        SortAnalyzer sa4 = new MergeSortAnalyzer();
        SortAnalyzer sa5 = new MergeSortAnalyzer();
        SortAnalyzer sa6 = new MergeSortAnalyzer();
        SortAnalyzer sa7 = new MergeSortAnalyzer();
        SortAnalyzer sa8 = new MergeSortAnalyzer();

        SortAnalyzer g1 = new GeneralizedMergeSortAnalyzer(3);
        SortAnalyzer g2 = new GeneralizedMergeSortAnalyzer(3);
        SortAnalyzer g3 = new GeneralizedMergeSortAnalyzer(3);
        
        SortAnalyzer g4 = new GeneralizedMergeSortAnalyzer(6);
        SortAnalyzer g5 = new GeneralizedMergeSortAnalyzer(6);
        SortAnalyzer g6 = new GeneralizedMergeSortAnalyzer(6);

        SortAnalyzer g7 = new GeneralizedMergeSortAnalyzer(9);
        SortAnalyzer g8 = new GeneralizedMergeSortAnalyzer(9);
        SortAnalyzer g9 = new GeneralizedMergeSortAnalyzer(9);

        SortAnalyzer q1 = new QuickSortAnalyzer();
        SortAnalyzer q2 = new QuickSortAnalyzer();
        SortAnalyzer q3 = new QuickSortAnalyzer();

        SortAnalyzer q4 = new QuickSortAnalyzer();
        SortAnalyzer q5 = new QuickSortAnalyzer();
        SortAnalyzer q6 = new QuickSortAnalyzer();

        SortAnalyzer q7 = new QuickSortAnalyzer();
        SortAnalyzer q8 = new QuickSortAnalyzer();
        SortAnalyzer q9 = new QuickSortAnalyzer();

        SortAnalyzer gq1 = new GeneralizedQuickSortAnalyzer(4);
        SortAnalyzer gq2 = new GeneralizedQuickSortAnalyzer(4);
        SortAnalyzer gq3 = new GeneralizedQuickSortAnalyzer(4);

        SortAnalyzer gq4 = new GeneralizedQuickSortAnalyzer(8);
        SortAnalyzer gq5 = new GeneralizedQuickSortAnalyzer(8);
        SortAnalyzer gq6 = new GeneralizedQuickSortAnalyzer(8);

        SortAnalyzer gq7 = new GeneralizedQuickSortAnalyzer(12);
        SortAnalyzer gq8 = new GeneralizedQuickSortAnalyzer(12);
        SortAnalyzer gq9 = new GeneralizedQuickSortAnalyzer(12);

        e1 = q1.convert(arr1);
        q1.sort(e1);

        e2 = q2.convert(arr2);
        q2.sort(e2);

        e3 = q3.convert(arr3);
        q3.sort(e3);

        e4 = q4.convert(arr4);
        q4.sort(e4);

        e5 = q5.convert(arr5);
        q5.sort(e5);

        e6 = q6.convert(arr6);
        q6.sort(e6);

        e7 = q7.convert(arr7);
        q7.sort(e7);

        e8 = q8.convert(arr8);
        q8.sort(e8);

        e9 = q9.convert(arr9);
        q9.sort(e9);


        f1 = gq1.convert(arr1);
        gq1.sort(f1);

        f2 = gq2.convert(arr2);
        gq2.sort(f2);

        f3 = gq3.convert(arr3);
        gq3.sort(f3);

        f4 = gq4.convert(arr4);
        gq4.sort(f4);

        f5 = gq5.convert(arr5);
        gq5.sort(f5);

        f6 = gq6.convert(arr6);
        gq6.sort(f6);

        f7 = gq7.convert(arr7);
        gq7.sort(f7);

        f8 = gq8.convert(arr8);
        gq8.sort(f8);

        f9 = gq9.convert(arr9);
        gq9.sort(f9);



        for (int a = 0; a < f1.length; a++) {

            System.out.println(f1[a]);
        }

        for (int a = 0; a < f1.length; a++) {

            System.out.println(f1[a]);
        }

        


        System.out.println(q1.isSorted(f1));
        System.out.println(q1.isSorted(f2));
        System.out.println(q1.isSorted(f3));
        System.out.println(q1.isSorted(f4));
        System.out.println(q1.isSorted(f5));
        System.out.println(q1.isSorted(f6));
        System.out.println(q1.isSorted(f7));
        System.out.println(q1.isSorted(f8));
        System.out.println(q1.isSorted(f9));


        n1 = g1.convert(arr1);
        n2 = g2.convert(arr2);
        n3 = g3.convert(arr3);

        n4 = g4.convert(arr1);
        n5 = g5.convert(arr2);
        n6 = g6.convert(arr3);

        n7 = g7.convert(arr1);
        n8 = g8.convert(arr2);
        n9 = g9.convert(arr3);
               
        g1.sort(n1);
        g2.sort(n2);
        g3.sort(n3);
        g4.sort(n4);
        g5.sort(n5);
        g6.sort(n6);
        g7.sort(n7);
        g8.sort(n8);
        g9.sort(n9);

        System.out.println(g3.isSorted(n3));

        /*
        
        for (int a = 0; a < n3.length; a++) {

            System.out.println(n3[a]);
        }

        */

        c1 = sa0.convert(arr1);
        c2 = sa1.convert(arr2);
        c3 = sa2.convert(arr3);
        c4 = sa3.convert(arr4);
        c5 = sa4.convert(arr5);
        c6 = sa5.convert(arr6);
        c7 = sa6.convert(arr7);
        c8 = sa7.convert(arr8);
        c9 = sa8.convert(arr9);




        sa0.sort(c1);
        sa1.sort(c2);
        sa2.sort(c3);
        sa3.sort(c4);
        sa4.sort(c5);
        sa5.sort(c6);
        sa6.sort(c7);
        sa7.sort(c8);
        sa8.sort(c9);



        System.out.println("Number of comparisons for randomly generated arrays of size 20: " + sa0.getNumberOfComparisons());
        System.out.println("Number of comparisons for randomly generated arrays of size 50: " + sa1.getNumberOfComparisons() );
        System.out.println("Number of comparisons for randomly generated arrays of size 100: " + sa2.getNumberOfComparisons() );

        System.out.println();

        System.out.println("Number of comparisons for increasingly generated arrays of size 20: " + sa3.getNumberOfComparisons() );
        System.out.println("Number of comparisons for increasingly generated arrays of size 50: " + sa4.getNumberOfComparisons() );
        System.out.println("Number of comparisons for increasingly generated arrays of size 100: "  + sa5.getNumberOfComparisons());

        System.out.println();

        System.out.println("Number of comparisons for decreasingly generated arrays of size 20: "  + sa6.getNumberOfComparisons());
        System.out.println("Number of comparisons for decreasingly generated arrays of size 50: " + sa7.getNumberOfComparisons() );
        System.out.println("Number of comparisons for decreasingly generated arrays of size 100: "  + sa8.getNumberOfComparisons());

        System.out.println();

        
        System.out.println("Number of comparisons for randomly generated arrays of size 20 and k = 3: "  + g1.getNumberOfComparisons());
        System.out.println("Number of comparisons for randomly generated arrays of size 50 and k = 3: " + g2.getNumberOfComparisons() );
        System.out.println("Number of comparisons for randomly generated arrays of size 100 and k = 3: "  + g3.getNumberOfComparisons());

        
        System.out.println();

        System.out.println("Number of comparisons for randomly generated arrays of size 20 and k = 6: "  + g4.getNumberOfComparisons());
        System.out.println("Number of comparisons for randomly generated arrays of size 50 and k = 6: " + g5.getNumberOfComparisons() );
        System.out.println("Number of comparisons for randomly generated arrays of size 100 and k = 6: "  + g6.getNumberOfComparisons());

        System.out.println();

        System.out.println("Number of comparisons for randomly generated arrays of size 20 and k = 9: "  + g7.getNumberOfComparisons());
        System.out.println("Number of comparisons for randomly generated arrays of size 50 and k = 9: " + g8.getNumberOfComparisons() );
        System.out.println("Number of comparisons for randomly generated arrays of size 100 and k = 9: "  + g9.getNumberOfComparisons());

        System.out.println();
        System.out.println("Quick Sort");
        System.out.println();

        System.out.println("Number of comparisons for randomly generated arrays of size 20: " + q1.getNumberOfComparisons());
        System.out.println("Number of comparisons for randomly generated arrays of size 50: " + q2.getNumberOfComparisons() );
        System.out.println("Number of comparisons for randomly generated arrays of size 100: " + q3.getNumberOfComparisons() );

        System.out.println();

        System.out.println("Number of comparisons for increasingly generated arrays of size 20: " + q4.getNumberOfComparisons() );
        System.out.println("Number of comparisons for increasingly generated arrays of size 50: " + q5.getNumberOfComparisons() );
        System.out.println("Number of comparisons for increasingly generated arrays of size 100: "  + q6.getNumberOfComparisons());

        System.out.println();

        System.out.println("Number of comparisons for decreasingly generated arrays of size 20: "  + q7.getNumberOfComparisons());
        System.out.println("Number of comparisons for decreasingly generated arrays of size 50: " + q8.getNumberOfComparisons() );
        System.out.println("Number of comparisons for decreasingly generated arrays of size 100: "  + q9.getNumberOfComparisons());

        System.out.println();

        
        System.out.println("Number of comparisons for randomly generated arrays of size 20 and k = 4: "  + gq1.getNumberOfComparisons());
        System.out.println("Number of comparisons for randomly generated arrays of size 50 and k = 4: " + gq2.getNumberOfComparisons() );
        System.out.println("Number of comparisons for randomly generated arrays of size 100 and k = 4: "  + gq3.getNumberOfComparisons());

        
        System.out.println();

        System.out.println("Number of comparisons for randomly generated arrays of size 20 and k = 8: "  + gq4.getNumberOfComparisons());
        System.out.println("Number of comparisons for randomly generated arrays of size 50 and k = 8: " + gq5.getNumberOfComparisons() );
        System.out.println("Number of comparisons for randomly generated arrays of size 100 and k = 8: "  + gq6.getNumberOfComparisons());

        System.out.println();

        System.out.println("Number of comparisons for randomly generated arrays of size 20 and k = 12: "  + gq7.getNumberOfComparisons());
        System.out.println("Number of comparisons for randomly generated arrays of size 50 and k = 12: " + gq8.getNumberOfComparisons() );
        System.out.println("Number of comparisons for randomly generated arrays of size 100 and k = 12: "  + gq9.getNumberOfComparisons());
        
        // Lower k values and lower sizes give better results
    }
    
}

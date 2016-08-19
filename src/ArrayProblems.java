import java.util.Arrays;

/**
 * Created by saurabh on 18/8/16.
 */


public class ArrayProblems {

    public static int hammingDistance(int[] aList, int[] bList)
    {
        assert (aList != null && bList != null && aList.length == bList.length) : "Violation of precondition: hammingDistance";

        int count = 0;
        if(Arrays.equals(aList, bList))
            return 0;

        else
        {
            for(int i=0; i<aList.length; i++)
            {
                if (aList[i] != bList[i])
                    count++;
            }
            return count;
        }
    }

    public static boolean isPermutation(int[] listA, int[] listB) {
        assert (listA != null && listB != null) : "Violation of precondition: isPermutation";
        assert (listA.length == listB.length);

        /*STUDENTS: INSERT YOUR CODE HERE*/

        if (Arrays.equals(listA, listB))
            return true;

        int[] temp1 = new int[listA.length];
        int[] temp2 = new int[listA.length];

        temp1 = Arrays.copyOf(listA, temp1.length);
        temp2 = Arrays.copyOf(listB, temp2.length);

        Arrays.sort(temp1);
        Arrays.sort(temp2);

        if (Arrays.equals(temp1, temp2))
            return true;

        else
            return false; //must change
    }

    public static boolean queensAreSafe(char[][] board) {
        char[] validChars = {'q', '.'};
//        assert (board != null) && (board.length > 0)
//                && isSquare(board) && onlyContains(board, validChars)
//                : "Violation of precondition: queensAreSafe";

		/*STUDENTS: INSERT YOUR CODE HERE*/
        int attack = 0;
        int queen;
        int i = 0;
        int j = 0;

        for (i = 0; i < board.length; i++) {
            queen = 0;

            for (j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'q') {
                    queen = 1;
                    break;
                }
            }


            if (queen != 0) {

                for (int k = j + 1; k < board.length; k++) {
                    if (board[i][k] == 'q')
                        attack = 1;
                    if (attack==1)
                    {
                        return false;
                    }
                }
                //dia
                for (int row = i + 1, col = j - 1; row < board.length && col >= 0; row++, col--) {
                    if (board[row][col] == 'q')
                        attack = 1;
                    if (attack==1)
                    {
                        return false;
                    }

                }
                //ver
                for (int row = i + 1; row < board.length; row++) {
                    if (board[row][j] == 'q')
                        attack = 1;
                    if (attack==1)
                    {
                        return false;
                    }
                }
                //dia
                for (int row = i + 1, col = j + 1; row < board.length && col < board.length; row++, col++) {
                    if (board[row][col] == 'q')
                        attack = 1;
                    if (attack==1)
                    {
                        return false;
                    }
                }

            }

        }
//        if (attack == 1) {
//            return false;
//        } else

            return true;
    }

    public static int[] minDifference(int[] nums) {
        int[] result = new int[2];

	    /*STUDENTS: INSERT YOUR CODE HERE*/
        int[] index=new int[2];
        int min=nums[0]-nums[1];
        Math.abs(min);
        //System.out.println("first minimum is; "+min);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int x=nums[j]-nums[i];
                int y=Math.abs(x);
                //System.out.println("y is; "+y);
                if(y<min)
                {
                    min=y;
                    index[0]=i;
                    index[1]=j;
                }


            }
        }
        //System.out.println("minimum is ; "+min+  " index are: "+ index[0]+" "+index[1] );

        return index;

        //return result; //must change
    }

    public static void main(String[] args) {

        int[] h1 = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        int[] h2 = {1, 2, 10, 4, 5, 4, 3, -10, 1};
        int expected = 2;
        int actual = hammingDistance(h1, h2);
        System.out.print("Test 1 expected value: " + expected + ", actual value: " + actual);
        if (expected == actual)
            System.out.println(" passed test 1, hamming distance");
        else
            System.out.println(" failed test 1, hamming distance");


//        int[] a = {1,2,2};
//        int[] b = {2,1,2};
//        boolean check = isPermutation(a, b);
//        System.out.println(check);

        char[][] unsafe = {{'.', '.', '.', 'q'},
                {'.', '.', '.', '.'},
                {'.', '.', '.', '.'},
                {'q', '.', '.', '.'}};

        boolean result = queensAreSafe(unsafe);
        if (result)
            System.out.println("board is safe");
        else
            System.out.println("not safe");
    }
}

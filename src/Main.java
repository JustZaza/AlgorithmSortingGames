import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello Gamer. Let's Practice Sorting Algorithms!!");
        gameSelection();



    }

    public static void gameSelection(){
        System.out.print("Choose which game you want to play!!! \n");

        int[] array = {8, 7, 9, 2, 3, 1, 5, 4, 6};

        ArrayList<String> games = new ArrayList<>();
        games.add("1: Selection Sort");
        games.add("2: Bubble Sort");
        games.add("3: Insertion");
        games.add("4: Merge Sort");
        System.out.println(games);

        int selected = sc.nextInt();
        switch (selected) {
            case 1:
                SelectionSortGame();
                break;

            case 2:
                BubbleSortGame();
                break;

            case 3:
                InsertionSortGame();
                break;

            case 4:
                MergeSortGame(array);
                break;

            default:
                System.out.println("End of games");
        }
    }

    public static void SelectionSortGame(){
        Scanner sc = new Scanner(System.in);
        int[] array = {8, 7, 9, 2, 3, 1, 5, 4, 6};
        System.out.println("Sort these numbers:");
        for(int i : array){
            System.out.print(i + " ");
        }

        System.out.println("\n\n");
        for (int i = 0; i < array.length - 1; i++) {
            for(int j : array){
                System.out.print(j + " ");
            }

            System.out.println("\nPlease enter min: ");
            int min1 = i;
            int minEntered = sc.nextInt();

            for (int j = i + 1; j < array.length; j++) {
                if (array[minEntered] > array[j]){
                    minEntered = j;
                } else if (array[min1] > array[j]) {
                    min1 = j;

                    if (array[minEntered] < min1){
                        System.out.println("wrong num");
                        break;
                    }
                }
            }

            int temp = array[i];
            array[i] = array[minEntered];
            array[minEntered] = temp;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]){
                    min = j;
                }
            }
            //outer for loop
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        System.out.println("\nCorrect sort");
        for(int i : array){
            System.out.print(i + " ");
        }
    }

    public static void BubbleSortGame(){

    }

    public static void InsertionSortGame(){
        Scanner sc = new Scanner(System.in);
        int[] array = {1, 8, 7, 2, 3, 6, 5, 4, 9};

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;

            for (int o : array) {
                System.out.print(o + " ");
            }

            System.out.println("Should the temp move left? Type in Y or N");
            System.out.print(temp + ": ");
            String answer = sc.nextLine().toLowerCase();

            while (j >= 0 && array[j] > temp) {
                if (Objects.equals(answer, "y")) {
                    System.out.println("Correct");
                    array[j + 1] = array[j];
                    j--;
                } else if (Objects.equals(answer, "n")) {
                    System.out.println("Wrong! " + temp + " was supposed to move left.");
                }
                array[j + 1] = temp;
            }
        }

        System.out.println("Your sequence: ");
        for (int i : array){
            System.out.print(i + " ");
        }

        System.out.println("\nCorrect array sequence: ");

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;

            while(j >= 0 && array[j] > temp){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }

        for (int i : array){
            System.out.print(i + " ");
        }
    }

    public static void MergeSortGame(int[] array){
        Scanner sc = new Scanner(System.in);
        int length = array.length;

        if (length <= 1) return;

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0; //left array
        int j = 0; //right array

        for (; i < length; i++){
            if (i < middle){
                leftArray[i] = array[i];

            } else {
                rightArray[j] = array[i];
                j++;
            }
        }

        MergeSortGame(leftArray);
        MergeSortGame(rightArray);
    }

    public static void merge(int[] leftArray, int[] rightArray, int[] array){

        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r =0; //indices

        //check the conditions for merging
        while(l < leftSize && r < rightSize){
            if (leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }

        while(l < leftSize){
            array[i] = leftArray[l];
            i++;
            l++;
        }

        while(r < rightSize){
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }

}

//the user must enter min num
//valid values
//messages if wrong
//Create different methods for selecting the games
//Generate an array with random numbers(length = 9)
//Add array as parameter in gameSelection switch

/*Bugs:
     ---Selection Sort: It's says it's a wrong number even if I'm entering the correct number.
            solution 1: if num in array is min, get index of num or get num. compare it with number entered

            I think I know why. It might because in selection sorting, the first number becomes a minimum
            number until the actual minimum number is found. So, when it is found, it becomes a minimum number and
            then there's a temp number. The minimum number will swap positions with the temp number.

     ---Insertion Sort: It's prints 'correct' repeatedly in the number of jumps it took going to the left.
            The y/n function. Wrong move doesn't print. N could be a right move, but it prints wrong. Didn't think it through, didn't I, pretty?

     ---Merge Sort: User input needed and functionality.*/
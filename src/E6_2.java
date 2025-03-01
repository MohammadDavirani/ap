import java.util.Scanner;

public class E6_2 {
    public static void main(String[] args) {

        System.out.println("=== 6.2 Exercise ===");

        int[] numbers;
        System.out.print("Enter the number of integers:");
        Scanner input3 = new Scanner(System.in);
        int length;
        length = input3.nextInt();
        numbers = new int[length];

        for(int i=0;i<length;i++) {
            System.out.format("number[%d] = ",i+1);
            Scanner input4 = new Scanner(System.in);
            numbers[i] = input4.nextInt();
        }

        Scanner input = new Scanner(System.in);
        String question;
        do
        {
            System.out.println("a. The smallest and largest of the inputs");
            System.out.println("b. The number of even and odd inputs");
            System.out.println("c. Cumulative totals.");
            System.out.println("d. All adjacent duplicates.");
            System.out.println("x. Exit.");

            System.out.format("\n\nchoose one of this option:");
            question = input.next();

            switch(question) {
                case "a":
                case "A":
                    System.out.println("1.The largest");
                    System.out.println("2.The smallest");
                    System.out.print("choose one of this option:");
                    Scanner input2 = new Scanner(System.in);
                    int question2;
                    question2 = input2.nextInt();
                    switch(question2) {
                        case 1:
                            int max = numbers[0];
                            for(int i=0;i<length;i++) {
                                if(max < numbers[i]) {
                                    max = numbers[i];
                                }
                            }
                            System.out.format("The largest integer is : %d\n",max);
                            break;

                        case 2:
                            int min = numbers[0];
                            for(int i=0;i<length;i++) {
                                if(min > numbers[i]) {
                                    min = numbers[i];
                                }
                            }
                            System.out.format("The largest integer is : %d\n",min);
                            break;
                    }
                    break;

                case "b":
                case "B":
                    System.out.println("1.Even numbers");
                    System.out.println("2.Odd numbers");
                    System.out.print("choose one of this option:");
                    Scanner input4 = new Scanner(System.in);
                    int question4;
                    question4 = input4.nextInt();
                    switch(question4) {
                        case 1:
                            int counterEven =0;
                            for(int i=0;i<length;i++) {
                                if(numbers[i] %2 ==0) {
                                    counterEven++;
                                }
                            }
                            System.out.format("Number of even numbers : %d\n", counterEven);
                            break;

                        case 2:
                            int counterOdd =0;
                            for(int i=0;i<length;i++) {
                                if(numbers[i] %2 ==1) {
                                    counterOdd++;
                                }
                            }
                            System.out.format("Number of even numbers : %d\n", counterOdd);
                            break;
                    }
                    break;

                case "c":
                case "C":
                    System.out.print("Cumulative is: ");
                    int cumulative=0;
                    for(int i=0;i<length;i++) {
                        cumulative += numbers[i];
                        System.out.format("%d ",cumulative);
                    }
                    System.out.println();
                    break;

                case "d":
                case "D":
                    System.out.print("duplicates is: ");
                    boolean counterDuplicates;
                    for(int i=0;i<length;i++) {
                        counterDuplicates = false;
                        for(int j=i+1;j<length;j++) {
                            if(numbers[i] == numbers[j]) {
                                counterDuplicates = true;
                            }
                        }
                        if(counterDuplicates) {
                            System.out.format("%d ",numbers[i]);
                        }
                    }
                    break;
            }
        }while(question == "a" || question == "A"||question == "b" || question == "B"||question == "c" || question == "C" || question == "d" || question == "D");
    }
}

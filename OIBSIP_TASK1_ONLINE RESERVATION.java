import java.util.Scanner;
import java.util.Date;

public class Train {
    private static int[] berths = new int[13];

    public static void main(String[] args) {
        System.out.println("Welcome to the online reservation system");
        System.out.println();
        for (int i = 0; i < 12; i++) {
            berths[i] = 0;
        }
        Scanner sc = new Scanner(System.in);
        int choice = 1;
        System.out.println("please select your type of berth:\n1.Upper berth\n2.Lower berth\n0.Exit.\n");
        choice = sc.nextInt();
        while (choice != 0) {
            int seatnumber = 0;
            if (choice == 1) {
                seatnumber = bookUpper();
                if (seatnumber == -1) {
                    seatnumber = bookLower();
                    if (seatnumber != -1) {
                        System.out.println("Sorry ther are no upper berths available. But we do have a lower berth");
                        boardingPass(seatnumber);
                    }
                } else {
                    System.out.println("Congratulations, we have a upper berth available!");
                    boardingPass(seatnumber);
                }
            } else if (choice == 2) {
                seatnumber = bookLower();
                if (seatnumber == -1) {
                    seatnumber = bookUpper();
                    if (seatnumber != -1) {
                        System.out
                                .println("Sorry, there are no Lower Berths available...But we do have a Upper Berth.");
                        boardingPass(seatnumber);
                    }
                } else {
                    System.out.println("Your choice is invalid please provide a valid choice!");
                    choice = 0;
                }
                if (seatnumber == -1) {
                    System.out.println("Sorry, there are no Upper Berths or bo Lower Berths available!");
                    System.out.println();
                }
                System.out.println("Please select your type of berth:\n1.Upper Berth\n2.Lower Berth\n0.Exit.\n");
                choice = sc.nextInt();
            }

        }

    }
    private static int bookUpper() {
        for (int i = 0; i < 6; i++) {
            if (berths[i] == 0) {
                berths[i] = 1;
                return i + 1;

            }
        }
        return -1;
    }

    private static int bookLower() {
        for (int i = 6; i < 12; i++) {
            if (berths[i] == 0) {
                berths[i] = 1;
                return i + 1;
            }
        }
        return -1;
    }

    private static void boardingPass(int berthnumber) {
        Date timenow = new Date();
        System.out.println();
        System.out.println("Date : " + timenow.toString());
        System.out.println("Boardingpass for berth number: " + berthnumber);
        System.out.println("Your booking succesfully!!!");
        System.out.println("This ticket is not refundable");
        System.out.println("Please be polite , keep your place clean. Have a safe journey.");
        System.out.println("!!Have a great day!!!");
        System.out.println();

    }
}

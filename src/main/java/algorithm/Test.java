package algorithm;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A test for the {@link algorithm.BTreeS} implementation.
 * for CS 380 - Final Project: Implementation of B-Tree Data Structure
 * @since 12/01/2011
 * @author Abdulrhman Alkhodiry, Ahmed Alsalama
 */
public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BTreeS bTree = new BTreeS();
        try {
            while (true) {
                System.out.print("Welcome to the B Tree implementation\n"
                        + "1) to insert a number to the B Tree.\n"
                        + "2) to delete a number from the B Tree.\n"
                        + "3) to search the B Tree.\n"
                        + "4) to print the B Tree.\n"
                        + "Note: 0 (zero) will be assumed Null"
                        + "Enter any other number to exit.\n"
                        + "Choose:\n");
                int choose, key;
                choose = in.nextInt();
                switch (choose) {
                    case 1:
                        System.out.print("Enter the number to insert in the B tree: ");
                        bTree.insert(in.nextInt());
                        break;
                    case 2:
                        System.out.print("Enter the number to delete from the B tree: ");
                        bTree.delete(in.nextInt());
                        break;
                    case 3:
                        System.out.print("Enter the number to search the B tree for: ");
                        key = in.nextInt();
                        if (bTree.search(key)) {
                            System.out.println(key + " is founded");
                        } else {
                            System.out.println(key + " is NOT founded");
                        }
                        break;
                    case 4:
                        System.out.println("-------\n"
                                + "Printing The B Tree\n");
                        bTree.print();
                        break;
                    default:
                        System.exit(0);
                }
                System.out.println("-----------------------");
            }
        } catch (InputMismatchException e) {
            System.out.println("Accept only numbers... \n Exiting....");
        }
    }
}

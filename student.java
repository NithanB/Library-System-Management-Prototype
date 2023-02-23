import java.util.Scanner;

// Class
public class student {

    // Class member variables
    String studentName;
    String studentId;

    book borrowedBooks[] = new book[3];
    public int booksCount = 0;
    public int fineBalance = 0;
    public int fine_class = 0;

    // Creating object of Scanner class to
    // take input from user
    Scanner input = new Scanner(System.in);

    // Constructor
    public student()
    {
        System.out.println("Warning! A Student Can Borrow No more than " + borrowedBooks.length + " books");
        // Print statement
        System.out.println("Enter Student Name:");
 
        // This keywords refers to current instance
        this.studentName = input.nextLine();
        
 
        // Print statement
        System.out.println("Enter Student ID:");
        this.studentId = input.nextLine();
        System.out.println("Please Confirm Your Information.");
        System.out.println("Student Name: " + studentName);
        System.out.println("Student ID number: " + studentId);
        System.out.println("Fine Balance: " + 0 + " THB");
        
        
    }
}
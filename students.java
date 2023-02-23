import java.util.Scanner;
 
// Class
public class students {
 
    // Creating objects of Scanner and students class
    Scanner input = new Scanner(System.in);
    student theStudents[] = new student[50];
 
    public static int count = 0;
 
    // Method 1
    // To add books
    public void addStudent(student s)
    {
        for (int i = 0; i < count; i++) {
 
            if (s.studentId.equalsIgnoreCase(
                    theStudents[i].studentId)) {
 
                // Print statement
                System.out.println(
                    "Student of Reg Num " + s.studentId
                    + " is Already Registered. Please enter an another registration number");
 
                return;
            }
        }
 
        if (count <= 50) {
            theStudents[count] = s;
            count++;
        }
    }
 
    // Method 2
    // Displaying all students
    public void showAllStudents()
    {
        // Printing student name and
        // corresponding registered number
        System.out.println("Student Name\t\tReg Number\t\tFine Balance");
        for (int i = 0; i < count; i++) {
 
            System.out.println(theStudents[i].studentName
                               + "\t\t"
                               + theStudents[i].studentId
                               + "\t\t" + theStudents[i].fineBalance + "THB");
        }
    }
 
    // Method 3
    // To check the Student
    public int isStudent()
    {
        // Display message only
        System.out.println("Enter Reg Number:");
 
        String studentId = input.nextLine();
 
        for (int i = 0; i < count; i++) {
 
            if (theStudents[i].studentId.equalsIgnoreCase(
                    studentId)) {
                return i;
            }
        }
 
        // Print statements
        System.out.println("Student is not Registered.");
        System.out.println("Get Registered First.");
 
        return -1;
    }
    
 
    // Method 4
    // To remove the book
    public void checkOutBook(books book)
    {
        int studentIndex = this.isStudent();
 
        if (studentIndex != -1) {
            System.out.println("checking out");

            if (theStudents[studentIndex].fineBalance > 0) {
                System.out.println("Access Denied! A Student Cannot Borrow a Book if fines are not cleared.");
                return;
            }
            book.showAllBooks();
            book b = book.checkOutBook();
 
            System.out.println("checking out");
            if (b != null) {
 
                if (theStudents[studentIndex].booksCount
                    <= 3) {
 
                    System.out.println("adding book");
                    theStudents[studentIndex].borrowedBooks
                        [theStudents[studentIndex]
                             .booksCount]
                        = b;
                    theStudents[studentIndex].booksCount++;
 
                    return;
                }
                
                else {
 
                    System.out.println(
                        "Warning! Student Can not Borrow more than 3 Books.");
                    return;
                }
            }
            System.out.println("Book is not Available.");
        }
    }
 
    // Method 5
    // To add the book
    public void checkInBook(books book)
    {
        int studentIndex = this.isStudent();
        if (studentIndex != -1) {
 
            // Printing credentials corresponding to student
            
 
            student s = theStudents[studentIndex];
 
            for (int i = 0; i < s.booksCount; i++) {
 
                System.out.println(
                    "Barcode Number: "+s.borrowedBooks[i].sNo + "\n"
                    + "Title: " +s.borrowedBooks[i].bookName + "\n"
                    + "Author: " +s.borrowedBooks[i].authorName);
            }
 
            // Display message only
            System.out.println(
                "Enter Serial Number of Book to be Checked In:");
 
            int sNo = input.nextInt();
 
            for (int i = 0; i < s.booksCount; i++) {
                if (sNo == s.borrowedBooks[i].sNo) {
                    book.checkInBook(s.borrowedBooks[i]);
                    s.borrowedBooks[i] = null;
 
                    return;
                }
            }
 
            System.out.println("Book of Serial No " + sNo
                               + "not Found");
        }
    }
    public void PenaltyCheck(){
        System.out.println("Enter Reg Number:");
        
        int studentIndex = this.isStudent();
        String studentId = input.nextLine();
        
        if (studentIndex != -1) {
            for (int i = 0; i < count; i++) {

                if (theStudents[i].studentId.equalsIgnoreCase(
                        studentId)) {
                        System.out.println("Student Name: "+theStudents[i].studentName
                            + "\n" + "Student ID Number: "
                            + theStudents[i].studentId
                            + "\n"+ "Fine Balance: " + theStudents[i].fineBalance + "THB");
                        System.out.println("Book Penalty Check:\n");
                        System.out.println("Press 1 to Set Late Fine Penalty");
                        System.out.println("Press 2 to Set Damage Penalty");
                        System.out.println("Press 3 to Receive Fine Payment");
                        int option = input.nextInt();
                    switch(option){
                    case 1:
                        theStudents[i].fineBalance +=15 ;
                        break;
                    case 2:
                        theStudents[i].fineBalance += 100;
                        break;
                    case 3:
                    theStudents[i].fineBalance = 0;
                    break;
                        }
                    
        
                }
            }
        
        
        
        }
        

    }
}
    

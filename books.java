import java.util.Scanner;
 
// CLass
public class books {
 
    // Class data members
    book theBooks[] = new book[50];
    public static int count;
 
    Scanner input = new Scanner(System.in);
 
    // Method 1
    //  To compare books
    public int compareBookObjects(book b1, book b2)
    {
 
        // If book name matches
        if (b1.bookName.equalsIgnoreCase(b2.bookName)) {
 
            // Printing book exists
            System.out.println(
                "Book of this Name Already Exists.");
            return 0;
        }
 
        // if book serial matches
        if (b1.sNo == b2.sNo) {
 
            // Print book exists
            System.out.println(
                "Book of this Serial No Already Exists.");
 
            return 0;
        }
        return 1;
    }
 
    // Method 2
    // To add book
    public void addBook(book b)
    {
 
        for (int i = 0; i < count; i++) {
 
            if (this.compareBookObjects(b, this.theBooks[i])
                == 0)
                return;
        }
 
        if (count < 50) {
 
            theBooks[count] = b;
            count++;
        }
        else {
 
            System.out.println(
                "No Space to Add More Books.");
        }
    }
 
    // Method 3
    // To search book by serial number
    public void searchBySno()
    {
 
        // Display message
        System.out.println(
            "\t\t\t\tSEARCH BY SERIAL NUMBER\n");
 
        // Class data members
        int sNo;
        System.out.println("Enter Serial No of Book:");
        sNo = input.nextInt();
 
        int flag = 0;

 
        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                System.out.println("Serial Number: " + theBooks[i].sNo);
                System.out.println("Title: " + theBooks[i].bookName);
                System.out.println("Author: " + theBooks[i].authorName);
                System.out.println("Genre: " + theBooks[i].genre);
                System.out.println(theBooks[i].bookQty + " books available.");
                flag++;
                return;
            }
        }
        if (flag == 0)
            System.out.println("No Book for Serial No "
                               + sNo + " Found.");
    }
 
    public void searchByGenre(){
        System.out.println(
            "\t\t\t\tSEARCH BY GENRE");
        input.nextLine();
        System.out.println("Enter Genre:");
        String genre = input.nextLine();
        int flag = 0;

        for (int i = 0; i < count; i++) {
 
            // if author matches any of its book
            if (genre.equalsIgnoreCase(theBooks[i].genre)) {
 
                // Print below corresponding credentials
                System.out.println("Serial Number: " + theBooks[i].sNo);
                System.out.println("Title: " + theBooks[i].bookName);
                System.out.println("Author: " + theBooks[i].authorName);
                System.out.println("Genre: " + theBooks[i].genre);
                System.out.println(theBooks[i].bookQty + " books available.");
                flag++;
            }
        }
    }
    public void searchByAuthorName()
    {
 
        // Display message
        System.out.println(
            "\t\t\t\tSEARCH BY AUTHOR'S NAME");
 
        input.nextLine();
 
        System.out.println("Enter Author Name:");
        String authorName = input.nextLine();
 
        int flag = 0;
 
        
        for (int i = 0; i < count; i++) {
 
            // if author matches any of its book
            if (authorName.equalsIgnoreCase(
                    theBooks[i].authorName)) {
 
                // Print below corresponding credentials
                System.out.println("Barcode Number: " + theBooks[i].sNo);
                System.out.println("Title: " + theBooks[i].bookName);
                System.out.println("Author: " + theBooks[i].authorName);
                System.out.println("Genre: " + theBooks[i].genre);
                System.out.println(theBooks[i].bookQty + " books available.");
                flag++;
            }
        }
 
        // Else no book matches for author
        if (flag == 0)
            System.out.println("No Books of " + authorName
                               + " Found.");
    }
 
    // Method 5
    // To display all books
    public void showAllBooks()
    {
 
        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        
 
        for (int i = 0; i < count; i++) {
 
            System.out.println("Barcode Number: " + theBooks[i].sNo);
            System.out.println("Title: " + theBooks[i].bookName);
            System.out.println("Author: " + theBooks[i].authorName);
            System.out.println("Genre: " + theBooks[i].genre);
            System.out.println(theBooks[i].bookQty + " books available.");
        }
    }
 
    
 
    // Method 7
    // To create menu
    public void dispMenu()
    {
 
        // Displaying menu
        System.out.println(
            "----------------------------------------------------------------------------------------------------------");
        System.out.println("Press 1 to Add new Book.");
        System.out.println("Press 0 to Exit Application.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Show All Books in the Library.");
        System.out.println("Press 5 to Register Student.");
        System.out.println(
            "Press 6 to Show All Registered Students.");
        System.out.println("Press 7 to Check Out Book. ");
        System.out.println("Press 8 to Check In Book");
        System.out.println("Press 9 to Check Penalty");
        System.out.println(
            "-------------------------------------------------------------------------------------------------------");
    }
 
    // Method 8
    // To search the library
    public int isAvailable(int sNo)
    {
 
        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                if (theBooks[i].bookQtyCopy > 0) {
 
                    System.out.println(
                        "Book is Available.");
                    return i;
                }
                System.out.println("Book is Unavailable");
                return -1;
            }
        }
 
        System.out.println("No Book of Barcode "
                           + " Available in Library.");
        return -1;
    }
 
    // Method 9
    // To remove the book from the library
    public book checkOutBook()
    {
 
        System.out.println(
            "Enter the Barcode Number to be Checked Out.");
        int sNo = input.nextInt();
 
        int bookIndex = isAvailable(sNo);
 
        if (bookIndex != -1) {
            theBooks[bookIndex].bookQtyCopy--;
            return theBooks[bookIndex];
        }
        return null;
    }
 
    // Method 10
    // To add the Book to the Library
    public void checkInBook(book b)
    {
        for (int i = 0; i < count; i++) {
            if (b.equals(theBooks[i])) {
                theBooks[i].bookQtyCopy++;
                return;
            }
        }
    }
    
}
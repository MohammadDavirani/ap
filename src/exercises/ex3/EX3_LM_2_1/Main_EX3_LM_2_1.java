package exercises.ex3.EX3_LM_2_1;

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

public class Main_EX3_LM_2_1 {
    public static void main(String[] args) {
        BookInfo[] book = new BookInfo[4];
        StudentInfo[] student = new StudentInfo[3];

        Scanner input= new Scanner(System.in);

        for(int i=0;i<4;i++) {
            book[i] = new BookInfo();
            System.out.format("Book %d\n",i+1);
            System.out.print("Book Name: ");
            book[i].bookName=input.nextLine();
            System.out.print("Book Author: ");
            book[i].bookAuthor=input.nextLine();
            System.out.print("Number of pages: ");
            book[i].numberPages=input.nextInt();
            input.nextLine();
            System.out.print("year of Publication: ");
            book[i].yearPublication=input.nextInt();
            input.nextLine();
            book[i].bookExistence = true;
        }
        for(int i=0;i<3;i++) {
            student[i] = new StudentInfo();
            System.out.format("Student %d\n",i+1);
            System.out.print("Student first Name: ");
            student[i].studentFirstName=input.nextLine();
            System.out.print("Student last name: ");
            student[i].studentLastName=input.nextLine();
            System.out.print("field of study: ");
            student[i].fieldStudy=input.nextLine();
            System.out.print("student id: ");
            student[i].studentId=input.nextInt();
            input.nextLine();
        }
        writeBook(book);
        writeStudent(student);

        readBook(book);
        readStudent(student);
        lendingBooks(book,student);

//        searchStudentName(student);

//        for(int i = 0; i < 4; i++) {
//            System.out.println("Book " + (i+1) + ": " + book[i].bookName + ", " + book[i].bookAuthor + ", " +
//                    book[i].numberPages + " pages, Published in " + book[i].yearPublication);
//        }
//        for (int i = 0; i < 3; i++) {
//            System.out.println("Student " + (i + 1) + ": " + student[i].studentFirstName + " " +
//                    student[i].studentLastName + ", Field: " + student[i].fieldStudy +
//                    ", ID: " + student[i].studentId);
//        }
    }
    public static void writeBook(BookInfo[] book){
        try (FileWriter saveBook = new FileWriter("saveBookInfo.txt")) {
            for (int i = 0; i < 4; i++) {
                if (book[i] != null) {
                    saveBook.write(book[i].bookName + "\n");
                    saveBook.write(book[i].bookAuthor + "\n");
                    saveBook.write(String.valueOf(book[i].numberPages) + "\n");
                    saveBook.write(String.valueOf(book[i].yearPublication) + "\n");
                    saveBook.write(String.valueOf(book[i].bookExistence) + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeStudent(StudentInfo[] student){
        try (FileWriter saveStudent = new FileWriter("saveStudentInfo.txt")) {
            for (int i = 0; i < 3; i++) {
                if (student[i] != null) {
                    saveStudent.write(student[i].studentFirstName + "\n");
                    saveStudent.write(student[i].studentLastName + "\n");
                    saveStudent.write(student[i].fieldStudy + "\n");
                    saveStudent.write(String.valueOf(student[i].studentId) + "\n");
                    saveStudent.write(String.valueOf(student[i].lendingBooksCounter) + "\n");
                    if(student[i].lendingBooksCounter>0)
                        for(int j=0;j<student[i].lendingBooksCounter;j++){
                            saveStudent.write(student[i].lendingBooks[j] + "\n");
                        }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readBook(BookInfo[] book) {
        try (BufferedReader readBook = new BufferedReader(new FileReader("saveBookInfo.txt"))) {
            for (int i = 0; i < 4; i++) {
                if (book[i] == null) {
                    book[i] = new BookInfo();
                }

                book[i].bookName = readBook.readLine();
                book[i].bookAuthor = readBook.readLine();
                book[i].numberPages = Integer.parseInt(readBook.readLine());
                book[i].yearPublication = Integer.parseInt(readBook.readLine());
                String temp = readBook.readLine();
                if(temp.equals("true")){
                    book[i].bookExistence = true;
                }
                else{
                    book[i].bookExistence = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readStudent(StudentInfo[] student) {
        try (BufferedReader readStudent = new BufferedReader(new FileReader("saveStudentInfo.txt"))) {
            for (int i = 0; i < 3; i++) {
                if (student[i] == null) {
                    student[i] = new StudentInfo();
                }

                student[i].studentFirstName = readStudent.readLine();
                student[i].studentLastName = readStudent.readLine();
                student[i].fieldStudy = readStudent.readLine();
                student[i].studentId = Integer.parseInt(readStudent.readLine());
                student[i].lendingBooksCounter = Integer.parseInt(readStudent.readLine());
                if(student[i].lendingBooksCounter>0){
                    if(student[i].lendingBooks == null) {
                        student[i].lendingBooks = new String[student[i].lendingBooksCounter];
                    }
                    for(int j=0;j<student[i].lendingBooksCounter;j++){
                        student[i].lendingBooks[j] = readStudent.readLine();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void searchStudentName(StudentInfo[] student){
        Scanner input= new Scanner(System.in);
        String firstName,lastName;
        boolean temp = false;

        System.out.print("please enter a student firstName: ");
        firstName = input.next();
        System.out.print("please enter a student lastName: ");
        lastName = input.next();

        for(int i=0;i<3;i++) {
            if(student[i] != null) {
                if(student[i].studentFirstName.equals(firstName)){
                    if(student[i].studentLastName.equals(lastName)){
                        temp = true;
                        break;
                    }
                }
            }
        }
        if(temp){
            System.out.println("There is student with this name.");
        }
        else{
            System.out.println("There is no student with this name.");
        }
    }

    public static void lendingBooks(BookInfo[] book , StudentInfo[] student) {
        Scanner input = new Scanner(System.in);
        String firstName,lastName,bookName,bookAuthor;
        boolean bookExistence = false,studentExistence = false;
        int bookIndex=-1,studentIndex=-1;

        System.out.print("please enter a Book Name: ");
        bookName = input.next();
        System.out.print("please enter a Book Author: ");
        bookAuthor = input.next();

        for(int i=0;i<4;i++){
            if(book[i] !=null) {
                if(book[i].bookName.equals(bookName)) {
                    if(book[i].bookAuthor.equals(bookAuthor)){
                        if(book[i].bookExistence)
                        {
                            book[i].bookExistence = false;
                            bookExistence = true;
                            bookIndex = i;
                            break;
                        }
                    }
                }
            }
        }

        if(bookExistence) {
            System.out.print("please enter a student firstName: ");
            firstName = input.next();
            System.out.print("please enter a student lastName: ");
            lastName = input.next();

            for(int i=0;i<3;i++) {
                if(student[i] != null) {
                    if(student[i].studentFirstName.equals(firstName)){
                        if(student[i].studentLastName.equals(lastName)){
                            studentExistence = true;
                            studentIndex = i;
                            break;
                        }
                    }
                }
            }
        }else{
            System.out.print("\nThere is no book.\n");
            System.exit(0);
        }

        if(!studentExistence){
            System.out.print("\nThere is no student.\n");
            System.exit(0);
        }

        if(bookExistence && studentExistence) {
            int counter = ++student[studentIndex].lendingBooksCounter;

            String[] newLendingBooks = new String[counter];
            if (student[studentIndex].lendingBooks != null) {
                System.arraycopy(student[studentIndex].lendingBooks, 0, newLendingBooks, 0, counter - 1);
            }

            newLendingBooks[counter - 1] = book[bookIndex].bookName;

            student[studentIndex].lendingBooks = newLendingBooks;


            System.out.print("\nThe book was given to the student.\n");

            writeBook(book);
            writeStudent(student);
        }

//        for(int i=0;i<student[studentIndex].lendingBooksCounter;i++) {
//            System.out.format("%d => %s\n",i+1,student[studentIndex].lendingBooks[i]);
//        }
    }
}

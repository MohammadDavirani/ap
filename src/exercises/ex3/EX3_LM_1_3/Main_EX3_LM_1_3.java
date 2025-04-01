package exercises.ex3.EX3_LM_1_3;

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

public class Main_EX3_LM_1_3 {
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

        searchStudentName(student);

        for(int i = 0; i < 4; i++) {
            System.out.println("Book " + (i+1) + ": " + book[i].bookName + ", " + book[i].bookAuthor + ", " +
                    book[i].numberPages + " pages, Published in " + book[i].yearPublication);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("Student " + (i + 1) + ": " + student[i].studentFirstName + " " +
                    student[i].studentLastName + ", Field: " + student[i].fieldStudy +
                    ", ID: " + student[i].studentId);
        }
    }
    public static void writeBook(BookInfo[] book){
        try (FileWriter saveBook = new FileWriter("saveBookInfo.txt")) {
            for (int i = 0; i < 4; i++) {
                if (book[i] != null) {
                    saveBook.write(book[i].bookName + "\n");
                    saveBook.write(book[i].bookAuthor + "\n");
                    saveBook.write(String.valueOf(book[i].numberPages) + "\n");
                    saveBook.write(String.valueOf(book[i].yearPublication) + "\n");
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
}

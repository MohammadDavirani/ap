package exercises.ex3.EX3_LM_1_2;

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

public class Main_EX3_LM_1_2 {
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

        try (FileWriter saveBook = new FileWriter("saveBookInfo.txt")) {
            for(int i=0;i<4;i++) {
                saveBook.write(book[i].bookName);
                saveBook.write(book[i].bookAuthor);
                saveBook.write(book[i].numberPages);
                saveBook.write(book[i].yearPublication);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter saveStudent = new FileWriter("saveStudentInfo.txt")) {
            for(int i=0;i<3;i++) {
                saveStudent.write(student[i].studentFirstName);
                saveStudent.write(student[i].studentLastName);
                saveStudent.write(student[i].fieldStudy);
                saveStudent.write(student[i].studentId);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

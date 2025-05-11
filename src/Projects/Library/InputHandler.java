package Projects.Library;

import java.time.LocalDate;
import java.util.Scanner;

public class InputHandler {

    public static Book getBookInfoFromUser(){
        Scanner input = new Scanner(System.in);
        Book book = new Book();

        System.out.println("Title: ");
        book.setTitle(input.nextLine());
        System.out.println("Author: ");
        book.setAuthor(input.nextLine());
        System.out.println("pageCount");
        book.setPageCount(input.nextInt());
        input.nextInt();
        System.out.println("yearPublished");
        book.setYearPublished(input.nextInt());
        input.nextInt();
        System.out.println("Exist");
        book.setToExist(true);
        return book;

    }

    public static Student getStudentInfoFromUser(){
        Scanner input = new Scanner(System.in);
        Student student = new Student();

        System.out.println("firstName: ");
        student.setFirstName(input.nextLine());

        System.out.println("lastName: ");
        student.setLastName(input.nextLine());

        System.out.println("student Id: ");
        student.setStudentId(input.nextInt());
        input.nextLine();

        System.out.println("major: ");
        student.setMajor(input.nextLine());

        student.setMemberShipDate(LocalDate.now());

        return student;
    }

    public static libraryManager getManagerInfoFromUser(){
        Scanner input = new Scanner(System.in);
        libraryManager manager = new libraryManager();

        System.out.println("firstName: ");
        manager.setFirstName(input.nextLine());

        System.out.println("lastName: ");
        manager.setLastName(input.nextLine());

        System.out.println("User Id: ");
        manager.setUserId(input.nextInt());
        input.nextLine();

        return manager;
    }

    public static void getLoanInfoFromUser(){

    }


}

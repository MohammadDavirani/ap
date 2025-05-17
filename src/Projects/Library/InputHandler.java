package Projects.Library;

import java.time.LocalDate;
import java.util.Scanner;

public class InputHandler {

    public  Book getBookInfoFromUser(){
        Scanner input = new Scanner(System.in);
        Book book = new Book();

        System.out.println("<<book section>>");

        System.out.println("Title: ");
        String title = input.nextLine();
        book.setTitle(title);
        System.out.println("Author: ");
        String author = input.nextLine();
        book.setAuthor(author);
        System.out.println("pageCount: ");
        int pageCount = input.nextInt();
        book.setPageCount(pageCount);
        System.out.println("yearPublished: ");
        int yearPublished = input.nextInt();
        book.setYearPublished(yearPublished);
        book.setToExist(true);
        return book;

    }

    public  Student getStudentInfoFromUser(){
        Scanner input = new Scanner(System.in);
        Student student = new Student();

        System.out.println("<<student section>>");

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

    public  libraryManager getManagerInfoFromUser(){
        Scanner input = new Scanner(System.in);
        libraryManager manager = new libraryManager();

        System.out.println("<<manager section>>");

        System.out.println("firstName: ");
        manager.setFirstName(input.nextLine());

        System.out.println("lastName: ");
        manager.setLastName(input.nextLine());

        System.out.println("User Id: ");
        manager.setUserId(input.nextLong());
        input.nextLine();

        return manager;
    }

    public void getLibraryAdminInfoFromUser(){
        Scanner input = new Scanner(System.in);
        libraryAdmin admin = new libraryAdmin();

        System.out.println("<<admin section>>");

        System.out.println("firstName: ");
        admin.setFirstName(input.nextLine());

        System.out.println("lastName: ");
        admin.setLastName(input.nextLine());

        System.out.println("educationLevel: ");
        admin.setEducationLevel(input.nextLine());

        System.out.println("userId:");
        admin.setUserId(input.nextInt());

    }


}

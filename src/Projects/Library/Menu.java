package Projects.Library;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    public void showStudentMenu(Library library){
        System.out.println("are you member of library?\n1.yes\n2.no");
        Scanner input = new Scanner(System.in);
        int question = input.nextInt();
        long question2 = 0;
        boolean ask = false;
        if(question == 1){
            System.out.println("please enter your student id:");
            question2 = input.nextLong();
            for(int i=0;i<library.getArrayStudents().size();i++){
                Student student = library.getArrayStudents().get(i);
                if(question2 == student.getStudentId()){
                    ask = true;
                    System.out.println("Welcome to library.");

                }
            }
        }else if(question == 2){
            System.out.println(("Do you want to become a library member?\n1.yes\n2.no"));
            question = input.nextInt();
            if(question == 1){
                InputHandler handler =new InputHandler();
                Student student =handler.getStudentInfoFromUser();
                library.addStudent(student);
                System.out.println("Student added to library.");
                ask = true;
            }
            else{
                return;
            }
        }
        if(!ask){
            System.out.println(("you are not member of library!"));
            System.out.println(("Do you want to become a library member?(1.yes\n2.no)"));
            question = input.nextInt();
            if(question == 1){
                InputHandler handler =new InputHandler();
                Student student =handler.getStudentInfoFromUser();
                library.addStudent(student);
                System.out.println("Student added to library.");
            }
            else{
                return;
            }
        }



        int choose;
        libraryManager manager = new libraryManager();
        Student student = new Student();
        Book book = new Book();
        String title,author;
        do{
            System.out.println("\n----- Student Menu -----");
            System.out.println("1. Search for a book");
            System.out.println("2. request a borrow book");
            System.out.println("3. request a Return book");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choose=input.nextInt();
            input.nextLine();
            switch(choose){
                case 1:
                    System.out.println("title:");
                    title = input.nextLine();
                    System.out.println("author:");
                    author = input.nextLine();
                    library.searchBook(title,author);
                    break;

                case 2:
                    System.out.println("title:");
                    title = input.nextLine();
                    System.out.println("author:");
                    author = input.nextLine();

                    book=manager.toExistBook(title,author,library);

                    Long studentId  = question2;
                    student = manager.toExistStudent(studentId,library);


                    if (book == null || student == null) {
                        System.out.println("Book or Student not found in library.");
                        return;
                    }

                    if (!manager.studentRequest(student, book, library.getArrayRequest())) {
                        Request request = new Request();
                        request.setBook(book);
                        request.setStudent(student);
                        request.setDate(LocalDate.now());
                        library.addRequest(request);
                        System.out.println("Your request has been registered.");
                    } else {
                        System.out.println("Your request has already been registered.");
                    }
                    break;

                case 3:
                    System.out.println("title:");
                    title = input.nextLine();
                    System.out.println("author:");
                    author = input.nextLine();

                    book=manager.toExistReturnBookRequest(title,author,library);

                    studentId  = question2;
                    student = manager.toExistReturnBookRequest(studentId,library);

                    if(book != null && student != null){
                        manager.ReturnBookRequest(student,book,library,manager);
                    }
                    break;

                case 4:
                    System.out.println("See you later ;)");
                    break;

                default:
                    System.out.println("Invalid number!");
                    break;
            }

        }while(choose !=4);

    }
    public void showAdminMenu(Library library,libraryAdmin admin){
        System.out.println("Please enter your userId:");
        Scanner input = new Scanner(System.in);
        Long question = input.nextLong();
        if(question == admin.getUserId()){
            System.out.println("welcome to library.");
        }
        else{
            System.out.println("you are not admin of library!.");
            System.out.println("Do you have an identification code?\n1.yes\n2.no");
            int question2 = input.nextInt();
            if(question2 == 1){
                System.out.println("please enter code:");
                question2 = input.nextInt();
                input.nextLine();
                if(question2 == admin.getCode())
                {
                    System.out.println("firstName:");
                    String firstName = input.nextLine();
                    admin.setFirstName(firstName);

                    System.out.println("lastName:");
                    String lastName = input.nextLine();
                    admin.setLastName(lastName);

                    System.out.println("educationLevel:");
                    String educationLevel = input.nextLine();
                    admin.setEducationLevel(educationLevel);

                    System.out.println("userId:");
                    long userId = input.nextLong();
                    admin.setUserId(userId);
                }
                else{
                    return;
                }
            }else{
                return;
            }
        }


        Book book = null;
        int choose;
        InputHandler handler = new InputHandler();
        do{
            System.out.println("\n----- Admin Menu -----");
            System.out.println("1. Add new book");
            System.out.println("2. View overdue books");
            System.out.println("3. View number of loans by each staff member");
            System.out.println("4. View top 10 borrowed books in last year");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choose=input.nextInt();
            switch(choose){
                case 1:
                    book = handler.getBookInfoFromUser();
                    admin.addBookToLibrary(library,book);
                    System.out.println("Book add to library.");
                    break;

                case 2:
                    admin.listOfBooksBorrowed(library);
                    break;

                case 3:
                    library.countBooksLoans();
                    break;

                case 4:
                    library.top10BooksLastYear();
                    break;

                case 5:
                    System.out.println("See you later ;)");
                    break;

                default:
                    System.out.println("Invalid number!");
                    break;
            }

        }while(choose !=5);
    }
    public void showManagerMenu(Library library){
        System.out.println("Please enter your userId:");
        Scanner input = new Scanner(System.in);
        Long question = input.nextLong();
        boolean logIn = false;
        if(question == library.getArrayLibraryManagers().get(0).getUserId() ||
                question == library.getArrayLibraryManagers().get(1).getUserId()) {
            logIn = true;
        }

        libraryManager manager = new libraryManager();
        manager = manager.getManager(question,library);

        if(logIn){
            System.out.println("Welcome to library.");
            int choose;
            do{
                System.out.println("\n----- Manager Menu -----");
                System.out.println("1. Accepting the student's request for Borrow book");
                System.out.println("2. Accepting the student's request for Return book");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                choose=input.nextInt();
                switch(choose){
                    case 1:
                        manager.borrowBookRequest(library,manager);

                        break;

                    case 2:
                        manager.acceptReturnRequest(library,manager,question);
                        break;

                    case 3:
                        break;

                    default:
                        System.out.println("Invalid number!");
                        break;
                }


            }while(choose != 3);




        }
        else{
            System.out.println("You are not the librarian Manager! ");
        }
    }
}

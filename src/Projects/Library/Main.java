package Projects.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library("University of zanjan");

        InputHandler handler = new InputHandler();

        libraryAdmin admin = handler.getLibraryAdminInfoFromUser();

        libraryManager manager1 = handler.getManagerInfoFromUser();
        libraryManager manager2 = handler.getManagerInfoFromUser();
        library.addManager(manager1);
        library.addManager(manager2);

        Student student = handler.getStudentInfoFromUser();
        library.addStudent(student);

        Book book = handler.getBookInfoFromUser();

        admin.addBookToLibrary(library,book);

    }
}

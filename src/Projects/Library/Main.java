package Projects.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library("University of zanjan");

        libraryAdmin admin = InputHandler.getLibraryAdminInfoFromUser();

        libraryManager manager1 = InputHandler.getManagerInfoFromUser();
        libraryManager manager2 = InputHandler.getManagerInfoFromUser();
        library.addManager(manager1);
        library.addManager(manager2);

        Student student = InputHandler.getStudentInfoFromUser();
        library.addStudent(student);

        Book book = InputHandler.getBookInfoFromUser();

        admin.addBookToLibrary(library,book);

    }
}

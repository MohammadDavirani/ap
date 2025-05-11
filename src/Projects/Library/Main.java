package Projects.Library;

public class Main {
    public static void main(String[] args) {
        library library = new library();
        library.setLibraryName("University of zanjan");

        libraryAdmin admin = new libraryAdmin();
        admin.setFirstName("mohammad");
        admin.setLastName("dabiri");
        admin.setEducationLevel("کارشناسی ارشد");

        libraryManager manager1 = new libraryManager();
        manager1.setFirstName("mahdi");
        manager1.setLastName("davirani");
        manager1.setUserId(99);

        libraryManager manager2 = new libraryManager();
        manager2.setFirstName("amir");
        manager2.setLastName("moradi");
        manager2.setUserId(98);

        library.addManager(manager1);
        library.addManager(manager2);

    }
}

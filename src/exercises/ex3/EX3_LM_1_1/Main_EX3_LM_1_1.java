package exercises.ex3.EX3_LM_1_1;

public class Main_EX3_LM_1_1 {
    public static void main(String[] args) {
        BookInfo book1 = new BookInfo();
        BookInfo book2 = new BookInfo();
        StudentInfo student1 = new StudentInfo();
        StudentInfo student2 = new StudentInfo();

        book1.bookName = "English Book";
        book1.bookAuthor = "Mohammad";
        book1.numberPages = 100;
        book1.yearPublication = 2017;

        book2.bookName = "Mathematics Book";
        book2.bookAuthor = "Ali";
        book2.numberPages = 400;
        book2.yearPublication = 2011;

        System.out.println("Book1");
        System.out.format("bookName: %s\n",book1.bookName);
        System.out.format("bookAuthor: %s\n",book1.bookAuthor);
        System.out.format("number of Pages: %d\n",book1.numberPages);
        System.out.format("year of Publication: %d\n\n",book1.yearPublication);

        System.out.println("Book2");
        System.out.format("bookName: %s\n",book2.bookName);
        System.out.format("bookAuthor: %s\n",book2.bookAuthor);
        System.out.format("number of Pages: %d\n",book2.numberPages);
        System.out.format("year of Publication: %d\n\n",book2.yearPublication);


        student1.studentFirstName = "Mohammad";
        student1.studentLastName = "Davirani";
        student1.fieldStudy = "Computer";
        student1.studentId = 403463703;

        student2.studentFirstName = "Milad";
        student2.studentLastName = "Hassanlou";
        student2.fieldStudy = "Computer";
        student2.studentId = 403463111;

        System.out.println("Student1");
        System.out.format("FirstName: %s\n",student1.studentFirstName);
        System.out.format("LastName: %s\n",student1.studentLastName);
        System.out.format("field of Study: %s\n",student1.fieldStudy);
        System.out.format("studentId: %d\n\n",student1.studentId);

        System.out.println("Student2");
        System.out.format("FirstName: %s\n",student2.studentFirstName);
        System.out.format("LastName: %s\n",student2.studentLastName);
        System.out.format("field of Study: %s\n",student2.fieldStudy);
        System.out.format("studentId: %d\n\n",student2.studentId);
    }
}

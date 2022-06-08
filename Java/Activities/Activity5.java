package activities;

abstract class Book {
    String title;
    abstract public void setTitle(String s);
    public String getTitle() {
                return title;
    }
}

class MyBook extends Book {
    public void setTitle(String s) {
        title = s;
    }
}

public class Activity5 {
    public static void main(String[] arg) {
        MyBook book1 = new MyBook();
        book1.setTitle("Murder in the Time of Corona");
        System.out.println(book1.getTitle());

    }
}

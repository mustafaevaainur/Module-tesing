package domainmodel;

public class BookAboutSpaceShips implements Book {

    private String bookName = null;

    public BookAboutSpaceShips(String name) {
        this.bookName = name;
    }

    @Override
    public String getBookName() {
        return bookName;
    }

}


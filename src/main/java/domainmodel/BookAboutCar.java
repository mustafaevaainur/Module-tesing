package domainmodel;

public class BookAboutCar implements Book {

    private String carName = null;

    public BookAboutCar(String name) {
        this.carName = name;
    }

    @Override
    public String getBookName() {
        return null;
    }
}

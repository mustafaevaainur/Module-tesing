package domainmodel;

public class FordPerson implements Person {

    private Book book;
    private Emotion emotion;

    @Override
    public void read(Boolean hasAdmirable, Book b) {
        if(hasAdmirable && b instanceof BookAboutSpaceShips) {
            this.emotion = Emotion.Exclamation;
        } else {
            this.emotion = null;
        }
        this.book = b;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public Book getBook() {
        return book;
    }
}

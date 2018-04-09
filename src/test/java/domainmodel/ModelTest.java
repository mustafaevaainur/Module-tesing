package domainmodel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModelTest {

    Person person = new FordPerson();
    Book bookAboutSpaceShips = new BookAboutSpaceShips("Human Mission to Alpha Centauri");
    Observer observer = new Observer();
    Book bookAboutCar = new BookAboutCar("car");


    @Test
    @DisplayName("Check FordPerson Exclamation")
    void readingBookWithAdmire(){
        person.read(true, bookAboutSpaceShips);
        assertEquals(person.getEmotion(), Emotion.Exclamation);
        assertEquals(person.getBook(), bookAboutSpaceShips);
    }

    @Test
    @DisplayName("Check FordPerson null emotion")
    void readingBookWithoutAdmire() {
        person.read(false, bookAboutSpaceShips);
        assertEquals(person.getBook(), bookAboutSpaceShips);
        assertEquals(person.getEmotion(), null);
    }

    @Test
    @DisplayName("Check FordPerson ability to read several books")
    void readingSeveralBook() {
        person.read(false, bookAboutCar);
        assertEquals(person.getBook(), bookAboutCar);
        assertEquals(person.getEmotion(), null);
        person.read(true, bookAboutSpaceShips);
        assertEquals(person.getBook(), bookAboutSpaceShips);
        assertEquals(person.getEmotion(), Emotion.Exclamation);
    }

    @Test
    @DisplayName("check ford presence at the beginning")
    void checkFordPresence(){
        assertEquals(observer.isFordAbsent(), true);
    }

    @Test
    @DisplayName("check tech state at the beginning")
    void checkTechState(){
        assertEquals(observer.getTechnologiesTechState(), Observer.TechState.INPROGRESS);
    }

    @Test
    @DisplayName("check ford presence after being observed")
    void checkFordPresenceSecond() {
        observer.observe(person);
        assertEquals(observer.isFordAbsent(), false);
    }

    @Test
    @DisplayName("check tech state after beginning observing Ford")
    void checkStateAfterObserving(){
        person.read(true, bookAboutSpaceShips);
        observer.observe(person);
        assertEquals(observer.getTechnologiesTechState(), Observer.TechState.ADVANCED);
        assertEquals(observer.isFordAbsent(), false);
    }

    @Test
    @DisplayName("check tech state after beginning of observing of wrong book reading")
    void checkStateAfterObservingWrongBookReading(){
        person.read(true, bookAboutCar);
        observer.observe(person);
        assertEquals(observer.getTechnologiesTechState(), Observer.TechState.INPROGRESS);
        assertEquals(observer.isFordAbsent(), false);
    }
}

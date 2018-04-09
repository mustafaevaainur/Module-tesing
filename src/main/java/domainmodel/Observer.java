package domainmodel;

public class Observer {

    public enum TechState {
        ADVANCED, INPROGRESS
    }

    private boolean isFordAbsent = true;

    private Person person;

    public void observe(Person person) {
        if(this.person == null && person instanceof FordPerson) {
            this.person = person;
            isFordAbsent = false;
        }
    }

    public TechState getTechnologiesTechState() {
        if(person instanceof FordPerson) {
            FordPerson fordPerson = (FordPerson)person;
            boolean condition =
                    fordPerson.getEmotion() == Emotion.Exclamation &&
                            fordPerson.getBook() instanceof BookAboutSpaceShips;
            if(condition){
                return TechState.ADVANCED;
            }
        }
        return TechState.INPROGRESS;
    }

    public boolean isFordAbsent() {
        return isFordAbsent;
    }
}

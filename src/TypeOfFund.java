import java.util.Random;

public enum TypeOfFund {

    STATE,
    NOT_STATE,
    SCAM;

    public static TypeOfFund getRandomType() {
        TypeOfFund[] types = TypeOfFund.values();
        Random random = new Random();
        return types[random.nextInt(values().length)];
    }
}

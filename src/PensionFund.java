import java.util.Objects;

public class PensionFund {

    private static final double PENSION_COEFFICIENT = 0.02;
    private static final int AVERAGE_SALARY = 1500;

    private String name;
    private final String data;

    private TypeOfFund type;

    public PensionFund(String name, String data, TypeOfFund type) {
        this.name = name;
        this.data = data;
        this.type = type;
    }
    public double calculatePension(int age, double minSalary, double maxSalary) {
        double averageSalary;
        switch (type) {
            case STATE:
                averageSalary = AverageUtils.average(minSalary, maxSalary);
                break;
            case NOT_STATE:
                averageSalary = AverageUtils.average(minSalary, maxSalary, AVERAGE_SALARY);
                break;
            case SCAM:
                averageSalary = 0;
                break;
            default:
                averageSalary = 0;
        }
        return averageSalary * age * PENSION_COEFFICIENT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PensionFund that = (PensionFund) o;

        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(data, that.data)) return false;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PensionFund{" +
                "name='" + name + '\'' +
                ", data='" + data + '\'' +
                ", type=" + type +
                '}';
    }
}

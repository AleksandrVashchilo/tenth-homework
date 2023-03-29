import java.util.Map;

public class Company {

    private String name;

    private Map<String, String> holidays;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getHolidays() {
        return holidays;
    }

    public void setHolidays(Map<String, String> holidays) {
        this.holidays = holidays;
    }

    public Company(String name) {
        this.name = name;
    }
}

public class DataBaseWriter<T> {

    private String database;
    private T value;

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DataBaseWriter(String database, T value) {
        this.database = database;
        this.value = value;
    }

    public void save() {

        System.out.printf("данные в бд записаны, тип данных = %s", value.getClass());
    }
}

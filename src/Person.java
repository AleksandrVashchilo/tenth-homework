import java.util.List;
import java.util.Objects;

public abstract class Person implements Comparable<Person>{

    private String name;
    private int age;
    private int height;
    private int weight;

    private List<Person> children;

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public Person(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public Person() {
    }

    public void info() {
        System.out.println(name + " " + age + " " + height + " " + weight);
    }

    public void work() {
        if (age < 18 || age > 70) {
            System.out.println("отдыхаю дома");
        }
        else {
            System.out.println("работаю");
        }
    }


    public abstract void die();

    public void infoAboutChildren() {
        int counter = 0;
        System.out.println("У меня " + children.size() + " детей");
        for (Person child : children) {
            counter++;
            System.out.println(counter + ") " + child.name);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (height != person.height) return false;
        if (weight != person.weight) return false;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + height;
        result = 31 * result + weight;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        int firstNameLen = name.length();
        int secondNameLen = o.name.length();
        if (firstNameLen != secondNameLen) {
            return Integer.compare(firstNameLen, secondNameLen);
        }
        else {
            return Integer.compare(age, o.age);
        }
    }
}


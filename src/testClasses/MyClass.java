package testClasses;


public class MyClass {

    public MyClass() {}

    public MyClass(String name, int id, long number, String nick) {
        this.name = name;
        this.id = id;
        this.number = number;
        this.nick = nick;
    }

    private String name;

    private int id;

    private long number;

    private String nick;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyClass myClass = (MyClass) o;

        if (id != myClass.id) return false;
        if (number != myClass.number) return false;
        if (!name.equals(myClass.name)) return false;
        return nick.equals(myClass.nick);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + id;
        result = 31 * result + (int) (number ^ (number >>> 32));
        result = 31 * result + nick.hashCode();
        return result;
    }
}

package homework9.phonebook;

public class Record {

    private String name;
    private String number;

    public Record(String name, String number){
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Record record)) return false;

        if (!getName().equals(record.getName())) return false;
        return getNumber().equals(record.getNumber());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getNumber().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Record{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}

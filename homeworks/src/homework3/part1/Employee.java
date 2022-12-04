package homework3.part1;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int age;

    public Employee(String fullName, String position, String email, String phone, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;

        if (getAge() != employee.getAge()) return false;
        if (!getFullName().equals(employee.getFullName())) return false;
        if (!getPosition().equals(employee.getPosition())) return false;
        if (!getEmail().equals(employee.getEmail())) return false;
        return getPhone().equals(employee.getPhone());
    }

    @Override
    public int hashCode() {
        int result = getFullName().hashCode();
        result = 31 * result + getPosition().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPhone().hashCode();
        result = 31 * result + getAge();
        return result;
    }
}

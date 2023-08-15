package selenium;

public class EmployeeUser {
    private String name;

    private String position;
    private String office;

    public EmployeeUser(String name, String position, String office) {
        this.name = name;
        this.position = position;
        this.office = office;
    }

    @Override
    public String toString() {
        return "EmployeeUser{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", office='" + office + '\'' +
                '}';
    }
}

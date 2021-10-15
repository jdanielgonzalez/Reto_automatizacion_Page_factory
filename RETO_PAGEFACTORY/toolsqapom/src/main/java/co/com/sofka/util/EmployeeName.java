package co.com.sofka.util;

public enum EmployeeName {
    EMPLOYEE_NAME1("Paul Collings"),
    EMPLOYEE_NAME2("Jordan Mathews"),
    EMPLOYEE_NAME3("Jadine Jackie0");

    private final String value;

    EmployeeName(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}

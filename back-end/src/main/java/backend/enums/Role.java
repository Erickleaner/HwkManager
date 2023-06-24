package backend.enums;
public enum Role {
    STUDENT("student"),
    TEACHER("teacher");
    public String value;

    Role(String value) {
        this.value = value;
    }
}

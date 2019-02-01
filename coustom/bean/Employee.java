package coustom.bean;

/**
 * @author Pop
 * @date 2019/2/1 17:58
 */
public class Employee {
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s ",name,email);
    }
}

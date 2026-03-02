package ru.job4j.generics;

public class Role extends Base {
    private String roleName;

    public Role(String id, String role) {
        super(id);
        this.roleName = role;
    }

    public String getRoleName() {
        return roleName;
    }
}

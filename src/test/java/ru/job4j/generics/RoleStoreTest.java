package ru.job4j.generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {

    @Test
    void whenAddAndFindThenRoleNameIsAdministrator() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Administrator"));
        Role result = roleStore.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Administrator");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Administrator"));
        Role result = roleStore.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRoleNameIsAdministrator() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Administrator"));
        roleStore.add(new Role("1", "User"));
        Role result = roleStore.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Administrator");
    }

    @Test
    void whenReplaceThenRoleNameIsUser() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Administrator"));
        roleStore.replace("1", new Role("1", "User"));
        Role result = roleStore.findById("1");
        assertThat(result.getRoleName()).isEqualTo("User");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeRoleName() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Administrator"));
        roleStore.replace("10", new Role("2", "User"));
        Role result = roleStore.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Administrator");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Administrator"));
        roleStore.delete("1");
        Role result = roleStore.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Administrator"));
        boolean result = roleStore.replace("1", new Role("1", "User"));
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Administrator"));
        boolean result = roleStore.replace("10", new Role("10", "User"));
        assertThat(result).isFalse();
    }
}
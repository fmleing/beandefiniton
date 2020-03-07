package com.feng.spring.bean.pojo;

public class User {
    private Long id;
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static User createUser() {
        User user = new User();
        user.setName("小明");
        user.setId(1L);
        return user;
    }
}

package com.ah.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String addr;
    private Integer tel;
    private Integer balance;

    public User(Integer id, String name, String addr, Integer tel) {
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", tel=" + tel +
                ", balance=" + balance +
                '}';
    }
}

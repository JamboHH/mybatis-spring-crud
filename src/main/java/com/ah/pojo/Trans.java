package com.ah.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trans {
    private String sourceName;//转出账户
    private String targetName;//转入账户
    Integer money;//转入金额

    @Override
    public String toString() {
        return "Trans{" +
                "sourceName='" + sourceName + '\'' +
                ", targetName='" + targetName + '\'' +
                ", money=" + money +
                '}';
    }
}

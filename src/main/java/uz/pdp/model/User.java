package uz.pdp.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private Integer id;

    private String name;

    private String username;

    private String password;

    private String prePassword;
}

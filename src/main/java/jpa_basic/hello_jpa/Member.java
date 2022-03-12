package jpa_basic.hello_jpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Member {

    @Id
    private Long Id;
    private String name;
}

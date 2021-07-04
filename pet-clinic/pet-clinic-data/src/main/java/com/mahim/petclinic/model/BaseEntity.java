package com.mahim.petclinic.model;

import lombok.*;
import org.springframework.util.StringUtils;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer data;
    private Boolean isUpdated;

    private String doSomething() {
        if (StringUtils.containsWhitespace(name) || StringUtils.hasText(name)) {
            System.out.println(name);
        }

        return name.concat(" welcome to the java world");
    }
}

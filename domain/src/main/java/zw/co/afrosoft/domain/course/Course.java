package zw.co.afrosoft.domain.course;

import zw.co.afrosoft.domain.base.*;
import zw.co.afrosoft.domain.student.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Course extends BaseEntity {

    @Column(nullable = false,length = 100, unique = true)
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false,length = 100, unique = true)
    private Code code;


    public Course() {

    }

    public Course(String name, Code code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }



}

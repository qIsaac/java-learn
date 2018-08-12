package com.isaac.guava.base;

import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 11:36 2018/7/26
 */

public class ObjectTest {
    public static void main(String[] args) {
      /*  Student s1 = new Student("Mahesh", "Parashar", 1, "VI");
        Student s2 = new Student("Suresh", null, 3, null);*/
        Student s1 = new Student("Mahesh", "Parashar", 1, "VI");
        Student s2 = new Student("Suresh", null, 3, null);
        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
    }

}
@Data
@AllArgsConstructor
class Student {
    private String firstName;
    private String lastName;
    private int rollNo;
    private String className;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

           /* if (rollNo != student.rollNo) return false;
            if (firstName != null ? !firstName.equals(student.firstName) : student.firstName != null) return false;
            if (lastName != null ? !lastName.equals(student.lastName) : student.lastName != null) return false;*/
        return Objects.equal(firstName,student.firstName) && Objects.equal(lastName,student.lastName)
                && Objects.equal(rollNo,student.rollNo) && Objects.equal(className,student.className);
    }

    @Override
    public int hashCode() {
           /* int result = super.hashCode();
            result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
            result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
            result = 31 * result + rollNo;
            result = 31 * result + (className != null ? className.hashCode() : 0);*/
        return Objects.hashCode(className,rollNo);
    }
}

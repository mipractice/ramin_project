# appFX
```sql
CREATE SCHEMA `Project` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
```
-------
```sql
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `age` int(3) DEFAULT NULL,
  `email` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
```
-------

```java
import com.resud.cernel.StudentMethod;
import com.resud.entity.Student;
import org.junit.Test;

import java.util.Date;
import java.util.List;


public class StudentTests {

    StudentMethod studentMethod = new StudentMethod();

    @Test
    public void testAddStudent() throws Exception{
        Student student = new Student();
        student.setNameStudent("Name");
        student.setAgeStudent(24);
        student.setEmailStudent("example@gmail.com");
    
        Student student1 = studentMethod.addStudent(student);
        System.out.println(student1);
    }

    @Test
    public void testDeleteStudent() throws Exception{
        Student student = new Student();
        student.setNameStudent("Name");
        student.setAgeStudent(24);
        student.setEmailStudent("example@gmail.com");

        Student student1 = studentMethod.addStudent(student);

        studentMethod.deleteStudent(student1.getIdStudent());
    }

    @Test
    public void testSelectStudent() throws Exception{
        Student student = new Student();
        student.setNameStudent("Name");
        student.setAgeStudent(24);
        student.setEmailStudent("example@gmail.com");

        Student student1 = studentMethod.addStudent(student);

        Student student2 = studentMethod.get(student1.getIdStudent());
        System.out.println(student2);
    }

    @Test
    public void testGetAllStudent() throws Exception{
        List<Student> students = studentMethod.getAllStudent();

        for(Student stu : students){
            System.out.println(stu);
        }
    }

}

```
package hello;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "a")
public class A {
    @Id
    @Column(name = "id")
    long id;

    @Column(name = "date") LocalDate date;
}

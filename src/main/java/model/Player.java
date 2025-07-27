package model;


import jakarta.persistence.*;

@Entity
@Table(name = "Players", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

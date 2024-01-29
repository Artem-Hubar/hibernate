package org.hibernate.db;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "consumer", schema = "simpleshop", catalog = "")
public class ConsumerEntity {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idConsumer")
    private int idConsumer;
    @Basic
    @Column(name = "name")
    private String name;
    public ConsumerEntity(String name) {
        this.name = name;
    }

    public ConsumerEntity() {
    }
    public int getIdConsumer() {
        return idConsumer;
    }

    public void setIdConsumer(int idConsumer) {
        this.idConsumer = idConsumer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsumerEntity that = (ConsumerEntity) o;
        return idConsumer == that.idConsumer && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idConsumer, name);
    }
}

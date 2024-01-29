package org.hibernate.db;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "sellor", schema = "simpleshop", catalog = "")
public class SellorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idSellor")
    private int idSellor;

    public SellorEntity(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "name")
    private String name;

    public SellorEntity() {
    }

    public int getIdSellor() {
        return idSellor;
    }

    public void setIdSellor(int idSellor) {
        this.idSellor = idSellor;
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
        SellorEntity that = (SellorEntity) o;
        return idSellor == that.idSellor && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSellor, name);
    }
}

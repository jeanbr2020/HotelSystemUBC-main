package br.com.brazcubas.hotelSystem.model.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}

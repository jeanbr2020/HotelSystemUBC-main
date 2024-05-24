package br.com.brazcubas.hotelSystem.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel extends AbstractEntity {
    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @Column(name = "descricao", length = 255, nullable = false)
    private String descricao;

    @Column(name = "preco", precision = 19, scale = 2, nullable = false)
    private double preco;

    // Novo campo para hospede
    @OneToOne
    @JoinColumn(name = "hospede_id")
    private Hospede hospede;

    // Novos campos para reserva
    @OneToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

    // Construtor sem id
    public Hotel(String nome, String descricao, double preco, Hospede hospede) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.hospede = hospede;
    }

    // Construtor com id
    public Hotel(Long id, String nome, String descricao, double preco, Hospede hospede) {
        super.setId(id);
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.hospede = hospede;
    }

    // Getters e setters
    // ...

    // Getters e setters para hospede
    public Hospede getHospede() { return this.hospede; }
    public void setHospede(Hospede hospede) { this.hospede = hospede; }

    // Getters e setters para reserva
    public Reserva getReserva() { return this.reserva; }
    public void setReserva(Reserva reserva) { this.reserva = reserva; }

    // Métodos de reserva
    public void reservar(Long cliente, String nomeCliente, String emailCliente, String dataInicio, String dataFim) {
        Reserva reserva = new Reserva(cliente, nomeCliente, emailCliente, dataInicio, dataFim);
        this.setReserva(reserva);
    }

    public void cancelarReserva(Long cliente) {
        if (this.reserva != null && this.reserva.getCliente().equals(cliente)) {
            this.setReserva(null);
        }
    }
}

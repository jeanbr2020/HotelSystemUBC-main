package br.com.brazcubas.hotelSystem.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
public class Hotel extends AbstractEntity {
    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @Column(name = "descricao", length = 255, nullable = false)
    private String descricao;

    @Column(name = "preco", precision = 19, scale = 2, nullable = false)
    private double preco;

    @Column(name = "reserva_cliente", length = 255)
    private String reservaCliente;

    @Column(name = "reserva_data_inicio", length = 255)
    private String reservaDataInicio;

    @Column(name = "reserva_data_fim", length = 255)
    private String reservaDataFim;

    // Novo construtor que aceita apenas o nome do hotel
    public Hotel(String nome) {
        this.nome = nome;
        // Você pode definir valores padrão para descricao e preco aqui, se desejar
        this.descricao = "";
        this.preco = 0.0;
    }

    // Construtor sem id
    public Hotel(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    // Construtor com id
    public Hotel(Long id, String nome, String descricao, double preco) {
        super.setId(id);
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    // Getters e setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public String getReservaCliente() { return reservaCliente;}
    public void setReservaCliente(String reservaCliente) { this.reservaCliente = reservaCliente;}

    public String getReservaDataInicio() { return reservaDataInicio;}
    public void setReservaDataInicio(String reservaDataInicio) { this.reservaDataInicio = reservaDataInicio;}

    public String getReservaDataFim() { return reservaDataFim;}
    public void setReservaDataFim(String reservaDataFim) { this.reservaDataFim = reservaDataFim;}
}

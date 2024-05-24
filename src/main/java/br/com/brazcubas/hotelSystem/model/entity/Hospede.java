package br.com.brazcubas.hotelSystem.model.entity;

public class Hospede {
    private Long id;
    private String nome;
    private int idade;
    private String contato;
    private Hotel hotel;

    public Hospede(String nome, int idade, String contato, Hotel hotel) {
        this.nome = nome;
        this.idade = idade;
        this.contato = contato;
        this.hotel = hotel;
    }

    public Hospede(Long id, String nome, int idade, String contato, Hotel hotel) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.contato = contato;
        this.hotel = hotel;
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getContato() {
        return this.contato;
    }

    public Hotel getHotel() {
        return this.hotel;
    }

    // ... (seus outros getters e setters) ...
}

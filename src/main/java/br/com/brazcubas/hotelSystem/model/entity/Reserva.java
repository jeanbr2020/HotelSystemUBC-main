package br.com.brazcubas.hotelSystem.model.entity;

public class Reserva {
    public Long id;
    public Long idHospede;
    public String nomeCliente;
    public String emailCliente;
    public Long idHotel;
    public Long idTipoQuarto;
    public String dataInicio;
    public String dataFim;
 
     public Reserva(Long id, Long idHospede, String nomeCliente, String emailCliente, Long idHotel, Long idTipoQuarto, String dataInicio, String dataFim) {
         this.id = id;
         this.idHospede = idHospede;
         this.nomeCliente = nomeCliente;
         this.emailCliente = emailCliente;
         this.idHotel = idHotel;
         this.idTipoQuarto = idTipoQuarto;
         this.dataInicio = dataInicio;
         this.dataFim = dataFim;
     }
 
     // getters e setters
     // ...
 }
 
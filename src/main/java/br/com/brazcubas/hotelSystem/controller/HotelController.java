package br.com.brazcubas.hotelSystem.controller;

import java.util.List;

import br.com.brazcubas.hotelSystem.model.dao.IDAO;
import br.com.brazcubas.hotelSystem.model.entity.Hotel;

public class HotelController {
    private final IDAO<Hotel> hotelDAO;

    // Construtor
    public HotelController (IDAO<Hotel> hotelDAO) {
      this.hotelDAO = hotelDAO;
    }

    // Controla cadastro de hóspedes
    public String cadastrarHotel(String nome, String descricao, double preco) {
      Hotel hotel = new Hotel(nome, descricao, preco);
      hotelDAO.cadastrar(hotel);
      return "Cadastro realizado!";
    }

    public String atualizarHotel(int id, String nome, String descricao, double preco) {
        Hotel hotel = new Hotel(id, nome, descricao, preco);
        hotelDAO.atualizar(hotel);
        return "Atualização realizada!";
    }
    
    public String excluirHotel(int id) {
      hotelDAO.excluir(id);
      return "Exclusão realizada!";
    }
  
    public Hotel buscarHotel(int id) {
      return hotelDAO.buscar(id);
    }
    public List<Hotel> listarHoteis() {
      return hotelDAO.listar();
    }

    // Controla reserva de hotel
    public Hotel buscarReserva(int id) {
      Hotel hotel = hotelDAO.buscar(id);
      if(hotel.getReservaCliente() != null) {
          return hotel;
      } else {
          return null;
      }
    }

    public String reservarHotel(int id, String cliente, String dataInicio, String dataFim) {
      Hotel hotel = hotelDAO.buscar(id);
      hotel.setReservaCliente(cliente);
      hotel.setReservaDataInicio(dataInicio);
      hotel.setReservaDataFim(dataFim);
      hotelDAO.atualizar(hotel);
      return "Hotel reservado com sucesso!";
    }

    public String cancelarReserva(int id) {
      Hotel hotel = hotelDAO.buscar(id);
      hotel.setReservaCliente(null);
      hotel.setReservaDataInicio(null);
      hotel.setReservaDataFim(null);
      hotelDAO.atualizar(hotel);
      return "Reserva cancelada com sucesso!";
    }

    public List<Hotel> listarReservas() {
      return hotelDAO.listarReservas();
    }
}

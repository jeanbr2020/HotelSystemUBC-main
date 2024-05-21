package br.com.brazcubas.hotelSystem.controller;

import java.util.List;

import br.com.brazcubas.hotelSystem.model.dao.IDAO;
import br.com.brazcubas.hotelSystem.model.entity.Hotel;

public class HotelController {
    private final IDAO<Hotel> hotelDAO;

    //>>>>>> CONSTRUTOR
    public HotelController (IDAO<Hotel> hotelDAO) {
      this.hotelDAO = hotelDAO;
    }

    //>>>>>> CONTROLA CADASTRO DE HÓSPEDES
    public String cadastrarHotel(Hotel hotel) {
      hotelDAO.cadastrar(hotel);
      return "Cadastro realizado!";
    }

    public String atualizarHotel(Hotel hotel) {
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

    //>>>>>> CONTROLA RESERVA DE HOTEL
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

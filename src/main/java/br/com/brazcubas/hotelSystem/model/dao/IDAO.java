package br.com.brazcubas.hotelSystem.model.dao;

import java.util.List;
import br.com.brazcubas.hotelSystem.model.entity.Hotel;

public interface IDAO {
    //>>>> REGISTER CONTROL
    void cadastrar(Hotel hotel);
    void atualizar(Hotel hotel);
    void excluir(int id);
    Hotel buscar(int id);
    List<Hotel> listar();
    //>>>> RESERVA CONTROL
    void reservar(Hotel hotel);
    void cancelarReserva(int id);
    Hotel buscarReserva(int id);
    List<Hotel> listarReservas();
}

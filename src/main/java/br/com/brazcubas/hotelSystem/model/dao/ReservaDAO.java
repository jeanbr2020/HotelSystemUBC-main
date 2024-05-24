package br.com.brazcubas.hotelSystem.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface ReservaDAO<T> {
    // Controle de reserva
    void reservar(Long id, Long idHotel, Long idCliente, String nomeCliente, String emailCliente, String dataInicio, String dataFim) throws SQLException;
    void cancelarReserva(Long idHotel, Long idCliente) throws SQLException;
    T buscarReserva(Long id) throws SQLException;
    List<T> listarReservas() throws SQLException;
}
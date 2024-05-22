package br.com.brazcubas.hotelSystem.model.dao;

import java.util.List;

public interface IDAO<T> {
    // Controle de registro
    void cadastrar(T t);
    void atualizar(T t);
    void excluir(Long id);
    T buscar(Long id);
    List<T> listar();
    // Controle de reserva
    void reservar(T t);
    void cancelarReserva(Long id);
    T buscarReserva(Long id);
    List<T> listarReservas();
}

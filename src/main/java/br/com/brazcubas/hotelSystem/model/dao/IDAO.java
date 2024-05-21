package br.com.brazcubas.hotelSystem.model.dao;

import java.util.List;

public interface IDAO<T> {
    // Controle de registro
    void cadastrar(T t);
    void atualizar(T t);
    void excluir(int id);
    T buscar(int id);
    List<T> listar();
    // Controle de reserva
    void reservar(T t);
    void cancelarReserva(int id);
    T buscarReserva(int id);
    List<T> listarReservas();
}

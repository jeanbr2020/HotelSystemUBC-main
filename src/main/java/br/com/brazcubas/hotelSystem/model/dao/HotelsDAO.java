package br.com.brazcubas.hotelSystem.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface HotelsDAO<T> {
    // Controle de registro
    void cadastrar(T t) throws SQLException;
    void atualizar(T t) throws SQLException;
    void excluir(Long id) throws SQLException;
    T buscar(Long id) throws SQLException;
    List<T> listar() throws SQLException;
    
    // Controle de hospede
    void adicionarHospede(Long idHotel, Long idHospede) throws SQLException;
    void removerHospede(Long idHotel) throws SQLException;
    T buscarHospede(Long idHotel) throws SQLException;
    List<T> listarHospedes() throws SQLException;
}

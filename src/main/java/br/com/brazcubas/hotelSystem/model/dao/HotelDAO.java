package br.com.brazcubas.hotelSystem.model.dao;

import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.brazcubas.hotelSystem.config.DatabaseConfig;
import br.com.brazcubas.hotelSystem.model.entity.Hotel;
import br.com.brazcubas.hotelSystem.model.entity.Reserva;

@Repository
public class HotelDAO implements IDAO<Hotel> {

    @Override
    public void cadastrar(Hotel hotel) throws SQLException {
        String sql = "INSERT INTO hotel (nome, descricao, preco, hospede_id, reserva_cliente, reserva_nome_cliente, reserva_email_cliente, reserva_data_inicio, reserva_data_fim) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, hotel.getNome());
            pstmt.setString(2, hotel.getDescricao());
            pstmt.setDouble(3, hotel.getPreco());
            pstmt.setLong(4, hotel.getHospede().getId());
            pstmt.setLong(5, hotel.getReserva().getCliente());
            pstmt.setString(6, hotel.getReserva().getNomeCliente());
            pstmt.setString(7, hotel.getReserva().getEmailCliente());
            pstmt.setString(8, hotel.getReserva().getDataInicio());
            pstmt.setString(9, hotel.getReserva().getDataFim());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void atualizar(Hotel hotel) throws SQLException {
        String sql = "UPDATE hotel SET nome = ?, descricao = ?, preco = ?, hospede_id = ?, reserva_cliente = ?, reserva_nome_cliente = ?, reserva_email_cliente = ?, reserva_data_inicio = ?, reserva_data_fim = ? WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, hotel.getNome());
            pstmt.setString(2, hotel.getDescricao());
            pstmt.setDouble(3, hotel.getPreco());
            pstmt.setLong(4, hotel.getHospede().getId());
            pstmt.setLong(5, hotel.getReserva().getCliente());
            pstmt.setString(6, hotel.getReserva().getNomeCliente());
            pstmt.setString(7, hotel.getReserva().getEmailCliente());
            pstmt.setString(8, hotel.getReserva().getDataInicio());
            pstmt.setString(9, hotel.getReserva().getDataFim());
            pstmt.setLong(10, hotel.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Restante do código...
    @Override
    public void reservar(Long id, Long clienteId, String nomeCliente, String emailCliente, String dataInicio, String dataFim) {
        String sql = "INSERT INTO reserva (idHospede, idHotel, dataInicio, dataFim) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, clienteId);
            pstmt.setLong(2, id);
            pstmt.setString(3, dataInicio);
            pstmt.setString(4, dataFim);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Hotel> listar() {
        List<Hotel> hoteis = new ArrayList<>();
        String sql = "SELECT * FROM hotel";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                // Aqui você pode adicionar cada hotel à lista
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return hoteis;
    }

    @Override
    public List<Reserva> listarReservas() {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reserva";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                // Aqui você pode adicionar cada reserva à lista
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return reservas;
    }

    @Override
    public Hotel buscar(Long id) {
        Hotel hotel = null;
        String sql = "SELECT * FROM hotel WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Aqui você pode criar um novo objeto Hotel com os dados do ResultSet
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return hotel;
    }

    @Override
    public Reserva buscarReserva(Long id) {
        Reserva reserva = null;
        String sql = "SELECT * FROM reserva WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Aqui você pode criar um novo objeto Reserva com os dados do ResultSet
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return reserva;
    }

    @Override
    public void excluir(Long id) {
        String sql = "DELETE FROM hotel WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void cancelarReserva(Long id, Long reservaId) {
        String sql = "DELETE FROM reserva WHERE id = ? AND idHotel = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, reservaId);
            pstmt.setLong(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void adicionarHospede(Long idHotel, Long idHospede) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'adicionarHospede'");
    }

    @Override
    public void removerHospede(Long idHotel) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'removerHospede'");
    }

    @Override
    public Hotel buscarHospede(Long idHotel) throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'buscarHospede'");
    }

    @Override
    public List<Hotel> listarHospedes() throws SQLException {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'listarHospedes'");
    }
}


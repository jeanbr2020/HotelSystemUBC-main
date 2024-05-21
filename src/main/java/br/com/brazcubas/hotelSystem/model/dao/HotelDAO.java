package br.com.brazcubas.hotelSystem.model.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.brazcubas.hotelSystem.config.DatabaseConfig;
import br.com.brazcubas.hotelSystem.model.entity.Hotel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class HotelDAO implements IDAO {

    // >>>>> OPERAÇÕES NA TABELA HOTEL
    @Override
    public void cadastrar(Hotel hotel) {
        String sql = "INSERT INTO hotel (nome, descricao, preco, reservaCliente, reservaDataInicio, reservaDataFim) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, hotel.getNome());
                stmt.setString(2, hotel.getDescricao());
                stmt.setDouble(3, hotel.getPreco());
                stmt.setString(4, hotel.getReservaCliente());
                stmt.setString(5, hotel.getReservaDataInicio());
                stmt.setString(6, hotel.getReservaDataFim());

                stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Hotel hotel) {
        String sql = "UPDATE hotel SET nome = ?, descricao = ?, preco = ?, reservaCliente = ?, reservaDataInicio = ?, reservaDataFim = ? WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, hotel.getNome());
                stmt.setString(2, hotel.getDescricao());
                stmt.setDouble(3, hotel.getPreco());
                stmt.setString(4, hotel.getReservaCliente());
                stmt.setString(5, hotel.getReservaDataInicio());
                stmt.setString(6, hotel.getReservaDataFim());
                stmt.setInt(7, hotel.getId());

                stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ... Restante do código ...

    // >>>>> OPERAÇÕES NA TABELA RESERVA
    @Override
    public Hotel buscarReserva(int id) {
        String sql = "SELECT * FROM hotel WHERE id = ? AND reservaCliente IS NOT NULL";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);

                ResultSet rs = stmt.executeQuery();
                if(rs.next()) {
                    Hotel hotel = new Hotel();
                    hotel.setId(rs.getInt("id"));
                    hotel.setNome(rs.getString("nome"));
                    hotel.setDescricao(rs.getString("descricao"));
                    hotel.setPreco(rs.getDouble("preco"));
                    hotel.setReservaCliente(rs.getString("reservaCliente"));
                    hotel.setReservaDataInicio(rs.getString("reservaDataInicio"));
                    hotel.setReservaDataFim(rs.getString("reservaDataFim"));

                    return hotel;
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Hotel> listarReservas() {
        List<Hotel> hoteis = new ArrayList<Hotel>();
        String sql = "SELECT * FROM hotel WHERE reservaCliente IS NOT NULL";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {

                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {
                    Hotel hotel = new Hotel();
                    hotel.setId(rs.getInt("id"));
                    hotel.setNome(rs.getString("nome"));
                    hotel.setDescricao(rs.getString("descricao"));
                    hotel.setPreco(rs.getDouble("preco"));
                    hotel.setReservaCliente(rs.getString("reservaCliente"));
                    hotel.setReservaDataInicio(rs.getString("reservaDataInicio"));
                    hotel.setReservaDataFim(rs.getString("reservaDataFim"));

                    hoteis.add(hotel);
                }

                return hoteis;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

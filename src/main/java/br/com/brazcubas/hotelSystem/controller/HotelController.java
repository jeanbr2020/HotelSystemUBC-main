package br.com.brazcubas.hotelSystem.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;

import br.com.brazcubas.hotelSystem.config.DatabaseConfig;
import br.com.brazcubas.hotelSystem.model.dao.HotelDAO;

@Controller
public class HotelController {
    public HotelDAO hotelDAO;

    // Construtor que aceita um objeto HotelDAO
    public HotelController(HotelDAO hotelDAO) {
        this.hotelDAO = hotelDAO;
    }

    // Método para adicionar um novo hotel
    public void addHotel(String nome, String descricao, double preco) {
        String sql = "INSERT INTO hotel (nome, descricao, preco) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nome);
            pstmt.setString(2, descricao);
            pstmt.setDouble(3, preco);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para atualizar um hotel existente
    public void updateHotel(int id, String nome, String descricao, double preco) {
        String sql = "UPDATE hotel SET nome = ?, descricao = ?, preco = ? WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nome);
            pstmt.setString(2, descricao);
            pstmt.setDouble(3, preco);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para deletar um hotel
    public void deleteHotel(int id) {
        String sql = "DELETE FROM hotel WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

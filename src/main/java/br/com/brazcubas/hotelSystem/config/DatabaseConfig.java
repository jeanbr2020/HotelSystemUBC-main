package br.com.brazcubas.hotelSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class DatabaseConfig {
    // using postgreSQL as DB
    private static final String URL = "jdbc:postgresql://localhost:5432/db_hotelMgmtSys";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void createTables() throws SQLException {
        try (Connection conexao = getConnection()) {
            DatabaseMetaData dbm = conexao.getMetaData();
            // Snipet de validação existencia tabela hotel
            ResultSet tablesHotel = dbm.getTables(null, null, "hotel", null); // getTables(catalog, schemaPattern, tableNamePattern, types)
            if (!tablesHotel.next()) {
                String sqlHotel =
                            "CREATE TABLE hotel (" +
                                "id serial PRIMARY KEY," +
                                "nome varchar(100) NOT NULL," +
                                "descricao varchar(100) NOT NULL," +
                                "preco decimal NOT NULL," +
                                "reservaCliente varchar(100)," +
                                "reservaDataInicio varchar(100)," +
                                "reservaDataFim varchar(100)" +
                            ");";
                Statement statement = conexao.createStatement();
                statement.execute(sqlHotel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

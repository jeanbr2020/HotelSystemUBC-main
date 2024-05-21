package br.com.brazcubas.hotelSystem.model.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.brazcubas.hotelSystem.config.DatabaseConfig;
import br.com.brazcubas.hotelSystem.model.entity.Hotel;
// Pra setar a data do emprestimo
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// query
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class HotelDAO implements IDAO<Hotel> {

    // >>>>> OPERAÇÕES NA TABELA LIVRO
    @Override
    public void cadastrar(Hotel entidade) {
        String sql = "INSERT INTO livro (titulo, autor, numPaginas) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, entidade.getTitulo());
                stmt.setString(2, entidade.getAutor());
                stmt.setInt(3, entidade.getNumPaginas());
                    // substituindo os placeholders (os ?, ?, ? do String sql) na consulta SQL pelos valores reais. Ou seja, stmt.setType(posicao_valor_nos_interrogacao, ação), que no caso estamos pegando atributos de entidade (que é nossa instancia)

                stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Hotel entidade) {
        String sql = "UPDATE livro SET titulo = ?, autor = ?, numPaginas = ? WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, entidade.getTitulo());
                stmt.setString(2, entidade.getAutor());
                stmt.setInt(3, entidade.getNumPaginas());
                stmt.setInt(4, entidade.getId());

                stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM livro WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);

                stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Hotel buscar(int id) {
        String sql = "SELECT * FROM livro WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);

                ResultSet rs = stmt.executeQuery();

                if(rs.next()) { // Ver observação 1
                    String titulo = rs.getString("titulo");
                    String autor = rs.getString("autor");
                    int numPaginas = rs.getInt("numPaginas");
                    Hotel livro = new Hotel(id, titulo, autor, numPaginas);
                    return livro;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return null;
    }

    @Override
    public List<Hotel> listar() {
        List<Hotel> livros = new ArrayList<Hotel>();
        String sql = "SELECT * FROM livro";
        
        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {

                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {
                    int id = rs.getInt("id");
                    String titulo = rs.getString("titulo");
                    String autor = rs.getString("autor");
                    int numPaginas = rs.getInt("numPaginas");
                    Hotel livro = new Hotel(id, titulo, autor, numPaginas);
                    livros.add(livro);
                }

                return livros;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return null;
    }

    // >>>>> OPERAÇÕES NA TABELA LIVROEMPRESTADO
    @Override
    public Hotel buscarEmpr(int id) {
        String sql = "SELECT * FROM livroemprestado WHERE id_livro = ?";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);

                ResultSet rs = stmt.executeQuery();
                if(rs.next()) {
                    Hotel livro = buscar(id);
                    livro.setEmprestimoMembro(rs.getString("membro"));
                    livro.setEmprestimoResponsavel(rs.getString("funcionario"));
                    livro.setDt_emprestimo(rs.getString("dt_emprest"));
                    
                    return livro;
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void emprestar(Hotel entidade) {
        String sql = "INSERT INTO livroemprestado (membro, funcionario, dt_emprest, id_livro) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
                // No momento estou controlando a data de empréstimo como String.
                LocalDateTime agora = LocalDateTime.now();
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String dataFormatada = agora.format(formatador);

                stmt.setString(1, entidade.getEmprestimoMembro());
                stmt.setString(2, entidade.getEmprestimoResponsavel());
                stmt.setString(3, dataFormatada);
                stmt.setInt(4, entidade.getId());

                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void devolver(int id_livro) {
        String sql = "DELETE FROM livroemprestado WHERE id_livro = ?";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id_livro);

                stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Hotel> listarEmprest() {
        List<Hotel> livros = new ArrayList<Hotel>();
        String sql = "SELECT * FROM livroemprestado";
        
        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {

                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {
                    Hotel livro = buscar(rs.getInt("id_livro"));
                    livros.add(livro);
                }

                return livros;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return null;
    }
}

/*
OBSERVAÇÃO 1:
O método rs.next() é usado para mover o cursor para a próxima linha nos resultados retornados pela consulta SQL.

Quando uma consulta SQL é executada usando stmt.executeQuery(), um objeto ResultSet é retornado. Este objeto ResultSet representa uma tabela de dados, e inicialmente, o cursor está posicionado antes da primeira linha.

Ao chamar rs.next(), o cursor se move para a próxima linha. Se essa linha existir, rs.next() retorna true. Se não houver mais linhas (ou seja, se o cursor estiver agora após a última linha), rs.next() retorna false.

No seu caso, como você está buscando um livro por id, espera-se que no máximo um livro seja retornado. Portanto, você chama rs.next() uma vez para mover o cursor para a primeira (e única) linha retornada. Se um livro com o id fornecido for encontrado, rs.next() será true e você poderá recuperar os valores das colunas para esse livro. Se nenhum livro for encontrado, rs.next() será false e o método retornará null

 */

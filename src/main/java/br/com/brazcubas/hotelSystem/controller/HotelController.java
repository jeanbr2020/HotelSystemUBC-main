package br.com.brazcubas.hotelSystem;.controller;

import java.util.List;

import br.com.brazcubas.hotelSystem.model.dao.IDAO;
import br.com.brazcubas.hotelSystem.model.entity.Hotel;

public class HotelController {
    private final IDAO<Hotel> HotelDAO;

    //>>>>>> CONSTRUTOR
    public HotelController (IDAO<Hotel> HotelDAO) {
      this.HotelDAO = HotelDAO;
    }

    //>>>>>> CONTROLA CADASTRO LIVRO
    public String cadastrarHospedes(Hotel livro) {
      HotelDAO.cadastrar(livro);
      return "Cadastro realizado!";
    }

    public String atualizarHospedes(Hotel livro) {
        HotelDAO.atualizar(livro);
        return "Atualização realizada!";
      }
    
    public String excluirHospedes(int id) {
      HotelDAO.excluir(id);
      return "Exclusão realizada!";
    }
  
    public Hotel buscarLivro(int id) {
      return (Hotel) HotelDAO.buscar(id);
    }
    public List<Hotel> listarHospedes() {
      return HotelDAO.listar();
    }

    //>>>>>> CONTROLA EMPRESTIMO LIVRO
    public Hotel buscarLivroEmpr(int id) {
      return (Hotel) HotelDAO.buscarEmpr(id);
    }

    public String emprestaLivro(Hotel livro) {
      HotelDAO.emprestar(livro);
      return "Livro emprestado com sucesso!";
    }

    public String devolverLivro(int id) {
      HotelDAO.devolver(id);
      return "Livro devolvido com sucesso!";
    }

    public List<Hotel> listarLivrosEmprestados() {
      return HotelDAO.listarEmprest();
    }


}

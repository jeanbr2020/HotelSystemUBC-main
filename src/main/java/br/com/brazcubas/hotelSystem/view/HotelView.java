package br.com.brazcubas.hotelSystem.view;

import java.util.List;

import br.com.brazcubas.hotelSystem.model.entity.Hotel;

public class HotelView {
    public void mostrarDetalhesLivro(Hotel livro) {
        System.out.println(">>> Detalhes do livro <<<");
        System.out.println("ID " + livro.getId());
        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("Número de páginas: " + livro.getNumPaginas());
    }

    public void mostrarDetalhesEmprestimo(Hotel livro) {
        System.out.println(">>> Detalhes do Emprestimo <<<");
        System.out.println("ID " + livro.getId());
        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Data do emprestimo: " + livro.getDt_emprestimo());
        System.out.println("Emprestado para: " + livro.getEmprestimoMembro());
        System.out.println("Realizado por: " + livro.getEmprestimoResponsavel());
    }

    public void mostrarListaHospede(List<Hotel> livros) {
        System.out.println("Lista de livros: ");
        for (Hotel livro : livros) {
            System.out.println("ID: " + livro.getId() + ", Título: " + livro.getTitulo());
        }
    }
}
package br.com.brazcubas.hotelSystem.view;

import java.util.List;
import br.com.brazcubas.hotelSystem.model.entity.Hotel;

public class HotelView {
    public void mostrarDetalhesHotel(Hotel hotel) {
        System.out.println(">>> Detalhes do Hotel <<<");
        System.out.println("Nome: " + hotel.getNome());
        System.out.println("Descrição: " + hotel.getDescricao());
        System.out.println("Preço: " + hotel.getPreco());
        System.out.println("Hóspede: " + hotel.getHospede().getNome()); // Novo campo
        if(hotel.getReserva() != null) {
            System.out.println("Data de início da reserva: " + hotel.getReserva().getDataInicio());
            System.out.println("Data de fim da reserva: " + hotel.getReserva().getDataFim());
        }
    }

    public void mostrarListaHoteis(List<Hotel> hoteis) {
        System.out.println("Lista de Hoteis: ");
        for (Hotel hotel : hoteis) {
            System.out.println("Nome: " + hotel.getNome());
            System.out.println("Descrição: " + hotel.getDescricao());
            System.out.println("Preço: " + hotel.getPreco());
            System.out.println("Hóspede: " + hotel.getHospede().getNome()); // Novo campo
            if(hotel.getReserva() != null) {
                System.out.println("Data de início da reserva: " + hotel.getReserva().getDataInicio());
                System.out.println("Data de fim da reserva: " + hotel.getReserva().getDataFim());
            }
        }
    }
}

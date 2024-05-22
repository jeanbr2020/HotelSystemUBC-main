package br.com.brazcubas.hotelSystem.view;

import java.util.List;

import br.com.brazcubas.hotelSystem.model.entity.Hotel;

public class HotelView {
    public void mostrarDetalhesHotel(Hotel hotel) {
        System.out.println(">>> Detalhes do Hotel <<<");
        System.out.println("Nome: " + hotel.getNome());
        // Aqui você pode adicionar mais detalhes sobre o hotel, como endereço, número de quartos, etc.
    }

    public void mostrarDetalhesReserva(Hotel hotel) {
        System.out.println(">>> Detalhes da Reserva <<<");
        System.out.println("Nome do Hotel: " + hotel.getNome());
        System.out.println("Data de início da reserva: " + hotel.getReservaDataInicio());
        System.out.println("Data de fim da reserva: " + hotel.getReservaDataFim());
        System.out.println("Reservado para: " + hotel.getReservaCliente());
    }

    public void mostrarListaHoteis(List<Hotel> hoteis) {
        System.out.println("Lista de Hoteis: ");
        for (Hotel hotel : hoteis) {
            System.out.println("Nome: " + hotel.getNome());
        }
    }
}

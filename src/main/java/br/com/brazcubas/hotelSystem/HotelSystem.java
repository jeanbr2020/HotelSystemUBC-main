package br.com.brazcubas.hotelSystem;

import br.com.brazcubas.hotelSystem.model.entity.Hotel;
import java.util.ArrayList;
import java.util.List;

public class HotelSystem {
    private List<Hotel> hoteis;

    public HotelSystem() {
        this.hoteis = new ArrayList<>();
    }

    public void adicionarHotel(Hotel hotel) {
        hoteis.add(hotel);
    }

    public void removerHotel(Hotel hotel) {
        hoteis.remove(hotel);
    }

    public List<Hotel> getHoteis() {
        return hoteis;
    }

    public void realizarReserva(Hotel hotel, String cliente, String dataInicio, String dataFim) {
        hotel.setReservaCliente(cliente);
        hotel.setReservaDataInicio(dataInicio);
        hotel.setReservaDataFim(dataFim);
    }

    public void cancelarReserva(Hotel hotel) {
        hotel.setReservaCliente(null);
        hotel.setReservaDataInicio(null);
        hotel.setReservaDataFim(null);
    }
}

package br.com.brazcubas.hotelSystem.model.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.brazcubas.hotelSystem.model.entity.Hotel;

public class HotelDAO implements IDAO<Hotel> {
    private List<Hotel> hoteis = new ArrayList<>();

    @Override
    public void cadastrar(Hotel hotel) {
        hoteis.add(hotel);
    }

    @Override
    public void atualizar(Hotel hotel) {
        for (int i = 0; i < hoteis.size(); i++) {
            if (hoteis.get(i).getId() == hotel.getId()) {
                hoteis.set(i, hotel);
                break;
            }
        }
    }

    @Override
    public void excluir(int id) {
        hoteis.removeIf(hotel -> hotel.getId() == id);
    }

    @Override
    public Hotel buscar(int id) {
        for (Hotel hotel : hoteis) {
            if (hotel.getId() == id) {
                return hotel;
            }
        }
        return null;
    }

    @Override
    public List<Hotel> listar() {
        return hoteis;
    }

    @Override
    public void reservar(Hotel hotel) {
        atualizar(hotel);
    }

    @Override
    public void cancelarReserva(int id) {
        Hotel hotel = buscar(id);
        if (hotel != null) {
            hotel.setReservaCliente(null);
            hotel.setReservaDataInicio(null);
            hotel.setReservaDataFim(null);
            atualizar(hotel);
        }
    }

    @Override
    public Hotel buscarReserva(int id) {
        Hotel hotel = buscar(id);
        if (hotel != null && hotel.getReservaCliente() != null) {
            return hotel;
        }
        return null;
    }

    @Override
    public List<Hotel> listarReservas() {
        List<Hotel> reservas = new ArrayList<>();
        for (Hotel hotel : hoteis) {
            if (hotel.getReservaCliente() != null) {
                reservas.add(hotel);
            }
        }
        return reservas;
    }
}

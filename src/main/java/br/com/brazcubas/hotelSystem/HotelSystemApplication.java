package br.com.brazcubas.hotelSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.brazcubas.hotelSystem.model.entity.Hotel;

@SpringBootApplication
public class HotelSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelSystemApplication.class, args);
        
        // Criação de uma instância da classe HotelSystem
        HotelSystem hotelSystem = new HotelSystem();
        
        // Exemplo de como criar uma instância da classe Hotel e adicioná-la ao sistema
        Hotel hotel = new Hotel("Hotel Teste");
        hotelSystem.adicionarHotel(hotel);
        
        // Exemplo de como realizar uma reserva
        hotelSystem.realizarReserva(hotel, "Cliente Teste", "01/01/2025", "10/01/2025");
        
        // Exemplo de como listar os hotéis
        System.out.println("Hoteis cadastrados: ");
        for (Hotel h : hotelSystem.getHoteis()) {
            System.out.println(h.getNome());
        }
    }
}

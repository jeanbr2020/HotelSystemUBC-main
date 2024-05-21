package br.com.brazcubas.hotelSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.brazcubas.hotelSystem.model.entity.Hotel;

@SpringBootApplication
public class HotelSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelSystemApplication.class, args);
        
        // Exemplo de como criar uma instância da classe Hotel
        Hotel hotel = new Hotel("Hotel Teste", "Este é um hotel de teste.", 200.0);
        System.out.println("Nome do Hotel: " + hotel.getNome());
        System.out.println("Descrição do Hotel: " + hotel.getDescricao());
        System.out.println("Preço do Hotel: " + hotel.getPreco());
    }
}

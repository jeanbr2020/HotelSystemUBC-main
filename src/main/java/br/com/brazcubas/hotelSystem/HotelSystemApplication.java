package br.com.brazcubas.hotelSystem;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.brazcubas.hotelSystem.config.DatabaseConfig;
import br.com.brazcubas.hotelSystem.controller.HotelController;
import br.com.brazcubas.hotelSystem.view.HotelView;

@SpringBootApplication
public class HotelSystemApplication implements CommandLineRunner {

  @Autowired
  private HotelController hotelController;

  public static void main(String[] args) {
    SpringApplication.run(HotelSystemApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    DatabaseConfig.createTables();

    // Initialize dependencies
    HotelView hotelView = new HotelView();

    // Create an instance of HotelSystem
    Scanner scanner = new Scanner(System.in);
    HotelSystem sistema = new HotelSystem(hotelController, hotelView, scanner);
    // Start the system
    sistema.iniciar();
  }
}

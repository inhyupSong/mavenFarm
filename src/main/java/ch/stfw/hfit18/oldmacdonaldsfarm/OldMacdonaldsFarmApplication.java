package ch.stfw.hfit18.oldmacdonaldsfarm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OldMacdonaldsFarmApplication {

	public static void main(String[] args) {
		try {
			// ML: Diese Login brauchen wir, damit die Applikation bei Codeänderungen sauber
			// neu startet (Bug in Spring Boot Developer Tools).
			SpringApplication.run(OldMacdonaldsFarmApplication.class, args);
		} catch (Throwable e) {
			if (e.getClass().getName().contains("SilentExitException")) {
				System.out.println("Spring is restarting the main thread - See spring-boot-devtools");
			} else {
				System.err.println("Application crashed!");
			}
		}

	}
//
}
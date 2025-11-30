package talentoTech.Project;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		 
		Dotenv dotenv = Dotenv.configure()
        .directory("./")   // fuerza que lea desde el directorio raíz
        .ignoreIfMissing() // no da error si falta
        .load();

		File f = new File("./ .env");
		System.out.println("EXISTE .env? " + f.exists());


		// debug
		System.out.println("DOTENV URL -> " + dotenv.get("URL"));
		System.out.println("DOTENV USER -> " + dotenv.get("DB_USERNAME"));
		System.out.println("DOTENV PASS -> " + dotenv.get("DB_PASSWORD"));

		System.setProperty("URL", dotenv.get("URL", ""));
		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME", ""));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD", ""));


        SpringApplication.run(ProjectApplication.class, args);
	}

}

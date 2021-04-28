package task01;

import java.sql.Connection;
import java.sql.SQLException;

public class Application {

	public static void main(String[] args) {

		try (Connection openConnection = ConnectionUtils.openConnection()) {
			MagazineDao magazineDao = new MagazineDao(openConnection);
			magazineDao.readAll().forEach(System.out::println);
			System.out.println("\n");

			// INSERT
			magazineDao.insert(new Magazine("Forbes", "19170101", 1));
			magazineDao.readAll().forEach(System.out::println);
			System.out.println("\n");

			// READ BY ID
			Magazine magazineDB = magazineDao.read(1);
			System.out.println(magazineDB.toString());
			System.out.println("\n");

			// UPDATE
			Magazine magazineNew = new Magazine("Smartmoney", "19530101", 1);
			magazineDao.update(magazineNew, 1);
			magazineDao.readAll().forEach(System.out::println);
			System.out.println("\n");

			// DELETE
			magazineDao.delete(1);
			magazineDao.readAll().forEach(System.out::println);
			System.out.println("\n");

			GenreDao genreDao = new GenreDao(openConnection);
			genreDao.readAll().forEach(System.out::println);
			System.out.println("\n");

			// INSERT
			genreDao.insert(new Genre("Famous"));
			genreDao.readAll().forEach(System.out::println);
			System.out.println("\n");

			// READ BY ID
			Genre genreFromDB = genreDao.read(1);
			System.out.println(genreFromDB.toString());
			System.out.println("\n");

			// UPDATE
			Genre genreNew = new Genre("Business");
			genreDao.update(genreNew, 1);
			genreDao.readAll().forEach(System.out::println);
			System.out.println("\n");

			// DELETE
			genreDao.delete(1);
			genreDao.readAll().forEach(System.out::println);
			System.out.println("\n");

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
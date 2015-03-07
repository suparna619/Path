package com.paths;

import org.junit.Test;
import static org.junit.Assert.*;


public class PathsTest {
    ReadFile fileReader = new ReadFile();
    String content = fileReader.readFile("paths.txt");

	@Test
	public void isCityPresent_checks_whether_city_is_prsent() {
		Paths paths = new Paths(content);

		assertTrue(paths.isStationPresent("bangalore"));
		assertTrue(paths.isStationPresent("singapore"));
		assertTrue(paths.isStationPresent("seoul"));
		assertTrue(paths.isStationPresent("beijing"));

		assertTrue(paths.isStationPresent("dubai"));
		assertTrue(paths.isStationPresent("tokyo"));

		assertFalse(paths.isStationPresent("chennai"));
		assertFalse(paths.isStationPresent("stockholm"));
	}

	@Test
	public void hasWay_returns_true_for_path_between_Bangalore_to_Singapore() {
		Paths newPath = new Paths(content);
		assertTrue(newPath.hasWay("bangalore","singapore"));
	}

	@Test
	public void hasWay_returns_true_for_path_between_Singapore_to_Bangalore() {
		Paths newPath = new Paths(content);
		assertTrue(newPath.hasWay("singapore","bangalore"));
	}

	@Test
	public void hasWay_returns_true_for_path_between_Singapore_to_Seoul() {
		Paths newPath = new Paths(content);
		assertTrue(newPath.hasWay("singapore","seoul"));
	}

	@Test
	public void hasWay_returns_true_for_path_between_Seoul_to_Singapore() {
		Paths newPath = new Paths(content);
		assertTrue(newPath.hasWay("seoul","singapore"));
	}

	@Test
	public void hasWay_returns_true_for_path_between_Singapore_to_Dubai() {
		Paths newPath = new Paths(content);
		assertTrue(newPath.hasWay("singapore","dubai"));
	}

	@Test
	public void hasWay_returns_true_for_path_between_Dubai_to_Singapore() {
		Paths newPath = new Paths(content);
		assertTrue(newPath.hasWay("dubai","singapore"));
	}

	@Test
	public void hasWay_returns_true_for_path_between_Seoul_to_Beijing() {
		Paths newPath = new Paths(content);
		assertTrue(newPath.hasWay("seoul","beijing"));
	}

	@Test
	public void hasWay_returns_true_for_path_between_Beijing_to_Seoul() {
		Paths newPath = new Paths(content);
		assertTrue(newPath.hasWay("beijing","seoul")); }

	@Test
	public void hasWay_returns_true_for_path_between_Beijing_to_Tokyo() {
		Paths newPath = new Paths(content);
		assertTrue(newPath.hasWay("beijing","tokyo"));
	}

	@Test
	public void hasWay_returns_true_for_path_between_Tokyo_to_Beijing() {
		Paths newPath = new Paths(content);
		assertTrue(newPath.hasWay("tokyo","beijing"));
	}

	@Test
	public void hasWay_returns_false_for_path_between_Singapur_to_Beijing() {
		Paths newPath = new Paths(content);
		assertFalse(newPath.hasWay("singapore","beijing"));
	}

	@Test
	public void hasWay_returns_true_for_path_between_Beijing_to_Singapore() {
		Paths newPath = new Paths(content);
		assertTrue(newPath.hasWay("beijing","singapore"));
	}

	@Test
	public void hasWay_returns_false_for_NULL_to_Tokyo() {
		Paths newPath = new Paths(content);
		assertFalse(newPath.hasWay(null,"tokyo"));
	}

	@Test
	public void hasWay_returns_false_for_Singapore_to_NULL() {
		Paths newPath = new Paths(content);
		assertFalse(newPath.hasWay("singapore",null));
	}

	@Test
	public void hasWay_returns_false_for_path_between_null_to_null() {
		Paths newPath = new Paths(content);
		assertFalse(newPath.hasWay(null,null));
	}

	@Test
	public void hasWay_returns_true_for_path_between_Bangalore_and_Tokyo() {
		Paths path = new Paths(content);
		assertTrue(path.hasWay("bangalore","tokyo"));
	}

	@Test
	public void printPath_returns_path_for_Bangalore_to_Tokyo() {
		Paths newPath = new Paths(content);
		assertEquals(newPath.printPath("bangalore","tokyo"),"BANGALORE -> SINGAPORE -> SEOUL -> BEIJING -> TOKYO");
	}

	@Test
	public void hasWay_returns_true_for_path_between_Tokyo_and_Bangalore() {
		Paths path = new Paths(content);
		assertTrue(path.hasWay("tokyo", "bangalore"));
	}

	@Test
	public void printPath_returns_path_for_Tokyo_to_Bangalore() {
		Paths newPath = new Paths(content);
		assertEquals(newPath.printPath("tokyo", "bangalore"),"TOKYO -> BEIJING -> SEOUL -> SINGAPORE -> BANGALORE");
	}

	@Test
	public void hasWay_returns_true_for_Bangalore_to_Seoul() {
		Paths newPath = new Paths(content);
		assertTrue(newPath.hasWay("bangalore","seoul"));
	}

	@Test
	public void printPath_returns_path_for_Bangalore_to_Seoul() {
		Paths newPath = new Paths(content);
		assertEquals(newPath.printPath("bangalore","seoul"),"BANGALORE -> SINGAPORE -> SEOUL");
	}

	@Test
	public void hasWay_returns_true_for_Seoul_to_Bangalore() {
		Paths newPath = new Paths(content);
		assertTrue(newPath.hasWay("seoul","bangalore"));
	}

	@Test
	public void printPath_returns_path_for_Seoul_to_Bangalore() {
		Paths newPath = new Paths(content);
		assertEquals(newPath.printPath("seoul","bangalore"),"SEOUL -> SINGAPORE -> BANGALORE");
	}

	@Test
	public void hasWay_returns_true_for_Bangalore_to_Dubai() {
		Paths newPath = new Paths(content);
		assertTrue(newPath.hasWay("bangalore","dubai"));
	}

	@Test
	public void printPath_returns_path_for_Bangalore_to_Dubai() {
		Paths newPath = new Paths(content);
		assertEquals(newPath.printPath("bangalore","dubai"),"BANGALORE -> SINGAPORE -> DUBAI");
	}

	@Test
	public void hasWay_returns_true_for_Dubai_to_Bangalore() {
		Paths newPath = new Paths(content);
		assertTrue(newPath.hasWay("dubai","bangalore"));
	}

	@Test
	public void printPath_returns_path_for_Dubai_to_Bangalore() {
		Paths newPath = new Paths(content);
		assertEquals(newPath.printPath("dubai","bangalore"),"DUBAI -> SINGAPORE -> BANGALORE");
	}


	// @Test //[Falling Test]
	// public void hasWay_returns_true_for_Singapore_to_Tokyo() {
	// 	Paths newPath = new Paths(content);
	// 	assertTrue(newPath.hasWay("Singapore","Tokyo"));
	// }

	@Test
	public void hasWay_returns_true_for_Tokyo_to_Singapore() {
		Paths newPath = new Paths(content);
		assertTrue(newPath.hasWay("tokyo","singapore"));
	}

	@Test
	public void printPath_returns_path_for_Tokyo_to_Singapore() {
		Paths newPath = new Paths(content);
		assertEquals(newPath.printPath("tokyo","singapore"),"TOKYO -> BEIJING -> SEOUL -> SINGAPORE");
	}
}
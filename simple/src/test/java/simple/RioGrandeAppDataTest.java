package simple;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RioGrandeAppDataTest {

	private static final double EPSILON = 0.01;

	@Test
	void testGameStartsFarBackInTime() {
		RioGrandeAppData data = new RioGrandeAppData();
		int expected = -4_000_000;
		int actual = data.getDate();
		assertEquals(expected, actual);	
	}

	@Test
	void testGameStartsOnFirstTurn() {
		RioGrandeAppData data = new RioGrandeAppData();
		int expected = 1;
		int actual = data.getTurn();
		assertEquals(expected, actual);	
	}	
	
	@Test
	void testGameStartsWithVeryFewPeople() {
		RioGrandeAppData data = new RioGrandeAppData();
		float expected = 8.0f;
		float actual = data.getPopulation();
		assertEquals(expected, actual, EPSILON);	
	}	

	@Test
	void testGameStartsWithVeryLowPopulationMinimum() {
		RioGrandeAppData data = new RioGrandeAppData();
		int expected = 12;
		int actual = data.getPopulationMax();
		assertEquals(expected, actual);	
	}	

	@Test
	void testGameStartsWithLowPopulationIncrease() {
		RioGrandeAppData data = new RioGrandeAppData();
		float expected = -0.4f;
		float actual = data.getPopulationDelta();
		assertEquals(expected, actual, 0.01);	
	}	
	
	@Test
	void testGameStartsWithVeryLowFood() {
		RioGrandeAppData data = new RioGrandeAppData();
		float expected = -8.0f;
		float actual = data.getFood();
		assertEquals(expected, actual, 0.01);	
	}

	@Test
	void testGameStartsWithNoWorkProduction() {
		RioGrandeAppData data = new RioGrandeAppData();
		float expected = 0.0f;
		float actual = data.getWork();
		assertEquals(expected, actual, 0.01);	
	}	

	@Test
	void testGameStartsWithNoWorkCulture() {
		RioGrandeAppData data = new RioGrandeAppData();
		float expected = 0.0f;
		float actual = data.getCulture();
		assertEquals(expected, actual, 0.01);	
	}	
	
	@Test
	void testGameStartsWithNoThreat() {
		RioGrandeAppData data = new RioGrandeAppData();
		float expected = 0.0f;
		float actual = data.getThreat();
		assertEquals(expected, actual, 0.01);	
	}		
}

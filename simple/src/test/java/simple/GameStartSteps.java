package simple;

import static org.junit.jupiter.api.Assertions.*;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

class GameStartSteps {

	private static final double EPSILON = 0.01;
	private RioGrandeAppData data;

	@Given("a new game")
	private void before() {
		data = new RioGrandeAppData();
	}

	@Then("current population is 8 humans")
	void testGameStartsWithVeryFewPeople() {
		float expected = 8.0f;
		float actual = data.getCurrentPopulation();
		assertEquals(expected, actual, EPSILON);
	}

	@Then("maximum population is 12 humans")
	void testGameStartsWithVeryLowPopulationMinimum() {
		int expected = 12;
		int actual = data.getMaximumPopulation();
		assertEquals(expected, actual);
	}

	@Then("population growth rate per turn is -0.4")
	void testGameStartsWithLowPopulationIncrease() {
		RioGrandeAppData data = new RioGrandeAppData();
		float expected = -0.4f;
		float actual = data.getPopulationDelta();
		assertEquals(expected, actual, 0.01);
	}

}

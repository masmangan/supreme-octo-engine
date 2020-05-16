package simple.stories;

import static org.junit.jupiter.api.Assertions.*;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.steps.Steps;

import simple.RioGrandeAppData;

public class GameStartSteps extends Steps {

	public static final double EPSILON = 0.01;
	public RioGrandeAppData data;

	@Given("a new game")
	public void before() {
		data = new RioGrandeAppData();
	}

	@Then("current population is $population humans")
	public void testGameStartsWithVeryFewPeople(float population) {
		float expected = population;
		float actual = data.getCurrentPopulation();
		assertEquals(expected, actual, EPSILON);
	}

	@Then("maximum population is $population humans")
	public void testGameStartsWithVeryLowPopulationMinimum(int population) {
		int expected = population;
		int actual = data.getMaximumPopulation();
		assertEquals(expected, actual);
	}

	@Then("population growth rate per turn is $rate")
	public void testGameStartsWithLowPopulationIncrease(float rate) {
		RioGrandeAppData data = new RioGrandeAppData();
		float expected = rate;
		float actual = data.getPopulationDelta();
		assertEquals(expected, actual, 0.01);
	}

}

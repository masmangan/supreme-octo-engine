package simple.steps;

import static org.junit.jupiter.api.Assertions.*;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
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
		float expected = rate;
		float actual = data.getPopulationDelta();
		assertEquals(expected, actual, 0.01);
	}

	@Then("every 20 food units adds 1 human")
	@Pending
	public void thenEvery20FoodUnitsAdds1Human() {
	  // PENDING
	}

	@Then("food growth per turn is -8 units")
	@Pending
	public void thenFoodGrowthPerTurnIs8Units() {
	  // PENDING
	}

	@Then("food consumed per turn is 8 units")
	@Pending
	public void thenFoodConsumedPerTurnIs8Units() {
	  // PENDING
	}

	@Then("food from forests per worker is 2.4 units")
	@Pending
	public void thenFoodFromForestsPerWorkerIs24Units() {
	  // PENDING
	}

	@Then("food from savanna per worker is 0 units")
	@Pending
	public void thenFoodFromSavannaPerWorkerIs0Units() {
	  // PENDING
	}

	@Then("food from rivers per fisherman is 0 units")
	@Pending
	public void thenFoodFromRiversPerFishermanIs0Units() {
	  // PENDING
	}

	@Then("food from fields per farmer is 0 units")
	@Pending
	public void thenFoodFromFieldsPerFarmerIs0Units() {
	  // PENDING
	}	
	
	
	@Then("current turn is 1")
	public void thenCurrentTurnIs1() {
		int expected = 1;
		int actual = data.getTurn();
		assertEquals(expected, actual);
	}

	@Then("date is -4000000")
	public void thenDateIs4000000() {
		int expected = -4000000;
		int actual = data.getDate();
		assertEquals(expected, actual);
	}

	@Then("age is Antiquity")
	public void thenAgeIsAntiquity() {
		String expected = "Antiquity";
		String actual = data.getAge();
		assertEquals(expected, actual);
	}

	@Then("strength level is 8")
	public void thenStrengthLevelIs8() {
		int expected = 8;
		int actual = data.getStrengthLevel();
		assertEquals(expected, actual);
	}

	@Then("chance of invasion is 0 %")
	public void thenChanceOfInvasionIs0() {
		float expected = 0f;
		float actual = data.getThreat();
		assertEquals(expected, actual, 0.01);
	}

	@Then("strength bonus is 0 %")
	public void thenStrengthBonusIs0() {
		float expected = 0f;
		float actual = data.getStrengthBonus();
		assertEquals(expected, actual, 0.01);
	}
	
	@Then("production growth per turn is 1.6")
	@Pending
	public void thenProductionGrowthPerTurnIs16() {
	  // PENDING
	}

	@Then("production total points is 0")
	@Pending
	public void thenProductionTotalPointsIs0() {
	  // PENDING
	}

	@Then("passive production points per turn is 1.6")
	@Pending
	public void thenPassiveProductionPointsPerTurnIs16() {
	  // PENDING
	}

	@Then("production from mountains per turn is 0")
	@Pending
	public void thenProductionFromMountainsPerTurnIs0() {
	  // PENDING
	}

	@Then("culture growth per turn is 1.6")
	@Pending
	public void thenCultureGrowthPerTurnIs16() {
	  // PENDING
	}

	@Then("total culture is 0")
	@Pending
	public void thenTotalCultureIs0() {
	  // PENDING
	}

	@Then("culture needed for next level is 5")
	@Pending
	public void thenCultureNeededForNextLevelIs5() {
	  // PENDING
	}

	@Then("technology level is 1")
	@Pending
	public void thenTechnologyLevelIs1() {
	  // PENDING
	}

	@Then("passive culture per turn is 1.6")
	@Pending
	public void thenPassiveCulturePerTurnIs16() {
	  // PENDING
	}

	@Then("culture from worshipping per turn is 0")
	@Pending
	public void thenCultureFromWorshippingPerTurnIs0() {
	  // PENDING
	}
	
}

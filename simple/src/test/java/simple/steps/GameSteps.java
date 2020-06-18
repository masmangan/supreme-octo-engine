package simple.steps;

import static org.junit.jupiter.api.Assertions.*;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import simple.GameData;

/**
 * 
 * @author marco.mangan@gmail.com
 *
 */
public class GameSteps extends Steps {

	public static final double EPSILON = 0.1;
	public GameData data;

	@Given("a new game")
	public void before() {
		data = new GameData();
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

	@Then("population growth rate per turn is $rate humans/turn")
	public void testGameStartsWithLowPopulationIncrease(float rate) {
		float expected = rate;
		float actual = data.getPopulationDelta();
		assertEquals(expected, actual, EPSILON);
	}

	@Then("every 20 food units adds 1 human")
	public void thenEvery20FoodUnitsAdds1Human() {
		float expected = 20;
		float actual = data.getFoodPerNewHuman();
		assertEquals(expected, actual, EPSILON);
	}

	@Then("food growth per turn is -8 food units/turn")
	public void thenFoodGrowthPerTurnIs8Units() {
		float expected = -8.0f;
		float actual = data.getFoodGrowthPerTurn();
		assertEquals(expected, actual, EPSILON);
	}

	@Then("food consumed per turn is 8 food units/turn")
	public void thenFoodConsumedPerTurnIs8Units() {
		float expected = 8.0f;
		float actual = data.getFoodConsumedPerTurn();
		assertEquals(expected, actual, EPSILON);
	}

	@Then("food from forests per worker is 2.4 food units/gatherer")
	@Pending
	public void thenFoodFromForestsPerWorkerIs24Units() {
		// PENDING
	}

	@Then("food from savanna per worker is 0 food units/hunter")
	@Pending
	public void thenFoodFromSavannaPerWorkerIs0Units() {
		// PENDING
	}

	@Then("food from rivers per fisherman is 0 food units/fisherman")
	@Pending
	public void thenFoodFromRiversPerFishermanIs0Units() {
		// PENDING
	}

	@Then("food from fields per farmer is 0 food units/farmer")
	@Pending
	public void thenFoodFromFieldsPerFarmerIs0Units() {
		// PENDING
	}

	@Then("production growth per turn is 1.6 production units/turn")
	@Pending
	public void thenProductionGrowthPerTurnIs16() {
		// PENDING
	}

	@Then("production total points is 0")
	public void thenProductionTotalPointsIs0() {
		float expected = 0.0f;
		float actual = data.getWork();
		assertEquals(expected, actual, EPSILON);
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
	public void thenTotalCultureIs0() {
		float expected = 0.0f;
		float actual = data.getCulture();
		assertEquals(expected, actual, EPSILON);
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
		assertEquals(expected, actual, EPSILON);
	}

	@Then("strength bonus is 0 %")
	public void thenStrengthBonusIs0() {
		float expected = 0f;
		float actual = data.getStrengthBonus();
		assertEquals(expected, actual, EPSILON);
	}

	@Given("$n humans are allocated to forest food gathering")
	public void whenOneHumanIsAllocatedFromFoodGathering(int n) {
		data.setForestWorkers(data.getForestWorkers() + n);
	}

	@When("end turn")
	public void whenEndTurn() {
		data.tick();
	}

}

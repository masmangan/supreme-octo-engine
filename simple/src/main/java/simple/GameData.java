/*
 * Copyright (c) 2020. All rights reserved.
 */

package simple;

//import java.util.logging.Logger;

/**
 * The <code>GameData</code> class
 * 
 * @author marco.mangan@gmail.com
 *
 */
public final class GameData {
	/** */
	// private static final Logger LOGGER =
	// Logger.getLogger(GameData.class.getName());

	private DateParameter dateParameters;

	private PopulationParameters populationParameters;

	/** */
	private float work;

	/** */
	private float workRate;

	/** */
	private float food;

	/** */
	private float culture;

	/** */
	private float cultureRate;

	/** */
	private float threat;

	/** */
	private int forestWorkers;

	/** */
	private int forestWorkersMax;

	/** */
	private boolean endGame;

	/** */
	private int defense;

	/**
	 * 
	 * @return
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * 
	 * @param defense
	 */
	private void setDefense(int defense) {
		this.defense = defense;
	}

	/**
	 * @return
	 */
	public int getForestWorkersMax() {
		return forestWorkersMax;
	}

	/**
	 * @param forestWorkersMax
	 */
	private void setForestWorkersMax(int forestWorkersMax) {
		this.forestWorkersMax = forestWorkersMax;
	}

	/**
	 * @return
	 */
	public int getForestWorkers() {
		return forestWorkers;
	}

	/**
	 * @param forestWorkers
	 */
	public void setForestWorkers(int forestWorkers) {
		this.forestWorkers = Math.min(forestWorkers, forestWorkersMax);
	}

	/**
	 * 
	 */
	public GameData() {
		dateParameters = new DateParameter();
		populationParameters = new PopulationParameters();		


		setDefense(8);

		setFood(-8.0f);

		setWork(0.0f);
		setWorkRate(+1.6f);
		setCulture(0.0f);
		setCultureRate(1.6f);
		setThreat(0.0f);

		setForestWorkersMax(10);
	}

	/**
	 * @return
	 */
	public int getTurn() {
		return dateParameters.getTurn();
	}

	/**
	 * @return
	 */
	public int getDate() {
		return dateParameters.getDate();
	}

	/**
	 * 
	 * @return
	 */
	public String getAge() {
		return dateParameters.getAge();
	}

	/**
	 * @return
	 */
	public float getCurrentPopulation() {
		return populationParameters.getPopulation();
	}

	/**
	 * @param population
	 */
	public void setCurrentPopulation(float population) {
		this.populationParameters.setPopulation(population);
	}

	/**
	 * @return
	 */
	public int getMaximumPopulation() {
		return populationParameters.getPopulationMax();
	}

	/**
	 * @param populationMax
	 */
	public void setMaximumPopulation(int populationMax) {
		this.populationParameters.setPopulationMax(populationMax);
	}

	/**
	 * @return
	 */
	public float getPopulationGrowthRatePerTurn() {
		return populationParameters.getPopulationRate();
	}

	/**
	 * @param populationRate
	 */
	public void setPopulationGrowthRatePerTurn(float populationRate) {
		this.populationParameters.setPopulationRate(populationRate);
	}

	/**
	 * @return
	 */
	public float getWork() {
		return work;
	}

	/**
	 * @param work
	 */
	public void setWork(float work) {
		this.work = work;
	}

	/**
	 * @return
	 */
	public float getWorkRate() {
		return workRate;
	}

	/**
	 * @param workRate
	 */
	public void setWorkRate(float workRate) {
		this.workRate = workRate;
	}

	/**
	 * @return
	 */
	public float getFood() {
		return food;
	}

	/**
	 * @param food
	 */
	public void setFood(float food) {
		this.food = food;
	}

	/**
	 * @return
	 */
	public float getCulture() {
		return culture;
	}

	/**
	 * @param culture
	 */
	public void setCulture(float culture) {
		this.culture = culture;
	}

	/**
	 * @return
	 */
	public float getCultureRate() {
		return cultureRate;
	}

	/**
	 * @param cultureRate
	 */
	public void setCultureRate(float cultureRate) {
		this.cultureRate = cultureRate;
	}

	/**
	 * @return
	 */
	public float getThreat() {
		return threat;
	}

	/**
	 * @param threat
	 */
	public void setThreat(float threat) {
		this.threat = threat;
	}

	/**
	 * Updates game data for current turn.
	 * 
	 */
	public void tick() {
		if (endGame) {
			return;
		}

		dateParameters.incrementTurn();
		dateParameters.incrementDate();

		float foodConsumed = getCurrentPopulation();
		float foodFromForestModifier = 2.4f;
		float foodFromForest = foodFromForestModifier * getForestWorkers();

		float foodTotal = foodFromForest - foodConsumed;

		float populationDelta = (float) (foodTotal / 20.0);

//		System.out.println("A) POPULATION\n");
//		System.out.println("Employed tribesmen produce valuable resources. ");
//
//		System.out.println("- Current Population: " + populationParameters.getPopulation());
//		System.out.println("- Maximum Population: " + populationParameters.getPopulationMax());
//		System.out.println("- Pop. growth rate/turn: " + populationDelta);
//
//		System.out.println("\nB) FOOD\n");
//		System.out.println("Food - population growth. Every 20 food add 1 human. ");
//
//		System.out.println("- Food growth/turn: " + foodTotal);
//		System.out.println("- Food consumed per turn: " + foodConsumed);
//		System.out.println("- Food from forests/worker: " + foodFromForestModifier);
		int foodFromSavannatModifier = 0;
//		System.out.println("- Food from savanna/worker: " + foodFromSavannatModifier);
		int foodFromRiversModifier = 0;
//		System.out.println("- Food from rivers/fisherman: " + foodFromRiversModifier);
		int foodFromFieldsModifier = 0;
//		System.out.println("- Food from fields/farmer: " + foodFromFieldsModifier);

		float newPopulation = populationParameters.getPopulation();
		newPopulation += populationDelta;
		if (newPopulation > populationParameters.getPopulationMax()) {
			newPopulation = populationParameters.getPopulationMax();
		}
		if (newPopulation < 0.1f) {
			newPopulation = 0.0f;
		}
		populationParameters.setPopulation(newPopulation);
		defense += (newPopulation - populationParameters.getPopulation()); //
		populationParameters.setPopulation(newPopulation);

		if (populationParameters.getPopulation() == 0.0) {
			endGame = true;
		}

		food = foodTotal;

//		System.out.println("\nC) PRODUCTION\n");
//		System.out.println("Production affects the evolution of your tribe and the construction of buildings.");

		int productionGrowth = 0;
//		System.out.println("- Production growth/turn: " + productionGrowth);
		int productionTotal = 0;
//		System.out.println("- Total production points: " + productionTotal);
		int productionPassiveGrowth = 0;
//		System.out.println("- Passive prod. points/turn: " + productionPassiveGrowth);
		int productionFromMountains = 0;
//		System.out.println("- Production from mountains per turn: " + productionFromMountains);

//		System.out.println("\nD) CULTURE\n");
//		System.out.println("Culture unlocks technologies.");
//
//		System.out.println("\nE) STRENGTH\n");
//		System.out.println("Strength provides protection from uninvited guests.");
//
//		System.out.println("\nF) TURNS\n");
//		System.out.println("Turns reflect the current year and effect the development of humanity.");
//
//		System.out.println("- Current turn: " + getTurn());
//		System.out.println("- " + dateParameters.getAge() + ": " + getDate() / 1000 + " years B.C.");

	}

	/**
	 * @return
	 */
	public float getPopulationDelta() {
		// TODO: remove duplicate code...
		float foodConsumed = getCurrentPopulation();
		float foodFromForestModifier = 2.4f;
		float foodFromForest = foodFromForestModifier * getForestWorkers();

		float foodTotal = foodFromForest - foodConsumed;

		float populationDelta = (float) (foodTotal / getFoodPerNewHuman());
		return populationDelta;
	}

	/**
	 * 
	 * @return
	 */
	public int getStrengthLevel() {
		return defense;
	}

	/**
	 * 
	 * @return
	 */
	public float getStrengthBonus() {
		// TODO complete strength bonus
		return 0;
	}

	/**
	 * 
	 * @return
	 */
	public float getFoodPerNewHuman() {
		return 20.0f;
	}

	/**
	 * 
	 * @return
	 */
	public float getFoodGrowthPerTurn() {
		float foodConsumed = getCurrentPopulation();
		float foodFromForestModifier = 2.4f;
		float foodFromForest = foodFromForestModifier * getForestWorkers();

		return foodFromForest - foodConsumed;
	}

	public float getFoodConsumedPerTurn() {
		return getCurrentPopulation();
	}

}
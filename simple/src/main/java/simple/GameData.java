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

	/** */
	private int turn;

	/** */
	private int date;

	/** */
	private int dateRate;

	/** */
	private float population;

	/** */
	private int populationMax;

	/** */
	private float populationRate;

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
	void setForestWorkers(int forestWorkers) {
		this.forestWorkers = Math.min(forestWorkers, forestWorkersMax);
	}

	/**
	 * 
	 */
	public GameData() {
		setTurn(1);

		setDate(-4000 * 1000);
		setDateRate(200 * 1000);

		setCurrentPopulation(8.0f);
		setDefense(8);
		setMaximumPopulation(12);
		setPopulationGrowthRatePerTurn(-0.4f);

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
		return turn;
	}

	/**
	 * @param turn
	 */
	public void setTurn(int turn) {
		this.turn = turn;
	}

	/**
	 * @return
	 */
	public int getDate() {
		return date;
	}

	/**
	 * @param date
	 */
	public void setDate(int date) {
		this.date = date;
	}

	/**
	 * @return
	 */
	public float getCurrentPopulation() {
		return population;
	}

	/**
	 * @param population
	 */
	public void setCurrentPopulation(float population) {
		this.population = population;
	}

	/**
	 * @return
	 */
	public int getMaximumPopulation() {
		return populationMax;
	}

	/**
	 * @param populationMax
	 */
	public void setMaximumPopulation(int populationMax) {
		this.populationMax = populationMax;
	}

	/**
	 * @return
	 */
	public float getPopulationGrowthRatePerTurn() {
		return populationRate;
	}

	/**
	 * @param populationRate
	 */
	public void setPopulationGrowthRatePerTurn(float populationRate) {
		this.populationRate = populationRate;
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

		turn++;
		date += dateRate;

		if (date == -2600 * 1000) {
			dateRate = 100 * 1000;
		} else if (date == -800 * 1000) {
			dateRate = 50 * 1000;
		} else if (date == -450 * 1000) {
			dateRate = 20 * 1000;
		} else if (date == -210 * 1000) {
			dateRate = 10 * 1000;
		} else if (date == -50 * 1000) {
			dateRate = 2 * 1000;
		} else if (date == -36 * 1000) {
			dateRate = 1 * 1000;
		} else if (date == -4 * 1000) {
			dateRate = 1;
		}

		float foodConsumed = getCurrentPopulation();
		float foodFromForestModifier = 2.4f;
		float foodFromForest = foodFromForestModifier * getForestWorkers();

		float foodTotal = foodFromForest - foodConsumed;

		float populationDelta = (float) (foodTotal / 20.0);

		System.out.println("A) POPULATION\n");
		System.out.println("Employed tribesmen produce valuable resources. ");

		System.out.println("- Current Population: " + population);
		System.out.println("- Maximum Population: " + populationMax);
		System.out.println("- Pop. growth rate/turn: " + populationDelta);

		System.out.println("\nB) FOOD\n");
		System.out.println("Food - population growth. Every 20 food add 1 human. ");

		System.out.println("- Food growth/turn: " + foodTotal);
		System.out.println("- Food consumed per turn: " + foodConsumed);
		System.out.println("- Food from forests/worker: " + foodFromForestModifier);
		int foodFromSavannatModifier = 0;
		System.out.println("- Food from savanna/worker: " + foodFromSavannatModifier);
		int foodFromRiversModifier = 0;
		System.out.println("- Food from rivers/fisherman: " + foodFromRiversModifier);
		int foodFromFieldsModifier = 0;
		System.out.println("- Food from fields/farmer: " + foodFromFieldsModifier);

		float newPopulation = population;
		newPopulation += populationDelta;
		if (newPopulation > populationMax) {
			newPopulation = populationMax;
		}
		if (newPopulation < 0.1f) {
			newPopulation = 0.0f;
		}
		population = newPopulation;
		defense += (newPopulation - population); //
		population = newPopulation;

		if (population == 0.0) {
			endGame = true;
		}

		food = foodTotal;

		System.out.println("\nC) PRODUCTION\n");
		System.out.println("Production affects the evolution of your tribe and the construction of buildings.");
		
		int productionGrowth=0;
		System.out.println("- Production growth/turn: " + productionGrowth);
		int productionTotal=0;
		System.out.println("- Total production points: " + productionTotal);
		int productionPassiveGrowth=0;
		System.out.println("- Passive prod. points/turn: " + productionPassiveGrowth);
		int productionFromMountains=0;
		System.out.println("- Production from mountains per turn: " + productionFromMountains);
		
		System.out.println("\nD) CULTURE\n");
		System.out.println("Culture unlocks technologies.");
		
		System.out.println("\nE) STRENGTH\n");
		System.out.println("Strength provides protection from uninvited guests.");
		
		System.out.println("\nF) TURNS\n");
		System.out.println("Turns reflect the current year and effect the development of humanity.");
		
		System.out.println("- Current turn: " + getTurn());
		System.out.println("- " + getAge() + ": " + getDate() / 1000 + " years B.C.");



	}

	/**
	 * @return
	 */
//	public int getDateRate() {
//		return dateRate;
//	}

	/**
	 * Change date delta between ticks.
	 * 
	 * @param dateRate
	 */
	public void setDateRate(int dateRate) {
		this.dateRate = dateRate;
	}

	/**
	 * @return
	 */
	public float getPopulationDelta() {
		// TODO: duplicate code...
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
	public String getAge() {
		// TODO complete age
		return "Antiquity";
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
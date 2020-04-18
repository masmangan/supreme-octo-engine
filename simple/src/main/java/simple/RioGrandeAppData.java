package simple;

public class RioGrandeAppData {
	private int turn;
	private int date;
	private int dateRate;
	private float population;
	private int populationMax;
	private float populationRate;
	private float work;
	private float workRate;
	private float food;
	private float culture;
	private float cultureRate;
	private float threat;

	public RioGrandeAppData() {
		setTurn(1);

		setDate(-4000 * 1000);
		setDateRate(200  * 1000);

		setPopulation(8.0f);
		setPopulationMax(12);
		setPopulationRate(-0.4f);

		setFood(-8.0f);

		setWork(0.0f);
		setWorkRate(+1.6f);
		setCulture(0.0f);
		setCultureRate(1.6f);
		setThreat(0.0f);
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public float getPopulation() {
		return population;
	}

	public void setPopulation(float population) {
		this.population = population;
	}

	public int getPopulationMax() {
		return populationMax;
	}

	public void setPopulationMax(int populationMax) {
		this.populationMax = populationMax;
	}

	public float getPopulationRate() {
		return populationRate;
	}

	public void setPopulationRate(float populationRate) {
		this.populationRate = populationRate;
	}

	public float getWork() {
		return work;
	}

	public void setWork(float work) {
		this.work = work;
	}

	public float getWorkRate() {
		return workRate;
	}

	public void setWorkRate(float workRate) {
		this.workRate = workRate;
	}

	public float getFood() {
		return food;
	}

	public void setFood(float food) {
		this.food = food;
	}

	public float getCulture() {
		return culture;
	}

	public void setCulture(float culture) {
		this.culture = culture;
	}

	public float getCultureRate() {
		return cultureRate;
	}

	public void setCultureRate(float cultureRate) {
		this.cultureRate = cultureRate;
	}

	public float getThreat() {
		return threat;
	}

	public void setThreat(float threat) {
		this.threat = threat;
	}

	public void tick() {
		turn++;
		date += dateRate;
		// FIXME: rate decreases over time: 100, 50
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

	}

	public int getDateRate() {
		return dateRate;
	}

	public void setDateRate(int dateRate) {
		this.dateRate = dateRate;
	}
}
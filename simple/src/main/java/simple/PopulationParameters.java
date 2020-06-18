package simple;

public class PopulationParameters {
	/** */
	private float population;
	/** */
	private int populationMax;
	/** */
	private float populationRate;

	public PopulationParameters() {
		setPopulation(8.0f);
		setPopulationMax(12);
		setPopulationRate(-0.4f);		
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
}
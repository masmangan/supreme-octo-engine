package simple;

/**
 * The <code>DateParameter</code> class
 * 
 * @author marco.mangan@gmail.com
 *
 */
public class DateParameter {
	/** Sequence starting in 1 with increment of 1. */
	private int turn;
	/**
	 * Year starting in 4.000.000 BC, with decreasing decrements towards end game
	 */
	private int date;
	/** Initial value starting with 200.000 and decreasing towards end game */
	private int dateRate;

	/**
	 * Starting game in turn 1, date 4.000.000 BC, and initial rate of 200.000
	 */
	public DateParameter() {
		setTurn(1);

		setDate(-4000 * 1000);
		setDateRate(200 * 1000);
	}

	/**
	 * 
	 * @return
	 */
	public int getTurn() {
		return turn;
	}

	/** */
	private void setTurn(int turn) {
		this.turn = turn;
	}

	/**
	 * 
	 * @return
	 */
	public int getDate() {
		return date;
	}

	/**
	 * 
	 * @param date
	 */
	private void setDate(int date) {
		this.date = date;
		if (getDate() == -2600 * 1000) {
			setDateRate(100 * 1000);
		} else if (getDate() == -800 * 1000) {
			setDateRate(50 * 1000);
		} else if (getDate() == -450 * 1000) {
			setDateRate(20 * 1000);
		} else if (getDate() == -210 * 1000) {
			setDateRate(10 * 1000);
		} else if (getDate() == -50 * 1000) {
			setDateRate(2 * 1000);
		} else if (getDate() == -36 * 1000) {
			setDateRate(1 * 1000);
		} else if (getDate() == -4 * 1000) {
			setDateRate(1);
		}
	}

	/**
	 * 
	 * @return
	 */
	public int getDateRate() {
		return dateRate;
	}

	/**
	 * 
	 * @param dateRate
	 */
	public void setDateRate(int dateRate) {
		this.dateRate = dateRate;
	}

	/**
	 * 
	 */
	public void incrementTurn() {
		turn++;
	}

	/**
	 * 
	 */
	public void incrementDate() {
		this.date += dateRate;
		if (getDate() == -2600 * 1000) {
			setDateRate(100 * 1000);
		} else if (getDate() == -800 * 1000) {
			setDateRate(50 * 1000);
		} else if (getDate() == -450 * 1000) {
			setDateRate(20 * 1000);
		} else if (getDate() == -210 * 1000) {
			setDateRate(10 * 1000);
		} else if (getDate() == -50 * 1000) {
			setDateRate(2 * 1000);
		} else if (getDate() == -36 * 1000) {
			setDateRate(1 * 1000);
		} else if (getDate() == -4 * 1000) {
			setDateRate(1);
		}

	}

	/**
	 * 
	 * @return
	 */
	public String getAge() {
		// TODO complete age
		return "Antiquity";
	}
}
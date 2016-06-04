package nl.ru.ai.nakkerts.week4;

public class Record {
	private long startTime;
	private long passedTime;// tijd sinds vorige activiteit
	private String activity;

	public Record(long start, long passed, String activity) {
		this.startTime = start;
		this.passedTime = passed;
		this.activity = activity;

	}

	public String getStartTime() {
		return Long.toString(startTime);
	}

	public String getPassedTime() {
		return Long.toString(passedTime);
	}

	public String getActivity() {
		return activity;
	}
}

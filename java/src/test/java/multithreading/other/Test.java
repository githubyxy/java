package multithreading.other;

import java.text.SimpleDateFormat;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String[] dateStringArray = new String[] { "2000-01-01", "2000-01-02",
				"2000-01-03", "2000-01-04", "2000-01-05", "2000-01-06",
				"2000-01-07", "2000-01-08", "2000-01-09", "2000-01-10" };

		MyThread[] threadArray = new MyThread[10];
		for (int i = 0; i < 10; i++) {
//			sdf = new SimpleDateFormat("yyyy-MM-dd");
			threadArray[i] = new MyThread(sdf, dateStringArray[i]);
		}
		for (int i = 0; i < 10; i++) {
			Thread.sleep(1000);
			threadArray[i].start();
		}

	}
}

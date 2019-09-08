package thread;

public class JoinExample {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("thread main execution start");
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("thread1 execution start");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					System.out.println("thread1 execution finished");
				}
			}

		});
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("thread2 execution start");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					System.out.println("thread2 execution finished");
				}
			}

		});
		thread1.start();
		thread1.join();
		thread2.start();
//		thread2.join();
		System.out.println("thread main execution finished");
	}

}

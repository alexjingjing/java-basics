package thread;

public class WaitNotifyExample {
	
	private static Object object = new Object();
	private static boolean isSignaled = false;
	
	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("thread1 try to get lock");
				synchronized (object) {
					System.out.println("thread1 get lock success");
					try {
						Thread.sleep(1000);
						System.out.println("thread1 wait and release lock");
						while (!isSignaled) {
							object.wait();
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						System.out.println("thread1 execution finished");
					}
				}
			}
		});
		thread1.start();
		Thread.sleep(600);
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("thread2 try to get lock");
				synchronized (object) {
					System.out.println("thread2 get lock success");
					try {
						Thread.sleep(1000);
						System.out.println("thread2 wait and release lock");
						while (!isSignaled) {
							object.wait();
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						System.out.println("thread2 execution finished");
					}
				}
			}
		});
		thread2.start();
		Thread thread3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("thread3 try to get lock");
				synchronized (object) {
					System.out.println("thread3 get lock success");
					try {
						Thread.sleep(1000);
						System.out.println("thread3 wait and release lock");
						while (!isSignaled) {
							object.wait();
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						System.out.println("thread3 execution finished");
					}
				}
			}
		});
		thread3.start();
		synchronized (object) {
			isSignaled = true;
			object.notifyAll();
		}
	};

}

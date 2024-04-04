package Java_Practice;

class MyRunnable implements Runnable {

	private String name;

	MyRunnable(String name) {

		this.name = name;
	}

	@Override
	public void run() {

		System.out.println("Thread Started :" + name);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Thread End :" + name);

	}

}

class MyThread implements Runnable {

	private String name;

	MyThread(String name) {

		this.name = name;
	}

	@Override
	public void run() {

		System.out.println("Thread Started :" + name);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Thread End :" + name);

	}

}
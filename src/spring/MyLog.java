package spring;

public class MyLog implements Log {
	
	@Override
	public void log() {
		System.out.println("MyLog.log()");
	}

}

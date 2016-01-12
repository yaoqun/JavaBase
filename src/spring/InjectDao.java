package spring;

public class InjectDao implements IDao {
	
	@Override
	public void save(String msg) {
		System.out.println("InjectDao.save(), " + msg);
	}

}
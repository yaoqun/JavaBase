package spring;

public class Inject {
	
	private IDao dao;
	
	public void setDao(IDao dao) {
		this.dao = dao;
	}
	
	public void save(String msg) {
		dao.save(msg);
	}

}
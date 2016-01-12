package spring;

public class Inject {
	
	private IDao dao;
	
	public Inject() {
	}
	
	public Inject(IDao dao) {
		this.dao = dao;
	}
	
	public void setDao(IDao dao) {
		this.dao = dao;
	}
	
	public void save(String msg) {
		if (dao != null)
			dao.save(msg);
	}

}
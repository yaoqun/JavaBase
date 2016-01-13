package spring;

public class Autowire {
	
	private IDao byNameDao;
	
	public void setByNameDao(IDao byNameDao) {
		this.byNameDao = byNameDao;
	}
	
	public void save(String msg) {
		byNameDao.save(msg);
	}

}

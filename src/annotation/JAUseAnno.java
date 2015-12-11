package annotation;

@JAnno(name="JAUseAnno抽象类-interface")
public abstract class JAUseAnno
{
	@JAnno(name="JAUseAnno抽象类-method-抽象方法")
	public abstract void abstractAnno();
	
	@JAnno(name="JAUseAnno抽象类-method-具体方法")
	public void anno()
	{
	}
}

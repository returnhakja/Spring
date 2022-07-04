package run;

public class JPAFinalTest {

	public static void main(String[] args) {
		JPA01Create jc = new JPA01Create();
		JPA01Read jr = new JPA01Read();
		JPA01Update ju = new JPA01Update();
		JPA01Delete jd = new JPA01Delete();
		
//		jc.create();
		jr.Read();
		ju.Update(1L);
		jd.Delete(2L);
	}

}


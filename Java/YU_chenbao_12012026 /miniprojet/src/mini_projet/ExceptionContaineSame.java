package mini_projet;

public class ExceptionContaineSame extends Exception {

	public ExceptionContaineSame() {
		super("Cette piece existe deja!");
	}
}

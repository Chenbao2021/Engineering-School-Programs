package mini_projet;

public class ExceptionContaineSelf extends Exception {

		public ExceptionContaineSelf()
		{
			super("\"Error:l'objet ne peut pas contenir lui meme!\"");
		}
		/*
		 * public String toString() { return
		 * "Error:l'objet ne peut pas contenir lui meme!"; }
		 */
		
}


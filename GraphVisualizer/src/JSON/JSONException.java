
package JSON;


public class JSONException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JSONException(String s) {
        super(s);
    }

    public JSONException(Throwable cause) {
        super(cause);
    }

    public JSONException(String message, Throwable cause) {
        super(message, cause);
    }
}
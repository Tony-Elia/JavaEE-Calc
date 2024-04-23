package APP;

public class Response {
	public String error;
	public int result;
	
	public Response(int res, String err) {
		result = res;
		error = err;
	}
}

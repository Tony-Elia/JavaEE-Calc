package APP;
import EJBs.Calculator;
public class CalculationResult {
	public int result;

    public CalculationResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}

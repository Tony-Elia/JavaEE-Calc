package EJBs;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Stateless
@Entity
public class Calculator {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int op1;
    public int op2;
    public String operation;
    public int res;

    public Calculator() {}

    public Calculator(int operand1, int operand2, String operation, int result) {
        this.op1 = operand1;
        this.op2 = operand2;
        this.operation = operation;
        this.res = result;
    }

   

    public int getOperand1() {
        return op1;
    }

    public int getOperand2() {
        return op2;
    }

    public String getOperation() {
        return operation;
    }

    public int getResult() {
        return res;
    }

    public void setOperand1(int operand1) {
        this.op1 = operand1;
    }

    public void setOperand2(int operand2) {
        this.op2 = operand2;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setResult(int result) {
        this.res = result;
    }
}
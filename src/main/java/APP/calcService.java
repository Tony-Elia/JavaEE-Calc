package APP;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import EJBs.Calculator;
import APP.CalculationResult;



@Stateless
@Path("/calcproject")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class calcService {

    @PersistenceContext(unitName = "hello")
    private EntityManager entityManager;

    @GET
    @Path("test")
    public String testing() {
        return "SUCCESS!";
    }

    @POST
    @Path("calc")
    public Response createCalculation(Calculator request) {
        try {
            int number1 = request.getOperand1();
            int number2 = request.getOperand2();
            String operation = request.getOperation();
            int result = performOperation(number1, number2, operation);

            Calculator calculation = new Calculator(number1, number2, operation, result);
            entityManager.persist(calculation);

            return Response.ok(new CalculationResult(result)).build();
        } catch (ArithmeticException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Division by zero is not allowed.").build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid operation type.").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred during calculation.").build();
        }
    }

    @GET
    @Path("calculations")
    public Response getCalculations() {
        try {
            List<Calculator> calculations = entityManager.createQuery("SELECT c FROM Calculator c", Calculator.class).getResultList();
            return Response.ok(calculations).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while retrieving calculations.").build();
        }
    }

    private int performOperation(int operand1, int operand2, String operation) {
        switch (operation) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    throw new IllegalArgumentException("Division by zero is not allowed.");
                }
            default:
                throw new IllegalArgumentException("Invalid operation type.");
        }
    }

    public static class Result {
        private int result;

        public Result(int result) {
            this.result = result;
        }

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }
    }
}
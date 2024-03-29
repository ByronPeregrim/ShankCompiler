import java.util.ArrayList;

public class BuiltInStart extends FunctionNode {

    // Fills parameter array with default parameters in order to compare type and variability to future arguments
    VariableNode arrayParameter = new VariableNode("someArray", 0, 0, VariableNode.variableType.INTEGER);
    VariableNode integerParameter = new VariableNode("someInteger", VariableNode.variableType.INTEGER, true);
    static ArrayList<VariableNode> parameterArray = new ArrayList<VariableNode>();
    
    public BuiltInStart() {
        super("start", parameterArray, null, null, null, true);
        parameterArray.add(arrayParameter);
        parameterArray.add(integerParameter);
    }

    public void execute(ArrayList<InterpreterDataType> inputData) {
        // Checks for correct arguments
        if (inputData.size() == 2 && inputData.get(0) instanceof ArrayDataType && inputData.get(1) instanceof IntegerDataType && inputData.get(1).isChangeable() == true) {
            ArrayDataType inputArray = (ArrayDataType) inputData.get(0);
            IntegerDataType inputInteger = (IntegerDataType) inputData.get(1);
            inputInteger.setData(inputArray.getStartIndex());
            inputData.set(1, inputInteger);
        }
        else {
            System.out.println("Error: Incorrect arguments for Start function.");
            System.exit(0);
        }
    }
}
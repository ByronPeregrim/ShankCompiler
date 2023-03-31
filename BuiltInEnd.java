import java.util.ArrayList;

public class BuiltInEnd extends FunctionNode {

    VariableNode arrayParameter = new VariableNode("someArray", 0, 0, VariableNode.variableType.INTEGER);
    static ArrayList<VariableNode> parameterArray = new ArrayList<VariableNode>();
    
    public BuiltInEnd() {
        super("end", parameterArray, null, null);
        parameterArray.add(arrayParameter);
    }

    public void execute(ArrayList<InterpreterDataType> inputData) {
        if (inputData.size() == 1 && inputData.get(0) instanceof ArrayDataType && inputData.get(0).isChangeable() == true) {
            ArrayDataType inputArray = (ArrayDataType) inputData.get(0);
            IntegerDataType endIndex = new IntegerDataType(inputArray.getEndIndex(), false);
            inputData.set(0, endIndex);
        }
        else {
            System.out.println("Error: Incorrect arguments for Start function.");
            System.exit(0);
        }
    }
}
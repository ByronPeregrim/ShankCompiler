import java.util.ArrayList;

public class BuiltInRealToInteger extends FunctionNode {

    public BuiltInRealToInteger() {
        super("RealToInteger", null, null, null);
    }

    public void execute(ArrayList<InterpreterDataType> inputData) {
        if (inputData.size() == 2 && inputData.get(0) instanceof RealDataType && inputData.get(1) instanceof IntegerDataType && inputData.get(1).isChangeable() == true) {
            RealDataType someRealData = (RealDataType) inputData.get(0);
            float someReal = someRealData.getData();
            int someInt = (int) someReal;
            IntegerDataType someIntegerData = (IntegerDataType) inputData.get(1);
            someIntegerData.setData(someInt);
            inputData.set(1, someIntegerData);
        }
        else {
            System.out.println("Error: Incorrect arguments for RealToInteger function.");
            System.exit(0);
        }
    }

}
import java.util.ArrayList;

public class BuiltInSubstring extends FunctionNode {

    public BuiltInSubstring() {
        super("Substring", null, null, null);
    }

    public void execute(ArrayList<InterpreterDataType> inputData) {
        if (inputData.size() == 4 && inputData.get(0) instanceof StringDataType && inputData.get(1) instanceof IntegerDataType && inputData.get(2) instanceof IntegerDataType
        && inputData.get(3) instanceof StringDataType && inputData.get(3).isChangeable() == true) {
            StringDataType someStringData = (StringDataType) inputData.get(0);
            IntegerDataType indexData = (IntegerDataType) inputData.get(1);
            IntegerDataType lengthData = (IntegerDataType) inputData.get(2);
            StringDataType resultStringData = (StringDataType) inputData.get(3);
            int index = indexData.getData();
            int length = lengthData.getData();
            String someString = someStringData.getData();
            String resultString = "";
            for (int i = index; i < index + length; i++) { //Prints string from char at given index until char at index plus given length
                resultString += someString.charAt(i);
            }
            resultStringData.setData(resultString);
            inputData.set(3, resultStringData);
        }
        else {
            System.out.println("Error: Incorrect arguments for Substring function.");
            System.exit(0);
        }
    }

}
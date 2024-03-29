import java.util.ArrayList;

public class ArrayDataType extends InterpreterDataType {
    
    public enum arrayDataType { REAL, INTEGER, CHARACTER, STRING, BOOLEAN }
    private arrayDataType type;
    private ArrayList<InterpreterDataType> array = new ArrayList<InterpreterDataType>();
    private boolean isChangeable;
    private int startIndex = 0;
    private int endIndex = 0;
    
    public ArrayDataType(arrayDataType inputArrayDataType, int inputStartIndex, int inputEndIndex, boolean inputIsChangeable) {
        type = inputArrayDataType;
        isChangeable = inputIsChangeable;
        startIndex = inputStartIndex;
        endIndex = inputEndIndex;
        switch (type) { //Initializes default values for the specified array data type
            case REAL: 
                for (int i = 0; i < endIndex - startIndex; i++) {
                    RealDataType realData = new RealDataType(0, true);
                    array.add(realData);
                }
                break;
            case INTEGER: 
                for (int i = 0; i < endIndex - startIndex; i++) {
                    IntegerDataType integerData = new IntegerDataType(0, true);
                    array.add(integerData);
                }
                break;
            case BOOLEAN: 
                for (int i = 0; i < endIndex - startIndex; i++) {
                    BooleanDataType booleanData = new BooleanDataType(false, true);
                    array.add(booleanData);
                }
                break;
            case STRING: 
                for (int i = 0; i < endIndex - startIndex; i++) {
                    StringDataType stringData = new StringDataType("", true);
                    array.add(stringData);
                }
                break;
            case CHARACTER: 
                for (int i = 0; i < endIndex - startIndex; i++) {
                    CharacterDataType characterData = new CharacterDataType(' ', true);
                    array.add(characterData);
                }
                break;
            default :
                System.out.println("ERROR: Data type not provided for array.");
                System.exit(0);
        }
    }

    public ArrayDataType(ArrayList<InterpreterDataType> inputData, boolean inputIsChangeable) {
        array = inputData;
        isChangeable = inputIsChangeable;
    }

    public void FromString(String input) {
        
    }

    public arrayDataType getArrayType() {
        return type;
    }

    public ArrayList<InterpreterDataType> getArray() {
        return array;
    }

    public InterpreterDataType getDataAtIndex(int inputIndex) {
        if (array.get(inputIndex) != null)
            return array.get(inputIndex);
        System.out.println("ERROR: Value at array index is null.");
        System.exit(0);
        return null;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public boolean isChangeable() {
        return isChangeable;
    }

    public void setArray(ArrayList<InterpreterDataType> inputArray) {
        array = inputArray;
    }

    public void setIndex(int inputIndex, InterpreterDataType inputData) { //Sets value at given index
        array.set(inputIndex, inputData);
    }

    public void setRange(int inputStartIndex, int inputEndIndex) {
        startIndex = inputStartIndex;
        endIndex = inputEndIndex;
    }

    public String ToString() {
        String str = "ArrayDataType(";
        for (int i = 0; i < array.size(); i++) {
            str += array.get(i) + ", ";
        }
        str += ")";
        return str;
    }
}

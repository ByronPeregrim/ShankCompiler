import java.util.ArrayList;

public class FunctionCallNode extends Node {
    
    private String functionName;
    private ArrayList<ParameterNode> parameterArray = new ArrayList<ParameterNode>();

    public FunctionCallNode(String inputName, ArrayList<ParameterNode> inputParameterArray) {
        functionName = inputName;
        parameterArray = inputParameterArray;
    }

    public String ToString() {
        String str = "FunctionCallNode(\n Name: " + functionName + "\n Parameters:\n";
        for (int i = 0; i < parameterArray.size() ; i++) {
            str += " " + parameterArray.get(i).ToString() + "\n";
        }
        str += ")\n";
        return str;
    }
}
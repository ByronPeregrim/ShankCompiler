import java.util.ArrayList;

public class RepeatNode extends StatementNode {

    private BooleanCompareNode condition;
    private ArrayList<StatementNode> statements = new ArrayList<StatementNode>();

    public RepeatNode(BooleanCompareNode inputCondition, ArrayList<StatementNode> inputStatementArray) {
        condition = inputCondition;
        statements = inputStatementArray;
    }

    public BooleanCompareNode getCondition() {
        return condition;
    }

    public ArrayList<StatementNode> getStatements() {
        return statements;
    }

    public String ToString() {
        String str = "\nRepeatNode(\n Condition: ";
        str += condition.ToString() + "\n Statements:\n";
        
        for (int i = 0; i < statements.size() ; i++) {
            str += statements.get(i).ToString();
        }
        str += "\n)";
        return str;
    }
}
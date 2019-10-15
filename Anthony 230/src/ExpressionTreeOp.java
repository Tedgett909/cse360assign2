public class ExpressionTreeOp 
{
    private int termType;
    private char operator;
    private int value;
    private char variable;

    public ExpressionTreeOp(int type, char op, int val, char var) 
    {
        termType = type;
        operator = op;
        value = val;
        variable = var;
        
    }

    public boolean isOperator() 
    {
        return (termType == 1);
    }
    
    public char getOperator() 
    {
        return operator;
    }
    
    public boolean isVariable()
    {
    	return(termType == 3);
    }
    
    public char getVariable() 
    {
    	return variable;
    }
    public boolean isValue()
    {
    	return(termType == 2);
    }
    public int getValue() 
    {
        return value;
    }
    
    
    
    
    public String toString()
    {
        if (termType == 1) 
            return operator + "";
        else if(termType == 2)
            return value + "";
        else 
        	return variable + "";
    }
}
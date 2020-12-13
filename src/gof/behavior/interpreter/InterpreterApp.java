package gof.behavior.interpreter;

public class InterpreterApp {
    public static void main(String[] args) {
        Context context = new Context();
        Expression expression = context.evaluate("10+2-3");
        System.out.println(expression.interpret());
    }
}

interface Expression {
    int interpret();
}

class TerminalNumberExpression implements Expression {
    int number;

    public TerminalNumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}

class NonterminalMinusExpression implements Expression {
    Expression left;
    Expression right;

    public NonterminalMinusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }
}

class NonterminalPlusExpression implements Expression {
    Expression left;
    Expression right;

    public NonterminalPlusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

class Context {
    Expression evaluate(String s) {
        int pos = s.length() - 1;
        while (pos > 0)
            if (Character.isDigit(s.charAt(pos)))
                pos--;
            else {
                Expression left = evaluate(s.substring(0, pos));
                Expression right = new TerminalNumberExpression(Integer.valueOf(s.substring(pos + 1, s.length())));
                char operator = s.charAt(pos);
                switch (operator) {
                    case '-' : return new NonterminalMinusExpression(left, right);
                    case '+' : return new NonterminalPlusExpression(left, right);
                }
            }
        int result = Integer.valueOf(s);
        return new TerminalNumberExpression(result);
    }
}

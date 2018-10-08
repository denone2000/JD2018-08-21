package by.it.basumatarau.calc.v3;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public Var calc(String infixLine) throws CalcException{
        if (!parenthOrderChecker(infixLine)) {
            throw new CalcException(
                    CalcExceptionResManager.ENTITY.getMsgByKey(I18nKeys.PARSER_EXCEPTION_WRONG_PARENTH)
            );
        }
        StringBuilder postfixLine = new StringBuilder();
        String token;
        Stack<String> tokenStack = new Stack<>();
        Pattern anyToken = Pattern.compile(RegExPatterns.TOKEN);
        Matcher tokenMatcher = anyToken.matcher(infixLine.trim());

        while (tokenMatcher.find()) {
            token = tokenMatcher.group();
            if (token.matches(RegExPatterns.LITERAL) || token.matches(RegExPatterns.IDENTIFIER)) {
                postfixLine.append(" ").append(token);
            } else if (token.matches(RegExPatterns.OPERATOR)) {
                if (tokenStack.empty() || tokenStack.peek().matches(RegExPatterns.OPENING_SEPARATOR) || getOpPrecedence(token) < getOpPrecedence(tokenStack.peek())) {
                    tokenStack.push(token);
                } else {
                    while (!tokenStack.empty() && !tokenStack.peek().matches(RegExPatterns.OPENING_SEPARATOR) && getOpPrecedence(token) >= getOpPrecedence(tokenStack.peek())) {
                        postfixLine.append(" ").append(tokenStack.pop());
                    }
                    tokenStack.push(token);
                }
            } else if (token.matches(RegExPatterns.OPENING_SEPARATOR)) {
                tokenStack.push(token);
            } else if (token.matches(RegExPatterns.CLOSING_SEPARATOR)) {
                while (!tokenStack.empty() && !tokenStack.peek().matches(RegExPatterns.OPENING_SEPARATOR)) {
                    postfixLine.append(" ").append(tokenStack.pop());
                }
                if (tokenStack.peek().matches(RegExPatterns.OPENING_SEPARATOR)) {
                    tokenStack.pop();
                }
            }
        }
        while (!tokenStack.empty()) {
            postfixLine.append(" ").append(tokenStack.pop());
        }

        Pattern postfixToken = Pattern.compile("(" + RegExPatterns.SIMPLE_TOKEN + ")|(" + RegExPatterns.OPERATOR + ")|(" + RegExPatterns.IDENTIFIER + ")");
        tokenMatcher = postfixToken.matcher(postfixLine);
        while (tokenMatcher.find()) {
            token = tokenMatcher.group();
            if (token.matches(RegExPatterns.LITERAL) || token.matches(RegExPatterns.IDENTIFIER)) {
                tokenStack.push(token);
            }
            if (token.matches(RegExPatterns.OPERATOR)) {
                Var rightVar;
                Var leftVar;
                if (token.matches("=")) {
                    rightVar = Var.createVar(tokenStack.pop());
                    tokenStack.push(Var.saveVar(tokenStack.pop(), rightVar).toString());
                } else if (token.matches("\\+")) {
                    tokenStack.push((Var.createVar(tokenStack.pop()).add(Var.createVar(tokenStack.pop()))).toString());
                } else if (token.matches("-")) {
                    rightVar = Var.createVar(tokenStack.pop());
                    leftVar = Var.createVar(tokenStack.pop());
                    tokenStack.push(leftVar.sub(rightVar).toString());
                } else if (token.matches("/")) {
                    rightVar = Var.createVar(tokenStack.pop());
                    leftVar = Var.createVar(tokenStack.pop());
                    tokenStack.push(leftVar.div(rightVar).toString());
                } else if (token.matches("\\*")) {
                    rightVar = Var.createVar(tokenStack.pop());
                    leftVar = Var.createVar(tokenStack.pop());
                    tokenStack.push(leftVar.mul(rightVar).toString());
                } else throw new CalcException(
                        String.format(
                                CalcExceptionResManager.ENTITY.getMsgByKey(I18nKeys.PARSER_EXCEPTION_OPERATION_NOT_IMPLEMENTED),
                                token)
                );
            }
        }
        return Var.createVar(tokenStack.pop());

    }

    private int getOpPrecedence(String operatorToken) throws CalcException{
        int precedence;
        if(operatorToken.matches("([*])|([/])")){
            precedence = 1;
        }else if(operatorToken.matches("([+])|([-])")){
            precedence = 2;
        }else if(operatorToken.matches("=")){
            precedence = 3;
        }else throw new CalcException(
                String.format(
                        CalcExceptionResManager.ENTITY.getMsgByKey(I18nKeys.PARSER_EXCEPTION_UNKNOWN_OPERATOR_PRECEDENCE),
                        operatorToken
                )
        );

        return precedence;
    }

    private static boolean parenthOrderChecker(String line){
        Stack<String> separatorStack = new Stack<>();

        Pattern pattern = Pattern.compile(RegExPatterns.SEPARATOR);
        Matcher parMatcher = pattern.matcher(line);

        String buffer;
        String token;
        while(parMatcher.find()){
            token=parMatcher.group();
            if((token).matches(RegExPatterns.OPENING_SEPARATOR)){
                separatorStack.push(token);
            }else if(token.matches(RegExPatterns.CLOSING_SEPARATOR)){
                buffer = token;
                if(separatorStack.empty()) return false;
                //noinspection LoopStatementThatDoesntLoop the loop statement will be likely necessary for further work with the code (no latency footprint is anticipated)
                while(!((token=separatorStack.pop()).contains(RegExPatterns.OPENING_SEPARATOR))){
                    if(!token.concat(buffer).matches("(\\[])|(\\{})|(\\(\\))")){
                        return false;
                    }else break;
                }
            }
        }
        return separatorStack.size()==0;
    }
}


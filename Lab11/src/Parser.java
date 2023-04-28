/*<Expr>::= <Term> <Adds>
 * <Adds>::= + <Expr> | - <Expr> | ε
 * <Term>::= IDENT | NUMBER | ( <Expr> )
 * */

public class Parser {
    private int currentCharIndex;

    private String StringToParse;

    Parser(String str) {
        this.StringToParse = str.replaceAll("\\s+", "");
        this.currentCharIndex = 0;
    }

    public static Parser NewParser(String str) {
        return new Parser(str);
    }

    void parseS() {
        parseExpr();
        if (currentCharIndex != StringToParse.length()) {
            System.out.println("syntax error at (line 1, col " + currentCharIndex + ")");
            System.exit(-1);
        }
    }

    private void parseExpr() {
        parseTerm();
        parseAdds();
    }

    private void parseAdds() {
        if (currentCharIndex == StringToParse.length()) {
            System.out.println("epsilon");
            return;
        }
        if (StringToParse.charAt(currentCharIndex) == '+') {
            System.out.println("+ <Expr>");
            currentCharIndex++;
            parseExpr();
        } else if (StringToParse.charAt(currentCharIndex) == '-') {
            System.out.println("- <Expr>");
            currentCharIndex++;
            parseExpr();
        } else {
            System.out.println("epsilon");
            return;
        }
    }

    private void parseTerm() {
        if (Character.isLetter(StringToParse.charAt(currentCharIndex))) {
            System.out.println("IDENT");
            while (currentCharIndex < StringToParse.length() && (Character.isLetter(StringToParse.charAt(currentCharIndex)) ||
                    Character.isDigit(StringToParse.charAt(currentCharIndex)))) {
                currentCharIndex++;
            }

        } else if (Character.isDigit(StringToParse.charAt(currentCharIndex))) {
            System.out.println("NUMBER");
            while (currentCharIndex < StringToParse.length() && Character.isDigit(StringToParse.charAt(currentCharIndex))) {
                currentCharIndex++;
            }
        } else if (StringToParse.charAt(currentCharIndex) == '(') {
            System.out.println("(<Expr>)");
            currentCharIndex++;
            parseExpr();
            if (StringToParse.charAt(currentCharIndex) == ')') {
                currentCharIndex++;
            } else {
                System.out.println("error");
                System.exit(-1);
            }
        } else {
            System.out.println("syntax error at (line 1, col " + currentCharIndex + ")");
            System.exit(-1);
        }
    }
}

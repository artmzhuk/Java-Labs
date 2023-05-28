/*<Expr>::= <Term> <Adds>
 * <Adds>::= + <Expr> | - <Expr> | ε
 * <Term>::= IDENT | NUMBER | ( <Expr> )
 * a + 10 - (x - 1)
 * */

public class Main {
    public static void main(String[] args) {
        Parser.NewParser("a + 10 - (x - 1)").parseS();
        //Parser.NewParser("X + BMSTU1830&&## - (205 + x45)+ 85").parseS();
        //Parser.NewParser("***ptr[x++][--y[i]]--").parseS();
    }
}
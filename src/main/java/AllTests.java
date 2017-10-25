
// All tests
public class AllTests {
    public static void main(String[] args) {

        // fact (n) if n = 0 then 1 else n * fact (n - 1) fi

        Def def2
                = Asts.def("k", Asts.constantExp(Asts.expVal(2)));

        Exp exp1
                = Asts.arithmeticExp(Asts.identifierExp("n"),
                "MINUS",
                Asts.constantExp(Asts.expVal(1)));
        Exp call1
                = Asts.callExp(Asts.identifierExp("fact"),
                Asts.list(exp1));
        Exp testPart
                = Asts.arithmeticExp(Asts.identifierExp("n"),
                "EQ",
                Asts.constantExp(Asts.expVal(0)));
        Exp thenPart
                = Asts.constantExp(Asts.expVal(1));
        Exp elsePart
                = Asts.arithmeticExp(Asts.identifierExp("n"),
                "TIMES",
                call1);
        Def def1
                = Asts.def("fact",
                Asts.lambdaExp(Asts.list("n"),
                        Asts.ifExp(testPart,
                                thenPart,
                                elsePart)));

        Def def3 = Asts.def("multiply",
                Asts.lambdaExp(Asts.list("n"),
                        Asts.arithmeticExp(Asts.callExp(Asts.identifierExp
                                        ("fact"),
                                Asts.list(Asts.identifierExp("n"))),
                                "TIMES",
                                Asts.identifierExp("k"))));

        ExpVal result = Programs.run(Asts.list(def3, def1, def2),
                Asts.list(Asts.expVal(5)));

        assert (result.asInteger()) == 240;


        // (λ (k) k + ((λ (k) k * k) (7))) (1)

        Def add = Asts.def("add",
                Asts.lambdaExp(Asts.list("k"),
                        Asts.arithmeticExp(
                                Asts.callExp(Asts.identifierExp
                                                ("multiply"),
                                        Asts.list(Asts.constantExp(Asts.expVal(7)))),
                                "PLUS",
                                Asts.identifierExp
                                        ("k"))));

        Def multiply = Asts.def("multiply",
                Asts.lambdaExp(Asts.list("k"),
                        Asts.arithmeticExp(Asts.identifierExp("k"),
                                "TIMES",
                                Asts.identifierExp("k"))));

        ExpVal result2 = Programs.run(Asts.list(add, multiply),
                Asts.list(Asts.expVal(1)));

        assert (result2.asInteger()) == 50;

        //multiple def
        Exp exp3 = Asts.arithmeticExp(Asts.identifierExp("n"), "PLUS",
                Asts.constantExp(Asts.expVal(4)));
        Exp call4 = Asts.callExp(Asts.identifierExp("add4"),
                Asts.list(Asts.identifierExp("n")));
        Exp exp2 = Asts.arithmeticExp(call4, "PLUS",
                Asts.constantExp(Asts.expVal(2)));
        Exp call2 = Asts.callExp(Asts.identifierExp("add2"),
                Asts.list(Asts.identifierExp("n")));
        Exp exp11 = Asts.arithmeticExp(call2, "PLUS",
                Asts.constantExp(Asts.expVal(1)));
        Def add1 = Asts.def("add1",
                Asts.lambdaExp(Asts.list("n"), exp11));
        Def add2 = Asts.def("add2",
                Asts.lambdaExp(Asts.list("n"), exp2));
        Def add3 = Asts.def("add4",
                Asts.lambdaExp(Asts.list("n"), exp3));
        ExpVal result3 = Programs.run(Asts.list(add1, add2, add3),
                Asts.list(Asts.expVal(9)));

        assert (result3.asInteger()) == 16;

        System.out.println("\nAll tests passed");

    }
}

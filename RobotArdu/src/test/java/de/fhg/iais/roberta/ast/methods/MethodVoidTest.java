package de.fhg.iais.roberta.ast.methods;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.fhg.iais.roberta.factory.BotNrollFactory;
import de.fhg.iais.roberta.util.test.ardu.Helper;

public class MethodVoidTest {
    Helper h = new Helper();
    BotNrollFactory robotFactory = new BotNrollFactory(null);

    @Before
    public void setUp() throws Exception {
        this.h.setRobotFactory(this.robotFactory);
    }

    @Test
    public void methodVoid1() throws Exception {
        String a =
            "BlockAST [project=[[Location [x=103, y=38], MethodVoid [do something, VarDeclaration [NUMBER, x, EmptyExpr [defVal=NUMBER], false, false], \n"
                + "AktionStmt [MotorOnAction [B, MotionParam [speed=NumConst [30], duration=null]]]]]]]";
        Assert.assertEquals(a, this.h.generateTransformerString("/ast/methods/method_void_1.xml"));

    }

    @Test
    public void methodVoid2() throws Exception {
        String a =
            "BlockAST [project=[[Location [x=103, y=38], MethodVoid [do something, , \n"
                + "AktionStmt [MotorOnAction [B, MotionParam [speed=NumConst [30], duration=null]]]]]]]";
        Assert.assertEquals(a, this.h.generateTransformerString("/ast/methods/method_void_2.xml"));

    }

    @Test
    public void reverseTransformation1() throws Exception {
        this.h.assertTransformationIsOk("/ast/methods/method_void_1.xml");
    }

    @Test
    public void reverseTransformation2() throws Exception {
        this.h.assertTransformationIsOk("/ast/methods/method_void_2.xml");
    }
}

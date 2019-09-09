package use.functionalk.maven;

import static functionalj.function.Func.f;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import functionalj.function.Func2;
import functionalj.result.Result;

public class MonadAgnosticTest {
    
    @Test
    public void testMonadAgnostic() {
        Func2<String, String, String> func = f((s1, s2)->s1+" "+s2);
        
        Result<String> text1 = Result.valueOf("Text1");
        Result<String> text2 = Result.valueOf("Text2");
        assertEquals("Result:{ Value: Text1 Text2 }", "" + func.applyTo(text1, text2));
    }
    
}

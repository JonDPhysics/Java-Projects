import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

/**
 * Tests that the RobotFaceDrawer class has the drawCheckedLineStartsEmpty method.
 * 
 * @author Chad Hogg
 */
public class Q05StructureTest {

	@Test
	public void testMethodExists() {
		Method[] methods = RobotFaceDrawer.class.getDeclaredMethods();
		String methodName = "drawCheckedLineStartsEmpty";
		boolean foundIt = false;
		
		for(Method mthd : methods){
			if(mthd.getName().equals(methodName)){
				foundIt = true;
				assertEquals("The " + methodName + " method should have no parameters (nothing in the parenthesis).", 0, mthd.getParameterCount());
				assertTrue("The " + methodName + " method should be public.", Modifier.isPublic(mthd.getModifiers()));
				assertTrue("The " + methodName + " method should be static.", Modifier.isStatic(mthd.getModifiers()));
				assertEquals("The " + methodName + " method should return void.", void.class, mthd.getReturnType());
			}
		}
		
		if(!foundIt){
			fail("There is no method named " + methodName + ".");
		}
	}
}

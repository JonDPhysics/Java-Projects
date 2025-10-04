import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

/**
 * Tests that the RobotFaceDrawer class has the main method.
 * 
 * @author Chad Hogg
 */
public class Q07StructureTest {

	@Test
	public void testMethodExists() {
		Method[] methods = RobotFaceDrawer.class.getDeclaredMethods();
		String methodName = "main";
		boolean foundIt = false;
		
		for(Method mthd : methods){
			if(mthd.getName().equals(methodName)){
				foundIt = true;
				assertEquals("The " + methodName + " method should have one parameter.", 1, mthd.getParameterCount());
				assertTrue("The " + methodName + " method should be public.", Modifier.isPublic(mthd.getModifiers()));
				assertTrue("The " + methodName + " method should be static.", Modifier.isStatic(mthd.getModifiers()));
				assertEquals("The " + methodName + " method should return void.", void.class, mthd.getReturnType());
				assertEquals("The " + methodName + " method's first parameter should be String[].", String[].class, mthd.getParameterTypes()[0]);
			}
		}
		
		if(!foundIt){
			fail("There is no method named " + methodName + ".");
		}
	}
}

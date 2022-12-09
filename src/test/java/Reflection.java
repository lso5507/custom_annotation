import org.example.domain.MyClass;
import org.example.domain.MyInterface;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    @Test
    public void 리플렉션테스트_생성자() throws ClassNotFoundException, NoSuchMethodException {
        //클래스 이름으로 클래스 객체를 얻는 방법
        Class cls = Class.forName("org.example.domain.MyClass");
        //MyClass constructor = new MyClass();
        Constructor constructor = cls.getDeclaredConstructor();
        //인자 X
        System.out.println("Constructor : " + constructor.getName());

        Constructor constructor_parm = cls.getDeclaredConstructor(String.class,String.class);
        //인자 X
        System.out.println("Constructor : " + constructor_parm.getName());

        //모든 생성자
        Constructor constructors[] = cls.getDeclaredConstructors();

        for (Constructor item : constructors){
            System.out.println("Get constructors : " + item);
            // Get constructors : public test.Dog()
            // Get constructors : public test.Dog(java.lang.String)
        }
    }
    @Test
    public void 리플렉션테스트_필드() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("org.example.domain.MyClass");
        Object mycl = clazz.getDeclaredConstructor().newInstance();
        System.out.println("clazz = " + clazz);
        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);
        System.out.println("field.get(mycl) = " + field.get(mycl));
        System.out.println("name = " + field);
        System.out.println("str_name = " + field.get(mycl));
        // filed 값 수정
        field.set(mycl, "new name");
        System.out.println("field.get(mycl) = " + field.get(mycl));


    }
    @Test
    public  void 리플렉션테스트_메소드() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class clazz = Class.forName("org.example.domain.MyClass");
        //인스턴스화
        Object mycl = clazz.getDeclaredConstructor().newInstance();
        System.out.println("mycl.getClass() = " + mycl.getClass());        
        //메소드 가져오기
        Method method = clazz.getDeclaredMethod("setName", String.class);
        System.out.println("method.getName() = " + method.getName());
        method.invoke(mycl,"swlee");
        
        
        //필드 값 가져와보자
        Field field = clazz.getDeclaredField("name");
        //private 값 가져오기 위함
        field.setAccessible(true);
        Object name = field.get(mycl);
        System.out.println("name = " + name);


    }
}

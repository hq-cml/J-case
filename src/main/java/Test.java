import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/*
 */
@Documented
@Target(METHOD)
@Retention(RUNTIME)
@interface ReqType {
    enum ReqTypeEnum{ GET,POST,DELETE,PUT};
    ReqTypeEnum reqType() default ReqTypeEnum.POST;
}

@Documented
@Target(METHOD)
@Retention(RUNTIME)
@interface ReqUrl {
    String reqUrl() default "";
}

@Documented
@Target(PARAMETER)
@Retention(RUNTIME)
@interface ReqParam {
    String value() default "";
}

interface IReqApi {
    @ReqType(reqType = ReqType.ReqTypeEnum.POST)//声明采用post请求
    @ReqUrl(reqUrl = "www.xxx.com/openApi/login")//请求Url地址
    String login(@ReqParam("userId") String userId, @ReqParam("pwd") String pwd);//参数用户名 密码
}

public class Test {
    public static void main(String []args) {
        IReqApi api = create(IReqApi.class);
        api.login("whoislcj", "123456");
    }

    public static <T> T create(final Class<T> service) {
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[]{service},
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object... args) throws Throwable {
                        // Annotation[]  methodAnnotations = method.getAnnotations();//拿到函数注解数组
                        ReqType reqType = method.getAnnotation(ReqType.class);
                        System.out.println("IReqApi---reqType->" + (reqType.reqType() == ReqType.ReqTypeEnum.POST ? "POST" : "OTHER"));
                        ReqUrl reqUrl = method.getAnnotation(ReqUrl.class);
                        System.out.println("IReqApi---reqUrl->" + reqUrl.reqUrl());
                        Type[] parameterTypes = method.getGenericParameterTypes();
                        Annotation[][] parameterAnnotationsArray = method.getParameterAnnotations();//拿到参数注解
                        for (int i = 0; i < parameterAnnotationsArray.length; i++) {
                            //System.out.println("AAAAAAAAAAA");
                            Annotation[] annotations = parameterAnnotationsArray[i];
                            if (annotations != null) {
                                ReqParam reqParam = (ReqParam) annotations[0];
                                System.out.println("reqParam---reqParam->" + reqParam.value() + "==" + args[i]);
                            }
                        }
                        //下面就可以执行相应的网络请求获取结果 返回结果
                        String result = "";//这里模拟一个结果

                        return result;
                    }
                });
    }
}

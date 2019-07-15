package org.spring.proxy;

import org.spring.model.LogInfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 1.create a class implements InvocationHandler interface
 */
public class LogProxy implements InvocationHandler{
    private LogProxy(){

    }
    //2.create a proxy object
    private Object target;
    //3.create a function to generate a object, the argument to this function is the object to be proxied.
    public static Object getInstance(Object o){
        //3.1 create LogProxy Object
        LogProxy proxy = new LogProxy();
        //3.2 set this proxy object
        proxy.target = o;
        /*
         * 3.3 create proxy object by Proxy method, the first parameter is classloader,
         *     the second parameter is Proxy object implements all interfaces,
         *     the third parameter is the object of implement class InvocationHandler.
         */
        //Now result is a proxy Object to o
        Object result = Proxy.newProxyInstance(o.getClass().getClassLoader(),o.getClass().getInterfaces(),proxy);
        return result;
    }

    /**
     *
     * When there is a proxy object, no matter what method the proxy object run, will always call this invoke method.
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object args[]) throws Throwable{
        /*if(method.getName().equals("add")){
            Logger.info("LogProxy执行了add操作");
        }else if(method.getName().equals("delete")){
            Logger.info("LogProxy执行了delete操作");
        }*/
        if(method.isAnnotationPresent(LogInfo.class)){
            LogInfo li = method.getAnnotation(LogInfo.class);
            Logger.info(li.value());
        }


        Object obj = method.invoke(target,args);
        return obj;
    }
}

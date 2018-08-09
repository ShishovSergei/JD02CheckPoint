//package by.itacademy;
//
//import by.itacademy.config.ServiceConfiguration;
//import org.springframework.beans.BeansException;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class ApplicationContextHolder {
//    private static final AnnotationConfigApplicationContext APPLICATION_CONTEXT;
//
//    static {
//        APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(ServiceConfiguration.class);
//    }
//
//    public static <T> T getBean(Class<T> beenClass) {
//        try {
//            return APPLICATION_CONTEXT.getBean(beenClass);
//        } catch (BeansException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void destroy() {
//        APPLICATION_CONTEXT.close();
//    }
//}

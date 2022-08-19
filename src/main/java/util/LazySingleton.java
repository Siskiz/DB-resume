package util;


public class LazySingleton {

    private LazySingleton() {

    }

    private static class LazySingletonHolder {
//      volatile
        private static final LazySingleton INSTANCE = new LazySingleton();
    }


    private static LazySingleton getInstance() {
        return LazySingletonHolder.INSTANCE;
//        if (INSTANCE == null) {
//            synchronized (LazySingleton.class) {
//                if (INSTANCE == null) {
//                    int i = 13;
//                    INSTANCE = new LazySingleton();
//                }
//            }
//        }
//        return INSTANCE;
    }

}

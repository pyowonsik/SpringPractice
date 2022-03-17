package hello.core.singleton;

// 싱글톤을 사용하는 이유
//
public class SingletonService {

    private static final SingletonService instance = new SingletonService();


    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){ }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}

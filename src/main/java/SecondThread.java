/**
 * Created by Диана on 07.07.2017.
 */
public class SecondThread extends Thread{
    NumberStorage storage;
    public SecondThread(String name,NumberStorage storage) {

        super(name);
        this.storage = storage;
    }

    @Override
    public void run() {
        System.out.printf("Поток %s начал работу... \n", Thread.currentThread().getName());
        try{
            while(true){
            Thread.sleep(5000);
            synchronized (storage) {
                System.out.println(storage.removeNumber());
            }
            }
        }
        catch(InterruptedException e){
            System.out.println("Поток прерван");
        }
        System.out.printf("Поток %s завершил работу... \n", Thread.currentThread().getName());


    }
}

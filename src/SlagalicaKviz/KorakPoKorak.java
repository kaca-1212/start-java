package SlagalicaKviz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class KorakPoKorak {

    ExecutorService service = Executors.newSingleThreadExecutor();
   // try{
        Runnable r = new Runnable() {
            @Override
            public void run() {
                //database task
            }
        };
        Future<?> f = service.submit(r);
       // f.get(25, TimeUnit.SECONDS);

    }


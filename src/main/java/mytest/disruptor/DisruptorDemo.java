package mytest.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import mytest.disruptor.eventfactory.LongEventFactory;
import mytest.disruptor.eventhandler.LongEventHandler;
import mytest.disruptor.eventproducer.LongEventProducer;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by chenjienn on 2016/4/21.
 */
public class DisruptorDemo {
    public static void main(String args[]){
        Executor executor = Executors.newCachedThreadPool();

        LongEventFactory factory = new LongEventFactory();

        int buffersize = 1024;

        Disruptor disruptor = new Disruptor(factory, buffersize, executor);

        disruptor.handleEventsWith(new LongEventHandler());

        disruptor.start();

        RingBuffer ringBuffer = disruptor.getRingBuffer();

        LongEventProducer producer = new LongEventProducer(ringBuffer);

        while (true){
            producer.onData();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

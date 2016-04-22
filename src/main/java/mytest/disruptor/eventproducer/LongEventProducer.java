package mytest.disruptor.eventproducer;

import com.lmax.disruptor.RingBuffer;
import mytest.disruptor.eventbean.LongEvent;

import java.util.Random;

/**
 * Created by chenjienn on 2016/4/21.
 */
public class LongEventProducer {
    private final RingBuffer ringBuffer;

     public LongEventProducer(RingBuffer ringBuffer){
         this.ringBuffer = ringBuffer;
     }

    public void onData(){
        long sequence = ringBuffer.next();
        LongEvent event = (LongEvent) ringBuffer.get(sequence);
        Random random = new Random(System.currentTimeMillis());
        event.setValue(random.nextLong());

        ringBuffer.publish(sequence);
    }
}

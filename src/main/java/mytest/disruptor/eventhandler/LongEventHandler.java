package mytest.disruptor.eventhandler;

import com.lmax.disruptor.EventHandler;
import mytest.disruptor.eventbean.LongEvent;

/**
 * Created by chenjienn on 2016/4/21.
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("Event: " + event.getValue());
    }
}

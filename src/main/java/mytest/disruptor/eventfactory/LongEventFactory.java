package mytest.disruptor.eventfactory;

import com.lmax.disruptor.EventFactory;
import mytest.disruptor.eventbean.LongEvent;

/**
 * Created by chenjienn on 2016/4/21.
 */
public class LongEventFactory implements EventFactory{
    public Object newInstance() {
        return new LongEvent();
    }
}

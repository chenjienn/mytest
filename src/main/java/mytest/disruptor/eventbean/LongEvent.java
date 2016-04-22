package mytest.disruptor.eventbean;

/**
 * Created by chenjienn on 2016/4/21.
 */
public class LongEvent {
    private long value;

    public void setValue(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}

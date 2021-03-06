package erreesse.time;

import erreesse.pojo.CommentInfoPOJO;
import org.apache.flink.streaming.api.functions.timestamps.AscendingTimestampExtractor;

public class DateTimeAscendingAssigner extends AscendingTimestampExtractor<CommentInfoPOJO> {

    public DateTimeAscendingAssigner() {
    }

    @Override
    public long extractAscendingTimestamp(CommentInfoPOJO commentInfoPOJO) {
        // use createdate timestamp in millis as event time
        return commentInfoPOJO.getCreateDate()*1000L;
    }
}

package erreesse.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class CommentInfoPOJO implements Serializable {

    public CommentInfoPOJO() {
        processingTime = System.nanoTime();
    }

    private long approvedDate;
    private String articleID;

    private long commentID;
    private String commentType;
    private long createDate;
    private int depth;

    private boolean editorsSelection;
    private long inReplyTo;

    private double recommendations;
    private String userDisplayName;
    private String parentUserDisplayName;
    private long userID;

    public void setRecommendations(Double rec) {
        if (editorsSelection) {
            recommendations = (1.1) * rec;
        } else {
            recommendations = rec;
        }
    }

    public long processingTime;

    public boolean isDirect() {
        return depth == 1;
    }

    public static CommentInfoPOJO parseFromStringLine(String line) {
        String[] tokens = line.split(",",-1);

        CommentInfoPOJO cip = null;
        if (tokens.length>=15) {
            try {
                cip = new CommentInfoPOJO();
                cip.setApprovedDate(Long.parseLong(tokens[0]));
                cip.setArticleID(tokens[1]);

                cip.setCommentID(Long.parseLong(tokens[3]));
                cip.setCommentType(tokens[4]);

                // createDateString
                cip.setCreateDate(Long.parseLong(tokens[5]));

                cip.setDepth(Integer.parseInt(tokens[6]));
                cip.setEditorsSelection(Boolean.parseBoolean(tokens[7].toLowerCase()));

                cip.setInReplyTo(Long.parseLong(tokens[8]));
                cip.setParentUserDisplayName(tokens[9]);

                cip.setRecommendations(Double.parseDouble(tokens[10]));

                cip.setUserDisplayName(tokens[12]);

                cip.setUserID(Long.parseLong(tokens[13]));

            } catch (NumberFormatException e) {
                //System.err.println(e.getMessage());
            }
        }

        return cip;

    }
}



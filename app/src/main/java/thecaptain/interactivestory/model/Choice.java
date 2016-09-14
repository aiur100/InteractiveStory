package thecaptain.interactivestory.model;

/**
 * Created by theCaptain on 5/20/16.
 */
public class Choice {
    private String  mText;
    private int     mNextPage;

    public Choice(String text,int nextPage){
        mText        = text;
        mNextPage    = nextPage;
    }

    public String getText() {
        return mText;
    }

    public void setText(String mText) {
        this.mText = mText;
    }

    public int getNextPage() {
        return mNextPage;
    }

    public void setNextPage(int mNextPage) {
        this.mNextPage = mNextPage;
    }
}

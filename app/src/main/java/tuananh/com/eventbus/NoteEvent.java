package tuananh.com.eventbus;

/**
 * Created by framgia on 27/06/2017.
 */
public class NoteEvent {
    private String mNote;

    public NoteEvent(String note) {
        mNote = note;
    }

    public String getNote() {
        return mNote;
    }
}

import java.util.LinkedList;

class MyCalendar {

    class Event {
        int mStart;
        int mEnd;

        public Event(int start, int end) {
            mStart = start;
            mEnd = end;
        }
    }

    LinkedList<Event> mEvents = null;

    public MyCalendar() {
        mEvents = new LinkedList<Event>();
    }
    
    public boolean book(int start, int end) {
        for (int i=0; i < mEvents.size(); i++) {
            Event event = mEvents.get(i);

            if (event.mEnd <= start) {
                continue;
            } else if (event.mStart < end) {
                return false;
            } else {
                mEvents.add(i, (new Event(start, end)));
                return true;
            }
        }

        mEvents.addLast((new Event(start, end)));
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
package sakref.yohan.mareu.di;

import sakref.yohan.mareu.service.DummyMeetingApiService;
import sakref.yohan.mareu.service.MeetingApiService;

public class DI {

    /**
     * Get always a new instance on @{@link MeetingApiService}. Useful for tests, so we ensure the context is clean.
     *
     * @return
     */
    public static MeetingApiService getNewInstanceApiService() {
        return new DummyMeetingApiService();
    }
}

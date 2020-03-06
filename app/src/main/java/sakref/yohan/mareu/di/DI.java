package sakref.yohan.mareu.di;

import sakref.yohan.mareu.service.DummyMeetingApiService;
import sakref.yohan.mareu.service.MeetingApiService;

public class DI {

    /**
     * Dependency injector to get instance of services
     */

    private static MeetingApiService service = new DummyMeetingApiService();

    /**
     * Get an instance on @{@link MeetingApiService}
     *
     * @return
     */
    public static MeetingApiService getMeetingApiService() {
        return service;
    }

    /**
     * Get always a new instance on @{@link MeetingApiService}. Useful for tests, so we ensure the context is clean.
     *
     * @return
     */
    public static MeetingApiService getNewInstanceApiService() {
        return new DummyMeetingApiService();
    }
}

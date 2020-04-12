package sakref.yohan.mareu.ui;


import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import sakref.yohan.mareu.R;
import sakref.yohan.mareu.di.DI;
import sakref.yohan.mareu.service.MeetingApiService;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MeetingInstrumentedTest extends Activity {

    private MeetingApiService meetingApiService;

    @Before
    public void setup(){meetingApiService = DI.getNewInstanceApiService();}

    @Rule
    public ActivityTestRule<MeetingInstrumentedTest> mActivityTestRule = new ActivityTestRule<>(MeetingInstrumentedTest.class);

    @Test
    public void DisplayDetailsActivityWithoutCreatingMeeting() {
        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.activity_meeting_list_add_meeting),isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction linearLayout = onView(
                allOf(childAtPosition(
                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                        0),
                        isDisplayed()));
        linearLayout.check(matches(isDisplayed()));
    }





    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

}

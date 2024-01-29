package tests.Weather;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Common.CommonTestData.create_success_status_COde;
import static Common.CommonTestData.success_status_COde;
import static Common.RequestBuilder.*;
import static org.hamcrest.Matchers.*;

@Test
@Feature("Weather")
@Story("Weather stations")
public class WeatherStationTests {

    @Description("As an api user i want to create a weather station")
    @Severity(SeverityLevel.CRITICAL)
    public void createWeatherStationTests() {
        createWeatherStationResponse().
                then().
                assertThat().
                statusCode(create_success_status_COde).
                body("ID",notNullValue());
    }

    @Description("As an api user i want to get recently created a weather station")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dependsOnMethods = "createWeatherStationTests")
    public void getWeatherStationTests() {
        getWeatherStationResponse().
                then().
                assertThat().
                statusCode(success_status_COde).
                body("id",notNullValue());
    }

    @Description("As an api user i want to created a weather station  with no name")
    @Severity(SeverityLevel.CRITICAL)
    public void createWeatherStationWithNoNameTests() {
        createWeatherStationWithNoNameResponse().
                then().
                assertThat().
                statusCode(400).
                body("message",containsString("Bad or zero length station name"));
    }
}

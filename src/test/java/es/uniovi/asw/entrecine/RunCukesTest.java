package es.uniovi.asw.entrecine;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.java.es.*;

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"html:target/cucumber"})
public class RunCukesTest {
}
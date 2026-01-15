package br.demoblaze.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void iniciarNavegador() {
        BaseSteps.openBrowser();
    }

    @After
    public void fecharNavegador() {
        BaseSteps.closeBrowser();
    }    
}

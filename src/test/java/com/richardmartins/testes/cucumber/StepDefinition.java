package com.richardmartins.testes.cucumber;

import com.richardmartins.testes.TestesApplication;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Header;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.verify.VerificationTimes;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ActiveProfiles("test")
@SpringBootTest
@CucumberContextConfiguration
@ContextConfiguration(loader = SpringBootContextLoader.class, classes = {TestesApplication.class})
public class StepDefinition {

    private static ClientAndServer mockServer = ClientAndServer.startClientAndServer(8788);

    Integer valor;

    @Before
    public void antes() {
        valor = 0;
    }

    @Quando("^somar o valor (\\d) com o (\\d)$")
    public void somar(Integer valor1, Integer valor2) {
        valor = valor1 + valor2;
    }

    @Entao("^o valor que ficou foi (\\d)$")
    public void valore(Integer valor) {
        Assert.assertEquals(valor, this.valor);
    }

    @Entao("^coisa e")
    public void asdf() {
        Assert.assertEquals(valor, this.valor);
    }

    public void mocktalcoisa() {
        HttpResponse httpResponse = HttpResponse.response()
                .withHeader(new Header("Content-Type", "application/json"))
                .withStatusCode(200);
        mockServer.when(HttpRequest.request()
                .withMethod("GET")
                .withPath("rest/v1/calcular"))
                .respond(httpResponse);
    }


    public void verificatalcoisa() {
        mockServer.verify(HttpRequest.request()
                .withMethod("GET")
                .withPath("rest/v1/calcular"), VerificationTimes.exactly(3));
    }

}

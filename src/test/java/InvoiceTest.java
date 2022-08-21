import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.revolut.invoices.Invoice;
import org.revolut.invoices.InvoiceCreateDTO;
import org.revolut.invoices.InvoiceService;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceTest {

    @Mock
    InvoiceService invoiceService;

    @Test
    public void test1() {
        when(invoiceService.create(any())).thenReturn(new Invoice("aaa"));

        InvoiceCreateDTO createDTO = new InvoiceCreateDTO();
        createDTO.setInvoiceNum("1234");
        createDTO.setClientName("andre");

        Invoice invoice = invoiceService.create(createDTO);
        assertEquals("aaa", invoice.getInvoiceNum());

        invoice = given()
                .contentType(ContentType.JSON)
                .body(createDTO, ObjectMapperType.JSONB)
                .when()
                .post("admin")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .as(Invoice.class, ObjectMapperType.JSONB);
    }
}

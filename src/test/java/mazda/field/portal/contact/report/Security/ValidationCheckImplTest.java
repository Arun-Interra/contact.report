package mazda.field.portal.contact.report.Security;

import mazda.field.portal.contact.report.dto.ContactReportByIssuesDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidationCheckImplTest {

    public List<String> issues = Arrays.asList("sup1", "sup2", "sup3");
    public ContactReportByIssuesDto contactReportByIssuesDto =
            new ContactReportByIssuesDto(" ","",""," ",issues);

    public ValidationCheckImpl validationCheck = new ValidationCheckImpl();

    String actual = validationCheck.RgnZoneDist(contactReportByIssuesDto);
    @Test
    void rgnZoneDist() {
        assertEquals("RZD",actual );
    }
}
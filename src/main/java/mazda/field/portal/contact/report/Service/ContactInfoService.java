package mazda.field.portal.contact.report.Service;

import mazda.field.portal.contact.report.dto.ContactReportByIssuesDto;

import java.util.List;

public interface ContactInfoService {

    //returns the primary filed of contact info based of the ContactReportByIssuesDto RequestBody
    List<ContactReportByIssuesDto> byIssues(ContactReportByIssuesDto contactReportByIssuesDto);
}

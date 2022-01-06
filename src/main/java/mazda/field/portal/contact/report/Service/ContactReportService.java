package mazda.field.portal.contact.report.Service;

import mazda.field.portal.contact.report.dto.ContactReportDto;

public interface ContactReportService {

     String submitReportData(ContactReportDto report);

     ContactReportDto findByContactReportId(long ContactreporId);

     void deleteReportById(long contactReportId);
}

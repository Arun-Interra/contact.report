package mazda.field.portal.contact.report.Service;

import mazda.field.portal.contact.report.Mapper.ContactInfoMapper;
import mazda.field.portal.contact.report.Mapper.ContactReportIssueStatusMapper;
import mazda.field.portal.contact.report.dto.ContactInfoDto;
import mazda.field.portal.contact.report.dto.ContactReportInfoDto;
import mazda.field.portal.contact.report.dto.ContactReportIssueStatusDto;
import mazda.field.portal.contact.report.entity.ContactReportInfo;

import javax.transaction.Transactional;
import java.util.List;

public interface ContactReportService {

     String submitReportData(ContactReportInfoDto report);

     ContactReportInfoDto findByContactReportId(long ContactreporId);

//     List<ContactReportIssueStatusDto> getContactReportByStatusIssues(String rgnCd);

//     String updateDraftReport(ContactReportInfoDto report);

     void deleteReportById(long contactReportId);
}

package mazda.field.portal.contact.report.Service;

import mazda.field.portal.contact.report.Mapper.ContactInfoMapper;
import mazda.field.portal.contact.report.Mapper.ContactReportIssueStatusMapper;
import mazda.field.portal.contact.report.dto.ContactInfoDto;
import mazda.field.portal.contact.report.dto.ContactReportInfoDto;
import mazda.field.portal.contact.report.dto.ContactReportIssueStatusDto;
import mazda.field.portal.contact.report.entity.ContactReportInfo;
import mazda.field.portal.contact.report.repository.ContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ContactReportServiceImpl implements ContactReportService{

    @Autowired
    private ContactInfoRepository contactInfoRepository;


    public String submitReportData(ContactReportInfoDto report) {
        String submission = "Unable to save contact report";
        try {
            if(report.getContactReport().getMetrics().size() > 0 &&
                    report.getContactReport().getDealerpersonnel().size() > 0) {
                contactInfoRepository.save(report.getContactReport());
                submission = "Saved Success";
            }
        } catch (Exception e) {
            submission = "Failed - Metrics | DealerPersonnel is missing";
        }
        return submission;
    }

    public ContactReportInfoDto findByContactReportId(long ContactreporId) {
        ContactReportInfoDto contactReportInfoDto = new ContactReportInfoDto();
        contactReportInfoDto.setContactReport(contactInfoRepository.findByContactReportId(ContactreporId));
        return contactReportInfoDto;
    }

    public List<ContactInfoDto> findByDlrCd(String dlrCd) {
        List<ContactReportInfo> DtoList = contactInfoRepository.findByDlrCd(dlrCd);
        return ContactInfoMapper.INSTANCE.CRInfoToCIDtoList(DtoList);
    }

    public List<ContactReportIssueStatusDto> getContactReportByStatusIssues(String rgnCd) {
        return contactInfoRepository.getContactReportByStatusIssues(rgnCd);
    }

    public String updateDraftReport(ContactReportInfoDto report){
        String updateStatus = "Unable to update report";
        long contactReportId= report.getContactReport().getContactReportId();
        contactInfoRepository.updateContactReportById(report.getContactReport(), contactReportId);
        return updateStatus;
    }

    @Transactional
    public void deleteReportById(long contactReportId){
        final int contactStatus = 0; // contactStatus 0 makes sure that the report is still a draft
        contactInfoRepository.deleteByContactReportIdAndContactStatus(contactReportId, contactStatus);
    }
}

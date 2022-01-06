package mazda.field.portal.contact.report.Service;

import mazda.field.portal.contact.report.Mapper.ContactInfoMapper;
import mazda.field.portal.contact.report.dto.ContactReportByDealershipDto;
import mazda.field.portal.contact.report.dto.ContactReportDto;
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


    public String submitReportData(ContactReportDto report) {
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

    public ContactReportDto findByContactReportId(long ContactreporId) {
        ContactReportDto contactReportDto = new ContactReportDto();
        contactReportDto.setContactReport(contactInfoRepository.findByContactReportId(ContactreporId));
        return contactReportDto;
    }

    public List<ContactReportByDealershipDto> findByDlrCd(String dlrCd) {
        List<ContactReportInfo> DtoList = contactInfoRepository.findByDlrCd(dlrCd);
        return ContactInfoMapper.INSTANCE.CRInfoToCIDtoList(DtoList);
    }

    @Transactional
    public void deleteReportById(long contactReportId){
        final int contactStatus = 0; // contactStatus 0 makes sure that the report is still a draft
        contactInfoRepository.deleteByContactReportIdAndContactStatus(contactReportId, contactStatus);
    }
}

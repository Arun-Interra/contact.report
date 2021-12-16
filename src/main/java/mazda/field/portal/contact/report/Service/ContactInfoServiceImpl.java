package mazda.field.portal.contact.report.Service;

import mazda.field.portal.contact.report.Security.ValidationCheckImpl;
import mazda.field.portal.contact.report.dto.ContactReportByIssuesDto;
import mazda.field.portal.contact.report.repository.ContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactInfoServiceImpl implements ContactInfoService {

    @Autowired
    private ContactInfoRepository contactInfoRepository;

    public ValidationCheckImpl validationCheck = new ValidationCheckImpl();

    @Override
    public List<ContactReportByIssuesDto> byIssues(ContactReportByIssuesDto contactReportByIssuesDto) {
        String category = validationCheck.RgnZoneDist(contactReportByIssuesDto);
        try {
            List<String> issuesFilter = contactReportByIssuesDto.getIssuesFilter();
            String rgnCd = contactReportByIssuesDto.getRgnCd();
            String zoneCd = contactReportByIssuesDto.getZoneCd();
            String districtCd = contactReportByIssuesDto.getDistrictCd();
            String dlrCd = contactReportByIssuesDto.getDlrCd();
            if(contactReportByIssuesDto.getIssuesFilter().size() >0) {
                //call the repository to run the query with dealerCode value
                if ("RZD".equals(category)) {
                    //call the repository to run the query with region-zone-district value
                    return contactInfoRepository.findBycurrentIssuesAndRgnCdAndZoneCdAndDistirctCd(rgnCd, zoneCd, districtCd, issuesFilter);
                } else if ("RZ".equals(category)) {
                    //call the repository to run the query with region-zone value
                    return contactInfoRepository.findBycurrentIssuesAndRgnCdAndZoneCd(rgnCd, zoneCd, issuesFilter);
                } else if ("R".equals(category)) {

                    return  contactInfoRepository.findBycurrentIssuesAndRgnCd(rgnCd, issuesFilter);
                } else if(dlrCd!= null && dlrCd.length() == 5){
                    //if delaer code is present call the byDealership query with dlrCd and issuesFilter
                    return contactInfoRepository.findBycurrentIssuesAndDlrCd(dlrCd, issuesFilter);
                }
                else {
                    return contactInfoRepository.findBycurrentIssues(issuesFilter);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

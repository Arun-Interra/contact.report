package mazda.field.portal.contact.report.controller;

import mazda.field.portal.contact.report.Service.ReportByIssuesService;
import mazda.field.portal.contact.report.dto.*;
import mazda.field.portal.contact.report.repository.ContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(path="/ContactReportInfo")
public class ContactInfoController {

    @Autowired
    ReportByIssuesService reportByIssuesService;

    @Autowired
    ContactInfoRepository contactInfoRepository;

    @PostMapping(value = "/byIssues")
    public List<ContactReportByIssuesDto> byIssues(@RequestBody FilterCriteria filterCriteria) {
        return reportByIssuesService.getReportByIssues(filterCriteria);
    }

    @PostMapping(value = "/byDealership")
    public List<ContactReportByDealershipDto> byDealership(@RequestBody FilterCriteria filterCriteria) {
        return contactInfoRepository.findByDlrCd(filterCriteria.getDlrCd(), filterCriteria.getIssuesFilter());
    }

}

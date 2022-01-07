package mazda.field.portal.contact.report.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mazda.field.portal.contact.report.Service.ReportByIssuesService;
import mazda.field.portal.contact.report.Service.ReportByMonthService;
import mazda.field.portal.contact.report.dto.*;
import mazda.field.portal.contact.report.repository.ContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="/ContactReportInfo")
public class ContactInfoController {

    @Autowired
    ContactInfoRepository contactInfoRepository;

    @Autowired
    ReportByIssuesService reportByIssuesService;

    @Autowired
    ReportByMonthService reportByMonthService;

    @PostMapping(value = "/byIssues")
    public List<ReportByIssuesDto> byIssues(@RequestBody FilterCriteria filterCriteria) {
        return reportByIssuesService.findReportByIssues(filterCriteria);
    }

    @PostMapping(value = "/byDealership")
    public List<ReportByDealershipDto> byDealership(@RequestBody FilterCriteria filterCriteria) {
        return contactInfoRepository.findByDlrCd(filterCriteria.getDlrCd(), filterCriteria.getIssuesFilter());
    }

    @PostMapping(value = "/byMonth")
    public List<ReportByMonthDto> byMonth(@RequestBody FilterCriteria filterCriteria) {
        return reportByMonthService.findReportByMonth(filterCriteria);
    }



}

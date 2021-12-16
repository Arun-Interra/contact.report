package mazda.field.portal.contact.report.controller;

import mazda.field.portal.contact.report.Service.ContactInfoService;
import mazda.field.portal.contact.report.Service.ContactInfoServiceImpl;
import mazda.field.portal.contact.report.dto.ContactInfoDto;
import mazda.field.portal.contact.report.dto.ContactReportByIssuesDto;
import mazda.field.portal.contact.report.dto.ContactReportInfoDto;
import mazda.field.portal.contact.report.dto.ContactReportIssueStatusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/ContactReportInfo")
public class ContactInfoController {

    @Autowired
    ContactInfoServiceImpl contactInfoServiceimpl;

    @PostMapping(value = "/byIssues")
    public List<ContactReportByIssuesDto> byIssues(@RequestBody ContactReportByIssuesDto contactReportByIssuesDto) {
        return contactInfoServiceimpl.byIssues(contactReportByIssuesDto);
    }



}

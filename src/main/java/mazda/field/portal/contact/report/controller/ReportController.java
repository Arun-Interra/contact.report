package mazda.field.portal.contact.report.controller;

import mazda.field.portal.contact.report.Service.ContactReportServiceImpl;
import mazda.field.portal.contact.report.dto.ContactInfoDto;
import mazda.field.portal.contact.report.dto.ContactReportIssueStatusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mazda.field.portal.contact.report.dto.ContactReportInfoDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/MFP/ContactReport")
public class ReportController {

	@Autowired(required = true)
	private ContactReportServiceImpl contactReportService;

	@PostMapping(value ="/submitReport")
    public String submitReportData(@Valid @RequestBody ContactReportInfoDto report) {
		return contactReportService.submitReportData(report);
	}

	@PostMapping(value ="/updateReport")
	public String updateReportData(@Valid @RequestBody ContactReportInfoDto report) {
		return contactReportService.updateDraftReport(report);
	}


	@PostMapping(value = "/deleteReportById")
	public void deleteReportById(@RequestBody long contactReportId) {
		contactReportService.deleteReportById(contactReportId);
	}

	@GetMapping(value = "/getReportById/{contactReportId}")
	public ContactReportInfoDto getReportById(@PathVariable long contactReportId) {
		return contactReportService.findByContactReportId(contactReportId);
	}

	@GetMapping(value = "/getDlrReport/{dlrCd}")
	public List<ContactInfoDto> getDlrReport(@PathVariable String dlrCd) {
		return contactReportService.findByDlrCd(dlrCd);
	}

	@GetMapping(value = "/getReportByStatusIssues/{rgnCd}")
	public List<ContactReportIssueStatusDto> getReport(@PathVariable String rgnCd) {

		return contactReportService.getContactReportByStatusIssues(rgnCd);
	}
}
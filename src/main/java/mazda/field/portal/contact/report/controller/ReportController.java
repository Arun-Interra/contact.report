package mazda.field.portal.contact.report.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mazda.field.portal.contact.report.dto.ContactInfoDto;
import mazda.field.portal.contact.report.dto.ReportSubmissionDto;
import mazda.field.portal.contact.report.dto.ContactReportIssueStatusDto;
import mazda.field.portal.contact.report.entity.ContactReportInfo;
import mazda.field.portal.contact.report.repository.ContactInfoRepository;

@RestController
@RequestMapping(path="/MFP/ContactReport")
public class ReportController {
	
	@Autowired
	private ContactInfoRepository contactInfoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping(value ="/submitReport")
    public void submitReportData(@RequestBody ReportSubmissionDto reportSubmissionDto) {
		
	contactInfoRepository.save(reportSubmissionDto.getContactReportInfo());
    }
	
	private static final int contactStatus = 0; // contactStatus 0 makes sure that the report is still a draft  
	@Transactional
	@GetMapping(value = "/deleteReportById/{contactReportId}")
	public void deleteReportById(@PathVariable long contactReportId) {
		 contactInfoRepository.deleteByContactReportIdAndContactStatus(contactReportId, contactStatus);
	}
	
	@GetMapping(value = "/getReportById/{contactReportId}")
	public ContactReportInfo getReportById(@PathVariable long contactReportId) {
		return contactInfoRepository.findByContactReportId(contactReportId);
	}

	@GetMapping(value = "/getReportByStatusIssues/{rgnCd}")
	public List<ContactReportIssueStatusDto> getReport(@PathVariable String rgnCd) {
		
		return contactInfoRepository.getContactReportByStatusIssues(rgnCd);
	}
	
	@GetMapping(value = "/getDlrReport/{dlrCd}")
	public List<ContactInfoDto> getReports(@PathVariable String dlrCd) {
		List<ContactReportInfo> contactReportInfo = contactInfoRepository.findByDlrCd(dlrCd);
		return contactReportInfo.stream().map(this::convertToContactInfoDto).collect(Collectors.toList());
	}
	

	private ContactInfoDto convertToContactInfoDto(ContactReportInfo contactReportInfo) {
		ContactInfoDto contactInfoDto = modelMapper.map(contactReportInfo, ContactInfoDto.class);
	    return contactInfoDto;
	}
	
	
}
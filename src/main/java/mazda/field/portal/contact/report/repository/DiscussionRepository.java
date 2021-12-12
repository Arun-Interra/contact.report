package mazda.field.portal.contact.report.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mazda.field.portal.contact.report.entity.ContactReportDiscussion;

@Repository
public interface DiscussionRepository extends CrudRepository<ContactReportDiscussion, Integer>{
	
	List<ContactReportDiscussion> findAll();
	
	
//	@Query(value = "SELECT new mazda.field.portal.contact.report.dto.ContactReportIssueStatusDto(cr.contact_report_id,cr.contact_status,d.topic) FROM ContactReportInfo cr Join Column cr.topic")
//	public List<ContactReportIssueStatusDto> getContactReportByIssues();
}

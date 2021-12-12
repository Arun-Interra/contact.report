package mazda.field.portal.contact.report.repository;

import java.util.List;

import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mazda.field.portal.contact.report.dto.ContactInfoDto;
import mazda.field.portal.contact.report.dto.ContactReportIssueStatusDto;
import mazda.field.portal.contact.report.entity.ContactReportInfo;

@Repository
@PropertySource("classpath:/appSql.properties")
public interface ContactInfoRepository extends JpaRepository<ContactReportInfo, Long>{
	
//	@Query(value = "SELECT new mazda.field.portal.contact.report.dto.ContactInfoDto"
//			+ "(cr.contactReportId,cr.dlrCd,cr.contactDt,"
//			+ "cr.contactLocation,cr.contactType,"
//			+ "cr.contactAuthor,cr.contactReviewer,cr.contactStatus) "
//			+ "FROM ContactReportInfo cr WHERE cr.dlrCd=:dlrCd")
//	public List<ContactInfoDto> getDlrContactReportInfo(@Param("dlrCd") String dlrCd);
	
	public List<ContactReportInfo> findByDlrCd(@Param("dlrCd") String dlrCd);
	
	public void deleteByContactReportIdAndContactStatus(@Param("contactReportId") long contactReportId, int contactStatus);
	
	
	public ContactReportInfo findByContactReportId(@Param("contactReportId") long contactReportId);
	
	@Query(value ="SELECT new mazda.field.portal.contact.report.dto.ContactReportIssueStatusDto" 
			     + "(d.dlrCd, cr.contactReportId, cr.contactStatus, di.topic)"
			     + "FROM Dealers d JOIN d.CRI cr JOIN cr.discussion di WHERE d.RGN_CD=:rgnCd")
	public List<ContactReportIssueStatusDto> getContactReportByStatusIssues(@Param("rgnCd") String rgnCd);
	
}
	

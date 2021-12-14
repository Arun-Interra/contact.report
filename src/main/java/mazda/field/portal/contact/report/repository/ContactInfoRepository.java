package mazda.field.portal.contact.report.repository;

import java.util.List;

import mazda.field.portal.contact.report.dto.ContactReportInfoDto;
import mazda.field.portal.contact.report.dto.ContactReportIssueStatusDto;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mazda.field.portal.contact.report.entity.ContactReportInfo;

@Repository
@PropertySource("classpath:/appSql.properties")
public interface ContactInfoRepository extends JpaRepository<ContactReportInfo, Long>{
	
//	@Query(value = "SELECT new mazda.field.portal.contact.report.dto.ContactInfoDto"
//			+ "(cr.contactReportId,cr.dlrCd,cr.contactDt,"
//			+ "cr.contactLocation,cr.contactType,"
//			+ "cr.contactAuthor,cr.contactReviewer,cr.contactStatus) "
//			+ "FROM ContactReportInfo cr WHERE cr.dlrCd=:dlrCd")
//	public List<ContactReportInfo> getDlrContactReportInfo(@Param("dlrCd") String dlrCd);

	@Modifying
	@Query(value = "update cr from ContactReportInfo cr set cr.contactDt='2021-12-13' where cr.contactReportId=:contactReportId and cr.contactStatus=0")
	public String updateContactReportById(@Param("report") ContactReportInfo report,@Param("contactReportId") long contactReportId);


	public ContactReportInfo findByContactReportId(@Param("contactReportId") long contactReportId);

	public List<ContactReportInfo> findByDlrCd(@Param("dlrCd") String dlrCd);
	
	@Query(value ="SELECT new mazda.field.portal.contact.report.dto.ContactReportIssueStatusDto"
			     + "(d.dlrCd, cr.contactReportId, cr.contactStatus, cr.currentIssues)"
			     + "FROM Dealers d JOIN d.CRI cr WHERE d.RGN_CD=:rgnCd")
	public List<ContactReportIssueStatusDto> getContactReportByStatusIssues(@Param("rgnCd") String rgnCd);

	public void deleteByContactReportIdAndContactStatus(@Param("contactReportId") long contactReportId, int contactStatus);
}
	

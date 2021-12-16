package mazda.field.portal.contact.report.repository;

import java.util.List;

import mazda.field.portal.contact.report.dto.ContactReportByIssuesDto;
import mazda.field.portal.contact.report.dto.ContactReportInfoDto;
import mazda.field.portal.contact.report.dto.ContactReportIssueStatusDto;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mazda.field.portal.contact.report.entity.ContactReportInfo;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
@PropertySource("classpath:/appSql.properties")
public interface ContactInfoRepository extends JpaRepository<ContactReportInfo, Long>{

//	@Modifying
//	@Query(value = "update cr from ContactReportInfo cr set cr.contactDt='2021-12-13' where cr.contactReportId=:contactReportId and cr.contactStatus=0")
//	public String updateContactReportById(@Param("report") ContactReportInfo report,@Param("contactReportId") long contactReportId);

	public ContactReportInfo findByContactReportId(@Param("contactReportId") long contactReportId);

	@Query(value = "select * from mfp_db.mfp_contact_report_info where dlr_cd=:dlrCd and current_issues  in :issues", nativeQuery = true)
	public List<ContactReportInfo> findByDlrCd(@Param("dlrCd") String dlrCd, @Param("issues") List<String> issues);

	public void deleteByContactReportIdAndContactStatus(@Param("contactReportId") long contactReportId, int contactStatus);

	public List<ContactReportInfo> findByDlrCd(String dlrCd);

	@Query(value = "SELECT new mazda.field.portal.contact.report.dto.ContactReportByIssuesDto" +
			"(d.RGN_CD, d.ZONE_CD, d.DISTRICT_CD, cr.dlrCd, d.DBA_NM, cr.contactReportId, cr.currentIssues) " +
			"FROM Dealers d JOIN d.CRI cr WHERE cr.currentIssues IN :currentIssues")
	public List<ContactReportByIssuesDto> findBycurrentIssues(@Param("currentIssues") List<String> currentIssues);

	@Query(value = "SELECT new mazda.field.portal.contact.report.dto.ContactReportByIssuesDto" +
			"(d.RGN_CD, d.ZONE_CD, d.DISTRICT_CD, cr.dlrCd, d.DBA_NM, cr.contactReportId, cr.currentIssues) " +
			"FROM Dealers d JOIN d.CRI cr WHERE cr.dlrCd=:dlrCd and cr.currentIssues IN :currentIssues")
	public List<ContactReportByIssuesDto> findBycurrentIssuesAndDlrCd(@Param("dlrCd") String dlrCd, @Param("currentIssues") List<String>currentIssues);

	@Query(value = "SELECT new mazda.field.portal.contact.report.dto.ContactReportByIssuesDto" +
			"(d.RGN_CD, d.ZONE_CD, d.DISTRICT_CD, cr.dlrCd, d.DBA_NM, cr.contactReportId, cr.currentIssues) " +
			"FROM Dealers d JOIN d.CRI cr WHERE d.RGN_CD=:rgnCd and cr.currentIssues IN :currentIssues")
	public List<ContactReportByIssuesDto> findBycurrentIssuesAndRgnCd(@Param("rgnCd") String rgnCd, @Param("currentIssues") List<String> currentIssues);

	@Query(value = "SELECT new mazda.field.portal.contact.report.dto.ContactReportByIssuesDto" +
			"(d.RGN_CD, d.ZONE_CD, d.DISTRICT_CD, cr.dlrCd, d.DBA_NM, cr.contactReportId, cr.currentIssues) " +
			"FROM Dealers d JOIN d.CRI cr WHERE d.RGN_CD=:rgnCd and  d.ZONE_CD=:zoneCd and cr.currentIssues IN :currentIssues")
	public List<ContactReportByIssuesDto> findBycurrentIssuesAndRgnCdAndZoneCd(
			@Param("rgnCd") String rgnCd, @Param("zoneCd") String zoneCd, @Param("currentIssues") List<String> currentIssues);

	@Query(value = "SELECT new mazda.field.portal.contact.report.dto.ContactReportByIssuesDto" +
			"(d.RGN_CD, d.ZONE_CD, d.DISTRICT_CD, cr.dlrCd, d.DBA_NM, cr.contactReportId, cr.currentIssues) " +
			"FROM Dealers d JOIN d.CRI cr WHERE d.RGN_CD=:rgnCd and d.RGN_CD=:rgnCd and d.ZONE_CD=:zoneCd and d.DISTRICT_CD=:districtCd and cr.currentIssues IN :currentIssues")
	public List<ContactReportByIssuesDto> findBycurrentIssuesAndRgnCdAndZoneCdAndDistirctCd(
			@Param("rgnCd") String rgnCd, @Param("zoneCd") String zoneCd, @Param("districtCd") String districtCd, @Param("currentIssues") List<String> currentIssues);
}
	

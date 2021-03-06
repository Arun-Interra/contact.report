package mazda.field.portal.contact.report.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReportByDealershipDto {

	private String rgnCd;

	private String zoneCd;

	private String districtCd;

	private String dlrCd;

	private String dlrNm;

	private long contactReportId;
	
	private LocalDate contactDt;
	
	private String contactAuthor;
	
	private int contactStatus;
	
	private String currentIssues;

}

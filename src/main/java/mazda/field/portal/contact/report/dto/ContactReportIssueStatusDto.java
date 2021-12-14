package mazda.field.portal.contact.report.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContactReportIssueStatusDto {
	
	private String dlrCd;
	private long contactReportId;
	private int contactStatus;
	private String currentIssues;
	
	
}

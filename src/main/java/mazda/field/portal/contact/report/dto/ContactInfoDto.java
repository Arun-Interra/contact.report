package mazda.field.portal.contact.report.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContactInfoDto {

	private long contactReportId;
	
	private String dlrCd;
	
	private LocalDate contactDt;
	
	private String contactAuthor;
	
	private int contactStatus;
	
	private String currentIssues;

}

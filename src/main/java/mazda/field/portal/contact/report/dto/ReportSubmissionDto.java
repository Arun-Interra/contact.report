package mazda.field.portal.contact.report.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mazda.field.portal.contact.report.entity.ContactReportInfo;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReportSubmissionDto {

	private ContactReportInfo contactReportInfo;
}

package mazda.field.portal.contact.report.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContactReportByIssuesDto {

    private String rgnCd;

    private String zoneCd;

    private String districtCd;

    private String dlrCd;

    private String dlrName;

    private long contactReportId;

    private String currentIssues;

    private List<String> issuesFilter;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;

    public ContactReportByIssuesDto(String rgnCd,
                                    String zoneCd,
                                    String districtCd,
                                    String s3,
                                    List<String> issues) {
    }
    public ContactReportByIssuesDto(String rgnCd, String zoneCd, String districtCd, String dlrCd,
                                    String dlrName, long contactReportId, String currentIssues) {
        this.rgnCd = rgnCd;
        this.zoneCd = zoneCd;
        this.districtCd = districtCd;
        this.dlrCd = dlrCd;
        this.dlrName = dlrName;
        this.contactReportId = contactReportId;
        this.currentIssues = currentIssues;

    }
}

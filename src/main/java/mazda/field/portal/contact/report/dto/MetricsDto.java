package mazda.field.portal.contact.report.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mazda.field.portal.contact.report.entity.ContactReportMetrics;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class MetricsDto {

	private int metrics_id;
	private String metrics_name;
	private double metrics_value;
	private LocalDate metrics_dt;

}

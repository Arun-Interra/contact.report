package mazda.field.portal.contact.report.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Transactional
@Table(name = "mfp_contact_report_metrics")
public class ContactReportMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int metrics_id;
    
    @NotNull
	private String metricsName;
    
    @NotNull
	private double metricsValue;
    
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate metricsDt;

}

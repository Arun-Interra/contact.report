package mazda.field.portal.contact.report.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "mfp_contact_report_discussion")
public class ContactReportDiscussion {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long discussionId;

    @NotNull
	private String topic;

    @NotNull
	private String discussion;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull
	private LocalDate disscussionDt;
	
}

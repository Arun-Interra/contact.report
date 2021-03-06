package mazda.field.portal.contact.report.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
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
@Table(name = "mfp_contact_report_info")
public class ContactReportInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long contactReportId;
	
	@NotNull
	private String dlrCd;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull
	private LocalDate contactDt;

	@NotNull
	private String contactLocation;

	@NotNull
	private String contactType;

	private String currentIssues;
	
	@NotNull
	private String contactAuthor;
	
	@NotNull
	private String contactReviewer;

	@NotNull
	private int contactStatus;
	
	

	@OneToMany(targetEntity = ContactReportDealerPersonnel.class, cascade = CascadeType.ALL)
	@JoinColumn(name="contactReportIdFk", referencedColumnName="contactReportId", nullable = false)
	@NotNull
	private List<ContactReportDealerPersonnel> dealerpersonnel;

	@OneToMany(targetEntity = ContactReportMetrics.class, cascade = CascadeType.ALL)
	@JoinColumn(name="contactReportIdFk", referencedColumnName="contactReportId", nullable = false)
	@NotNull
	private List<ContactReportMetrics> metrics;
	
	@OneToMany(targetEntity = ContactReportDiscussion.class, cascade = CascadeType.ALL)
	@JoinColumn(name="contactReportIdFk", referencedColumnName="contactReportId")
	private List<ContactReportDiscussion> discussion;
	
	@OneToMany(targetEntity = ContactReportAttachment.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "contactReportIdFk", referencedColumnName="contactReportId")
	private List<ContactReportAttachment> attachment;

//	@ManyToOne(targetEntity = Dealers.class, cascade = CascadeType.ALL)
//	@JoinColumn(name="dlrCd", updatable = false, insertable = false)
//	@NotNull
//	private Dealers dealers;

}

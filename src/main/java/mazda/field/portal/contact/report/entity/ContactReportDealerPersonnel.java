package mazda.field.portal.contact.report.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Transactional
@Table(name = "mfp_contact_report_dealerpersonnel")
public class ContactReportDealerPersonnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long personnelId;

    @NotNull
	private String dealerContacts;  

}

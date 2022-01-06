package mazda.field.portal.contact.report.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.data.jpa.provider.HibernateUtils;

import javax.persistence.EntityManagerFactory;
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


}

package mazda.field.portal.contact.report.Security;

import mazda.field.portal.contact.report.dto.FilterCriteria;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Predicate;

public interface ValidationCheck {

     Predicate RgnZoneDist(EntityManager em, FilterCriteria filterCriteria);
}

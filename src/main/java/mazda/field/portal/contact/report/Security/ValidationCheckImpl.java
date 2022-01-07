package mazda.field.portal.contact.report.Security;

import mazda.field.portal.contact.report.dto.ReportByIssuesDto;
import mazda.field.portal.contact.report.dto.FilterCriteria;
import mazda.field.portal.contact.report.entity.ContactReportInfo;
import mazda.field.portal.contact.report.entity.Dealers;

import javax.persistence.EntityManager;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ValidationCheckImpl implements ValidationCheck{
//    @PersistenceUnit
//    public EntityManagerFactory entityManagerFactory;
//
//    public EntityManager em = entityManagerFactory.createEntityManager();
    @Override
    public Predicate RgnZoneDist(EntityManager em, FilterCriteria filterCriteria) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ReportByIssuesDto> query = cb.createQuery(ReportByIssuesDto.class);

        String region = filterCriteria.getRgnCd();
        String zone = filterCriteria.getZoneCd();
        String district = filterCriteria.getDistrictCd();
        String dealer = filterCriteria.getDlrCd();
        List<String> issues = filterCriteria.getIssuesFilter();

        Root<Dealers> d = query.from(Dealers.class);
        Root<ContactReportInfo> cr = query.from(ContactReportInfo.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(d.get("dlrCd"),cr.get("dlrCd"))); //0 th predicate
        predicates.add(cr.get("currentIssues").in(issues));  //1 st predicate

        if( region.length() > 0 && zone.length()<=0  && district.length()<=0 && dealer.length()<=0){
            predicates.add(cb.equal(d.get("rgnCd"),filterCriteria.getRgnCd()));

            return cb.and(predicates.get(0));
        }
        else if( region.length() >0 && zone.length()>0 && district.length()<=0 && dealer.length()<=0){
            predicates.add(cb.equal(d.get("rgnCd"),region));
            predicates.add(cb.equal(d.get("zoneCd"),zone));

            return cb.and(predicates.get(0),predicates.get(1),
                          predicates.get(2),predicates.get(3));

        }
        else if( region.length()>0 && zone.length()>0  && district.length()>0 && dealer.length()<=0){
            predicates.add(cb.equal(d.get("rgnCd"),region));
            predicates.add(cb.equal(d.get("zoneCd"),zone));
            predicates.add(cb.equal(d.get("districtCd"),district));

            return cb.and(predicates.get(0),predicates.get(1),
                          predicates.get(2),predicates.get(3),predicates.get(4));

        }
        else if( dealer.length()>0){
            predicates.add(cb.equal(cr.get("dlrCd"),dealer));

            return cb.and(predicates.get(0),predicates.get(1),predicates.get(2));


        }
        return null;
    }
}

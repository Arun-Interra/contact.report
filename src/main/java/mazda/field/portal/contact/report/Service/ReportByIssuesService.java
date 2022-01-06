package mazda.field.portal.contact.report.Service;


import mazda.field.portal.contact.report.dto.ContactReportByIssuesDto;
import mazda.field.portal.contact.report.dto.FilterCriteria;
import mazda.field.portal.contact.report.entity.ContactReportInfo;
import mazda.field.portal.contact.report.entity.Dealers;
import mazda.field.portal.contact.report.repository.ContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportByIssuesService {

   @PersistenceContext
   public EntityManager em;

   public List<ContactReportByIssuesDto> getReportByIssues(FilterCriteria filterCriteria) {

         CriteriaBuilder cb = em.getCriteriaBuilder();
         CriteriaQuery<ContactReportByIssuesDto> query = cb.createQuery(ContactReportByIssuesDto.class);

         String region = filterCriteria.getRgnCd();
         String zone = filterCriteria.getZoneCd();
         String district = filterCriteria.getDistrictCd();
         String dealer = filterCriteria.getDlrCd();
         List<String> issues = filterCriteria.getIssuesFilter();
         LocalDate startDate = filterCriteria.getStartDate();
         LocalDate endDate = filterCriteria.getEndDate();

         Root<Dealers> d = query.from(Dealers.class);
         Root<ContactReportInfo> cr = query.from(ContactReportInfo.class);

         List<Predicate> predicates = new ArrayList<>();
         predicates.add(cb.equal(d.get("dlrCd"), cr.get("dlrCd"))); //0 th predicate
         predicates.add(cr.get("currentIssues").in(issues));  //1 st predicate
         predicates.add(cb.between(cr.get("contactDt"),startDate, endDate));

         if (region.length() > 0 && zone.length() <= 0 && district.length() <= 0 && dealer.length() <= 0) {
            predicates.add(cb.equal(d.get("rgnCd"), filterCriteria.getRgnCd()));

         } else if (region.length() > 0 && zone.length() > 0 && district.length() <= 0 && dealer.length() <= 0) {
            predicates.add(cb.equal(d.get("rgnCd"), region));
            predicates.add(cb.equal(d.get("zoneCd"), zone));

         } else if (region.length() > 0 && zone.length() > 0 && district.length() > 0 && dealer.length() <= 0) {
            predicates.add(cb.equal(d.get("rgnCd"), region));
            predicates.add(cb.equal(d.get("zoneCd"), zone));
            predicates.add(cb.equal(d.get("districtCd"), district));

         }

         query = query.multiselect(d.get("rgnCd"), d.get("zoneCd"), d.get("districtCd"), d.get("dlrCd"),
                 d.get("dlrNm"), cr.get("contactReportId"), cr.get("currentIssues"), cr.get("contactStatus")).where(predicates.toArray(new Predicate[0]));

         TypedQuery<ContactReportByIssuesDto> tq = em.createQuery(query);

         return tq.getResultList();

      }
   }

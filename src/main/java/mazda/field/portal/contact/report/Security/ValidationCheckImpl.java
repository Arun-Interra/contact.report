package mazda.field.portal.contact.report.Security;

import mazda.field.portal.contact.report.dto.ContactReportByIssuesDto;
import org.springframework.context.annotation.Bean;

public class ValidationCheckImpl implements ValidationCheck{

    @Override
    public String RgnZoneDist(ContactReportByIssuesDto contactReportByIssuesDto) {
        try{
            int[] category = new int[]{contactReportByIssuesDto.getRgnCd().length(),
                                    contactReportByIssuesDto.getZoneCd().length(),
                                    contactReportByIssuesDto.getDistrictCd().length()};
            if(contactReportByIssuesDto.getIssuesFilter().size() > 0){
                if(category[0] >0 && (category[1] >0) && (category[2] >0)){
                    return "RZD";
                }
                else if((category[0] >0) && (category[1]>0)&& (category[2]==0)){
                    return "RZ";
                }
                else if((category[0]>0) && (category[1]==0)&& (category[2]==0)){
                    return "R";
                }
            }
            else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

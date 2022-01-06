package mazda.field.portal.contact.report.Mapper;

import mazda.field.portal.contact.report.dto.ContactReportByDealershipDto;
import mazda.field.portal.contact.report.entity.ContactReportInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContactInfoMapper {

    ContactInfoMapper INSTANCE = Mappers.getMapper( ContactInfoMapper.class );

    //    @Mapping(target = "contactReportId")
    ContactReportByDealershipDto CRInfoToCIDto (ContactReportInfo contactreportinfo);
    List<ContactReportByDealershipDto> CRInfoToCIDtoList (List<ContactReportInfo> contactreportinfo);


}

package mazda.field.portal.contact.report.Mapper;

import mazda.field.portal.contact.report.dto.ContactInfoDto;
import mazda.field.portal.contact.report.entity.ContactReportInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContactInfoMapper {

    ContactInfoMapper INSTANCE = Mappers.getMapper( ContactInfoMapper.class );

    //    @Mapping(target = "contactReportId")
    ContactInfoDto CRInfoToCIDto (ContactReportInfo contactreportinfo);
    List<ContactInfoDto> CRInfoToCIDtoList (List<ContactReportInfo> contactreportinfo);


}

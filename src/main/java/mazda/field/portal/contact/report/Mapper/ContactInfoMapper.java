package mazda.field.portal.contact.report.Mapper;

import org.mapstruct.Mapper;

import mazda.field.portal.contact.report.dto.ContactInfoDto;
import mazda.field.portal.contact.report.entity.ContactReportInfo;

@Mapper
public interface ContactInfoMapper {
	
	ContactInfoDto modelToDto(ContactReportInfo contactreportinfo);

}

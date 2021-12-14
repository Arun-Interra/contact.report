package mazda.field.portal.contact.report.Mapper;

import mazda.field.portal.contact.report.dto.ContactReportIssueStatusDto;
import mazda.field.portal.contact.report.entity.ContactReportInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContactReportIssueStatusMapper {

    ContactReportIssueStatusMapper INSTANCE = Mappers.getMapper(ContactReportIssueStatusMapper.class);

    ContactReportIssueStatusDto CrIssueStatusToDto (ContactReportInfo contactReportInfo);

    List<ContactReportIssueStatusDto> CrIssueStatusToDto (List<ContactReportInfo> contactReportInfo);
}

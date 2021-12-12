package mazda.field.portal.contact.report.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DealerPersonnelDto {

	private long personnelId;
	private String dealerContacts;
}

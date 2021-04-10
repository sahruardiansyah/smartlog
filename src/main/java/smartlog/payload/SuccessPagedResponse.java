package smartlog.payload;

import java.util.List;

/**
 * SuccessPagedResponse Paged response container wrapper class, extends from {@link SuccessResponse}
 * Generic data type
 * <br>
 * <br>
 * <p><b>Attributes: </b></p>
 * <p><b>content</b> Generic data type of {@link PagedResponse} </p>
 * <br>
 * @author Tom
 */
public class SuccessPagedResponse<T> extends SuccessResponse {
	
	private PagedResponse<T> content;
	
    public SuccessPagedResponse(String message, List<T> content, int page, int size, long totalElements, int totalPages, boolean last) {
    	super(message);
    	this.setContent(new PagedResponse<T>(content, page, size, totalElements, totalPages, last));
    }

	public PagedResponse<T> getContent() {
		return content;
	}

	public void setContent(PagedResponse<T> content) {
		this.content = content;
	}
    
}

package API;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiRespone {

    private String message;
    private String status;
}

/**
 * Copyright (c) 2023 Jala University.
 *
 * This software is the confidential and proprieraty information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jala University.
 */

package logincucumber.entities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
* This class is responsible for configuring the username and password fields for use in tests.
*
* @author Alvaro Sivila
* @version 1.0
*/

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Entity {
    @Getter @Setter
    private String username;
    @Getter @Setter
    private String password;
}

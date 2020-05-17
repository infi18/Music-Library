/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.config;

import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

/**
 *
 * @author siddhi
 */
@Named
@ApplicationScoped
@CustomFormAuthenticationMechanismDefinition(loginToContinue
        = @LoginToContinue(loginPage = "/login.xhtml",
                errorPage = "/error.xhtml")
)
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "java:app/jdbc/itmd4515DS",
        callerQuery = "select PASSWORD from Security_User where USERNAME = ?",
        groupsQuery = "select GROUPNAME from Security_User_Groups where USERNAME = ?"
)
@DeclareRoles({"Administrator", "Listener"})
public class SecurityConfig {

}

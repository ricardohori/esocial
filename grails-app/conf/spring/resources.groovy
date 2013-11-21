import br.com.synchro.grails.gui.integration.AuthService
import br.com.synchro.SecurityService
import br.com.synchro.esocial.conector.gateway.repository.config.ConfigPropertyRepositoryImpl
import br.com.synchro.dynamic.DynamicControllerFactory

// Place your Spring DSL code here
beans = {

    authService(AuthService)
    securityService(SecurityService)

    /** Config Property **/
    configPropertyRepository(ConfigPropertyRepositoryImpl)

    /* ################################# Other beans ################################## */
    dynamicControllerFactory(DynamicControllerFactory){bean->
        bean.autowire = "byName"
        grailsApplication = ref("grailsApplication")
    }

}

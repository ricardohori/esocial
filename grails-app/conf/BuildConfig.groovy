grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {
    // inherit Grails" default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes "ehcache"
    }
    log "error" // log level of Ivy resolver, either "error", "warn", "info", "debug" or "verbose"
    checksums true // Whether to verify checksums on resolve
    legacyResolve true // whether to do a secondary resolve on plugin installation, not advised but here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenLocal()
        mavenCentral()

        mavenRepo "http://172.27.2.78:8081/nexus/content/groups/public/"

        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either "build", "compile", "runtime", "test" or "provided" scopes eg.

        // runtime "mysql:mysql-connector-java:5.1.22"
        compile("org.apache.camel:camel-ftp:2.12.1")

        //Embedded Jetty dependencies
        compile("org.eclipse.jetty:jetty-server:8.1.7.v20120910"){
            excludes([group: "org.eclipse.jetty.orbit"]) // Dependencia na pasta lib (jetty-servlet-api-3.0.0.v201112011016.jar) por bug no Ivy
        }
        compile("org.eclipse.jetty:jetty-webapp:8.1.7.v20120910"){
            excludes([group: "org.eclipse.jetty.orbit"]) // Dependencia na pasta lib (jetty-servlet-api-3.0.0.v201112011016.jar) por bug no Ivy
        }
        compile("org.eclipse.jetty:jetty-continuation:8.1.7.v20120910"){
            excludes([group: "org.eclipse.jetty.orbit"]) // Dependencia na pasta lib (jetty-servlet-api-3.0.0.v201112011016.jar) por bug no Ivy
        }


    }

    plugins {
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.7.1"
        runtime ":resources:1.1.6"

        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0"
        //runtime ":cached-resources:1.0"
        //runtime ":yui-minify-resources:0.1.5"

        build ":tomcat:$grailsVersion"

        runtime ":database-migration:1.3.2"

        compile(":grails-gui:2.3.0", ":syn-framework:1.1.0-SNAPSHOT"){
            excludes "hibernate", "release", "geb", "svn"
        }

        compile ":dynamic-config:0.3", ":routing:1.2.8"


        test(":spock:0.7")

        compile ":cache:1.0.1"
    }
}

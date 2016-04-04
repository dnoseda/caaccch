grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }

    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'

    repositories {

        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenLocal()

        mavenRepo "http://repo.grails.org/grails/libs-releases-local"
        mavenRepo "http://maven.melicloud.com/nexus/content/repositories/fury"
        mavenRepo "http://repo.grails.org/grails/plugins-releases"
        mavenRepo "http://maven.melicloud.com/nexus/content/groups/Arquitectura"
        mavenRepo "http://maven.melicloud.com/nexus/content/repositories/MLGrailsPlugins"
        mavenRepo "http://maven.melicloud.com/nexus/content/groups/ML"
        mavenRepo "http://maven.melicloud.com/nexus/content/groups/public"

        mavenRepo "http://git.ml.com:8081/nexus/content/groups/Arquitectura"
        mavenRepo "http://git.ml.com:8081/nexus/content/repositories/MLGrailsPlugins"

        mavenRepo "http://files.couchbase.com/maven2"
        mavenRepo "http://repo.grails.org/grails/plugins-releases-local"
        mavenRepo "http://repo.grails.org/grails/plugins"
    }

    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.13'
        compile 'fury.java:metric_collector:0.0.3'
        
        compile "com.fury:furyutils:0.0.1"
        compile('com.amazonaws:elasticache-java-cluster-client:1.0.61.0') {
          exclude 'spring-beans'
        }
    }
    
}
